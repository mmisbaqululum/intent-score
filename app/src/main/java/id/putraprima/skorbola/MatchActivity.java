package id.putraprima.skorbola;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MatchActivity extends AppCompatActivity {

//    public static final String HOME_KEY = "home";
//    public static final String AWAY_KEY = "away";
//    public static final String HOME_SCORE_KEY = "home_score";
//    public static final String AWAY_SCORE_KEY = "away_score";
    private static final String STATUS_KEY = "status";

    private int homeScoreValue = 0;
    private int awayScoreValue = 0;
    private TextView homeText;
    private TextView awayText;
    private TextView homeScoreText;
    private TextView awayScoreText;
    private ImageView homeImage;
    private ImageView awayImage;
    String homename;
    String awayname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);


        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        homeScoreText = findViewById(R.id.score_home);
        awayScoreText = findViewById(R.id.score_away);
        homeImage = findViewById(R.id.home_logo);
        awayImage = findViewById(R.id.away_logo);


        Bundle extras = getIntent().getExtras();
        Uri imageHomeUri = Uri.parse(extras.getString("imageHome"));
        Uri imageAwayUri = Uri.parse(extras.getString("imageAway"));
        if (extras != null ){
            String homename = extras.getString(MainActivity.HOME_KEY);
            String awayname = extras.getString(MainActivity.AWAY_KEY);

            homeText.setText(homename);
            awayText.setText(awayname);
            try {
                Bitmap homeImageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageHomeUri);
                Bitmap awayImageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageAwayUri);
                homeImage.setImageBitmap(homeImageBitmap);
                awayImage.setImageBitmap(awayImageBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        //TODO
        //1.Menampilkan detail match sesuai data dari main activity

        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }


    public void handleHomeScore(View view) {

        homeScoreValue = Integer.valueOf(homeScoreText.getText().toString());
        homeScoreValue++;
        homeScoreText.setText(String.valueOf(homeScoreValue));
    }


    public void handleAwayScore(View view) {

        awayScoreValue = Integer.valueOf(awayScoreText.getText().toString());
        awayScoreValue++;
        awayScoreText.setText(String.valueOf(awayScoreValue));
    }


    public void handleResult(View view) {
        Intent i = new Intent(this, ResultActivity.class);
//        String status = null;
//        i.putExtra(STATUS_KEY, status);
        if (homeScoreValue == awayScoreValue ){
            i.putExtra(STATUS_KEY, "Draw");
        }else if (homeScoreValue > awayScoreValue){
            i.putExtra(STATUS_KEY,"Name of Winning :"+homeText.getText().toString());
        }else if (homeScoreValue < awayScoreValue) {
            i.putExtra(STATUS_KEY, "Name of Winning :" + awayText.getText().toString());
        }
        startActivity(i);

    }
}
