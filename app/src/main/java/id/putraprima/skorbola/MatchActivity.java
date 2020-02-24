package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    public static final String HOME_KEY = "home";
    public static final String AWAY_KEY = "away";
    public static final String HOME_SCORE_KEY = "home_score";
    public static final String AWAY_SCORE_KEY = "away_score";

    private TextView homeText;
    private TextView awayText;

    private TextView homeScoreText;
    private TextView awayScoreText;

    private ImageView homeImage;
    private ImageView awayImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        homeScoreText = findViewById(R.id.score_home);
        homeScoreText = findViewById(R.id.score_away);
        Bundle extras = getIntent().getExtras();
        if (extras != null ){
            String home = extras.getString(MainActivity.HOME_KEY);
            String away = extras.getString(MainActivity.AWAY_KEY);
            homeText.setText(home);
            awayText.setText(away);
        }



        //TODO
        //1.Menampilkan detail match sesuai data dari main activity

        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
