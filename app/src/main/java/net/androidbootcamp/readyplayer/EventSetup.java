package net.androidbootcamp.readyplayer;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventSetup extends AppCompatActivity {
    AnimationDrawable danceAnimation;
    Button playMusic, orderPizza;
    MediaPlayer mpMusic;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_setup);

        ImageView imgFrame=(ImageView)findViewById(R.id.imgDance);
        imgFrame.setBackgroundResource(R.drawable.animation);
        danceAnimation = (AnimationDrawable) imgFrame.getBackground( );
        final Button button1 = (Button) findViewById(R.id.btnDance);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danceAnimation.start();
                button1.setVisibility(View.GONE);
            }
        });

        playMusic = (Button) findViewById(R.id.btnGameMusic);
        playMusic.setOnClickListener(bMusic);

        mpMusic = new MediaPlayer();
        mpMusic = MediaPlayer.create(this, R.raw.levels);
        playing = 0;

        orderPizza = (Button) findViewById(R.id.btnPizza);
        orderPizza.setOnClickListener(bPizza);
    }

    Button.OnClickListener bMusic = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpMusic.start();
                    playing = 1;
                    playMusic.setText("Pause Music \"Levels\"");
                    break;
                case 1:
                    mpMusic.pause();
                    playing = 0;
                    playMusic.setText("Play Music \"Levels\"");
                    break;
            }
        }
    };

    Button.OnClickListener bPizza = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://deweyspizza.com/")));
        }
    };
}
