package ua.nure.practtask4;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText Name, Age, FileData;
    Button btnSavePrefs, btnLoadPrefs, btnSaveDB, btnLoadDB, btnSaveFile, btnLoadFile;
    TextView Results;

    SharedPreferences sharedPreferences;
    SQLiteDatabase db;
    DBHelper dbHelper;
    static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.etName);
        Age = findViewById(R.id.etAge);
        FileData = findViewById(R.id.etFileData);
        btnSavePrefs = findViewById(R.id.btnSavePrefs);
        btnLoadPrefs = findViewById(R.id.btnLoadPrefs);
        btnSaveDB = findViewById(R.id.btnSaveDB);
        btnLoadDB = findViewById(R.id.btnLoadDB);
        btnSaveFile = findViewById(R.id.btnSaveFile);
        btnLoadFile = findViewById(R.id.btnLoadFile);
        Results = findViewById(R.id.tvResults);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        btnSavePrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToPreferences();
            }
        });

        btnLoadPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFromPreferences();
            }
        });

        btnSaveDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDatabase();
            }
        });

        btnLoadDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFromDatabase();
            }
        });

        btnSaveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile();
            }
        });

        btnLoadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFromFile();
            }
        });
    }


    private void saveToDatabase() {
        ContentValues values = new ContentValues();
        values.put("name", Name.getText().toString());
        values.put("age", Integer.parseInt(Age.getText().toString()));
        db.insert("users", null, values);
        Toast.makeText(this, "Дані збережено у SQLite Database", Toast.LENGTH_SHORT).show();
    }

    private void loadFromDatabase() {
        Cursor cursor = db.query("users", null, null, null, null, null, null);
        StringBuilder builder = new StringBuilder();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
            builder.append("Name: ").append(name).append(", Age: ").append(age).append("\n");
        }
        cursor.close();
        Results.setText(builder.toString());
    }


    private void saveToPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", Name.getText().toString());
        editor.putString("age", Age.getText().toString());
        editor.apply();
        Toast.makeText(this, "Дані збережено у SharedPreferences", Toast.LENGTH_SHORT).show();
    }

    private void loadFromPreferences() {
        String name = sharedPreferences.getString("name", "No name defined");
        String age = sharedPreferences.getString("age", "No age defined");
        Results.setText("Name: " + name + "\nAge: " + age);
    }

    private void saveToFile() {
        String fileData = FileData.getText().toString();
        try (FileOutputStream fos = openFileOutput("file_text.txt", Context.MODE_PRIVATE)) {
            fos.write(fileData.getBytes());
            Toast.makeText(this, "Дані збережено у file", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        StringBuilder builder = new StringBuilder();
        try (FileInputStream fis = openFileInput("file_text.txt")) {
            int c;
            while ((c = fis.read()) != -1) {
                builder.append((char) c);
            }
            Results.setText(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "MyDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY, name TEXT, age INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}