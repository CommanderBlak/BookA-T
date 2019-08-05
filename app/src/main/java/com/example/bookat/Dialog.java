package com.example.bookat;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Dialog extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_layout);

        Spinner dateSpinner = (Spinner) findViewById(R.id.spinnerDatePicker);
        Spinner timeSpinner = (Spinner) findViewById(R.id.spinnerTimePicker);

        ArrayAdapter<CharSequence> dateAdapter = ArrayAdapter.createFromResource(this, R.array.dates, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(this, R.array.times, android.R.layout.simple_spinner_item);

        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dateSpinner.setAdapter(dateAdapter);
        timeSpinner.setAdapter(timeAdapter);
///////////////////////////////////////////////////////////////////////////////

        ImageView moviePoster = (ImageView) findViewById(R.id.moviePoster);
        TextView titleDialog = (TextView) findViewById(R.id.titleDialog);
        TextView runTime = (TextView) findViewById(R.id.runTime);
        Intent intent = getIntent();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            int resId = bundle.getInt("poster");
            moviePoster.setImageResource(resId);
        }


        String title = intent.getStringExtra("title");
        titleDialog.setText(title);
        titleDialog.setTextSize(18);

        String runT = intent.getStringExtra("runtime");
        runTime.setText(runT);
        runTime.setTextSize(16);


        Button btn = (Button) findViewById(R.id.bookTicket);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailDialogBox();
            }
        });





    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void emailDialogBox() {
        new AlertDialog.Builder(this)
                .setTitle("TICKET BOOKED")
                .setMessage("Send ticket as PDF to your email?")
                .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Dialog.this, "TICKET sent to your email", Toast.LENGTH_LONG).show();
                        Intent toHome = new Intent(Dialog.this, HomeActivity.class);
                        startActivity(toHome);

                    }
                }).create().show();

    }
}
