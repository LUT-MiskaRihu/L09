package lut.l09;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Bind UI elements to variables.
    Context context = null;
    Spinner spinTheatres = null;
    EditText etDate = null;
    EditText etTimeMin = null;
    EditText etTimeMax = null;

    // Initialize arrays for information storage.
    ArrayList<Theatre> arrTheatres = null;
    ArrayList<Show> arrShows = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        context = getApplicationContext();

        spinTheatres = findViewById(R.id.spinTheatres);
        etDate = findViewById(R.id.etDate);
        etTimeMin = findViewById(R.id.etTimeMin);
        etTimeMax = findViewById(R.id.etTimeMax);

        arrTheatres = ReadXML.getTheatres();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void search(View view) {
        arrShows = ReadXML.getShows();
        String sDate = etDate.getText().toString();
        String sTimeMin = etTimeMin.getText().toString();
        String sTimeMax = etTimeMax.getText().toString();
        LocalDateTime ldtStartDateTimeMin = null;
        LocalDateTime ldtStartDateTimeMax = null;

        try {
            ldtStartDateTimeMin = LocalDateTime.parse(sDate + 'T' + sTimeMin, DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}