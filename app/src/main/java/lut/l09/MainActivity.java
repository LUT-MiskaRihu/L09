package lut.l09;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // Bind UI elements to variables.
    Context context = null;
    Spinner spinTheatres = null;
    EditText etDate = null;
    EditText etTimeMin = null;
    EditText etTimeMax = null;
    ListView lvResults = null;

    ArrayList<ListedShow> arrShows = new ArrayList<>();

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
        lvResults = findViewById(R.id.lvResults);

        SavedData.arrTheatres = ReadXML.getTheatres();

        ArrayAdapter theatreAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                ReadXML.getTheaterNames()
        );
        theatreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinTheatres.setAdapter(theatreAdapter);
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    public void search(View view) {
        System.out.println("########## Search started. ##########");
        SavedData.arrShows = ReadXML.getShows();

        Filter filter = new Filter();

        for (Theatre t : SavedData.arrTheatres) {
            if (t.getName() == spinTheatres.getSelectedItem().toString()) {
                filter.locationID = t.getID();
                System.out.println("Selected location: " + filter.locationID);
                break;
            }
        }

        for (ListedShow ls : SavedData.arrShows) {
            if (ls.getLocationID() == filter.locationID) {

            }
        }

        System.out.println("########## Search ended. ##########");

        ArrayAdapter showAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_2,
                ReadXML.getShowsAsString()
        );
        lvResults.setAdapter(showAdapter);

        /*
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy-HH:mm", Locale.ENGLISH);
        String sDate = etDate.getText().toString();
        String sTimeMin = etTimeMin.getText().toString();
        String sTimeMax = etTimeMax.getText().toString();

        try {
            Date dateStartDateTimeMin = formatter.parse(sDate + "-" + sTimeMin);
            //Date dateStartDateTimeMax = formatter.parse(sDate + "-" + sTimeMax);

            @SuppressLint("DefaultLocale") String sDate2 = String.format(
                    "%02d.%02d.%04d",
                    dateStartDateTimeMin.getDay(),
                    dateStartDateTimeMin.getMonth(),
                    dateStartDateTimeMin.getYear()
            );

            System.out.println(sDate2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateStartDateTimeMax = null;



        /*
        LocalDateTime ldtStartDateTimeMin = null;
        LocalDateTime ldtStartDateTimeMax = null;

        try {
            ldtStartDateTimeMin = LocalDateTime.parse(sDate + 'T' + sTimeMin, DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm"));
        } catch (Exception e) {
            e.printStackTrace();
        }

         */
    }
}