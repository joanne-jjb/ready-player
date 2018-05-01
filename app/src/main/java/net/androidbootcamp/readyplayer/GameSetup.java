package net.androidbootcamp.readyplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameSetup extends AppCompatActivity {
    int numPlayers;
    String output = "";

    Button playMusic;
    MediaPlayer mpPoco;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        //inputs
        final EditText players = (EditText) findViewById(R.id.inputNumber);

        final RadioButton firstPlayer = (RadioButton) findViewById(R.id.radFirst);
        final RadioButton pickScorekeeper = (RadioButton) findViewById(R.id.radGroups);

        final TextView result = (TextView) findViewById(R.id.result);

        Button selectPlayer = (Button) findViewById(R.id.btnSelect);
        selectPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    numPlayers = Integer.parseInt(players.getText().toString());
                    Random randGen = new Random();
                    int player = randGen.nextInt(numPlayers - 1) + 1;
                    String selectedPlayer = Integer.toString(player);

                    if (firstPlayer.isChecked()) {
                        output = "Player " + selectedPlayer + " is first player.";
                        result.setText(output);
                    } else if (pickScorekeeper.isChecked()) {
                        output = "Player " + selectedPlayer + " is the scorekeeper.";
                        result.setText(output);
                    } else {
                        Toast.makeText(GameSetup.this, "Please select player selection option.", Toast.LENGTH_LONG).show();
                    }
                } catch(Exception e) {
                    Toast.makeText(GameSetup.this, "Please complete all inputs.", Toast.LENGTH_LONG).show();
                }

            }
        });

        playMusic = (Button) findViewById(R.id.btnGameMusic);
        playMusic.setOnClickListener(bPoco);

        mpPoco = new MediaPlayer();
        mpPoco = MediaPlayer.create(this, R.raw.pocolocosong);
        playing = 0;
    }

    Button.OnClickListener bPoco = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpPoco.start();
                    playing = 1;
                    playMusic.setText("Pause Un Poco Loco");
                    break;
                case 1:
                    mpPoco.pause();
                    playing = 0;
                    playMusic.setText("Play Un Poco Loco");
                    break;
            }
        }
    };
}
