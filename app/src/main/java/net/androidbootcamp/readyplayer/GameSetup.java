package net.androidbootcamp.readyplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.net.Uri;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameSetup extends AppCompatActivity {
    int numPlayers;
    String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

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

        Button nextPage = (Button) findViewById(R.id.btnEventSetup);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameSetup.this, EventSetup.class));
            }
        });

    }

}
