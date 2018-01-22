package com.wc3.verrigombia.botonerawc3;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mp = new MediaPlayer();
        List<Integer> buttons = new ArrayList<>();
        buttons.add(R.id.button_1);
        buttons.add(R.id.button_2);
        buttons.add(R.id.button_3);
        buttons.add(R.id.button_4);
        buttons.add(R.id.button_5);
        for(Integer element : buttons) {
            Button b = findViewById(element);

            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if(mp.isPlaying())
                    {
                        mp.stop();
                    }
                    try {
                        mp.reset();
                        AssetFileDescriptor afd;
                        Button button = (Button)v;
                        afd = getAssets().openFd(button.getText().toString() + ".mp3");
                        mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                        mp.prepare();
                        mp.start();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
