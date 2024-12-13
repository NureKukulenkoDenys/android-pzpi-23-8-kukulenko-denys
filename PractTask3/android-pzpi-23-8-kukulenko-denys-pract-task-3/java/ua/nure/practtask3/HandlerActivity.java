package ua.nure.practtask3;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HandlerActivity extends AppCompatActivity {

    private Handler mainHandler;
    private Handler backgroundHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        Button startHandlerButton = findViewById(R.id.startHandlerButton);
        TextView handlerMessageTextView = findViewById(R.id.handlerMessageTextView);

        mainHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                handlerMessageTextView.setText("Отримано повідомлення: " + msg.what);
            }
        };

        HandlerThread handlerThread = new HandlerThread("BackgroundThread");
        handlerThread.start();
        backgroundHandler = new Handler(handlerThread.getLooper());

        startHandlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Message message = mainHandler.obtainMessage();
                        message.what = 1;
                        mainHandler.sendMessage(message);
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backgroundHandler.getLooper().quit();
    }
}
