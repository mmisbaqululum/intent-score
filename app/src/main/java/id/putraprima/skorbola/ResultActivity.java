package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    private TextView end;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        end = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            end.setText(extras.getString("end"));
            result.setText(extras.getString("result"));
        }
    }
}
