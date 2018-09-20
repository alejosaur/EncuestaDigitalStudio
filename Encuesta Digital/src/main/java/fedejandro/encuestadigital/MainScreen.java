package fedejandro.encuestadigital;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Calendar;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    EditText fechaText;
    EditText encuestadorText;
    EditText consecutivoText;
    Button nextButton, fechaButton, downloadButton;
    private int day, month, year;

    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        fechaText = (EditText) findViewById(R.id.fechaText);
        encuestadorText = (EditText) findViewById(R.id.encuestadorText);
        consecutivoText = (EditText) findViewById(R.id.consecutivoText);

        encuestadorText.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        fechaButton = (Button) findViewById(R.id.fechaButton);
        fechaButton.setOnClickListener(this);

        nextButton =  (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = new FileOutputStream(myExternalFile,true);
                    fos.write(("\n" +
                            "").getBytes());
                    fos.write(fechaText.getText().toString().getBytes());
                    fos.write("\t".getBytes());
                    fos.write(consecutivoText.getText().toString().getBytes());
                    fos.write("\t".getBytes());
                    fos.write(encuestadorText.getText().toString().getBytes());
                    fos.close();

                    Intent preg1 = new Intent(getApplicationContext(), Preguntas1.class);
                    startActivity(preg1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        downloadButton =  (Button) findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                compartirArchivo();
            }
        });

        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            nextButton.setEnabled(false);
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v==fechaButton){
            final Calendar myCalendar = Calendar.getInstance();
            day=myCalendar.get(Calendar.DAY_OF_MONTH);
            month=myCalendar.get(Calendar.MONTH);
            year=myCalendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            , year, month, day);
            datePickerDialog.show();
        }

    }

    private void compartirArchivo(){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + myExternalFile.getAbsolutePath()));
        startActivity(Intent.createChooser(sharingIntent, "share file with"));
    }

}
