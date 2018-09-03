package fedejandro.encuestadigital;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.nio.charset.Charset;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainScreen extends AppCompatActivity {

    EditText fechaText;
    EditText encuestadorText;
    EditText consecutivoText;
    Button nextButton;

    private String filename = "datos.txt";
    private String filepath = "EncuestaDatos";
    File myExternalFile;
    String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        fechaText = (EditText) findViewById(R.id.fechaText);
        encuestadorText = (EditText) findViewById(R.id.encuestadorText);
        consecutivoText = (EditText) findViewById(R.id.consecutivoText);

        nextButton =
                (Button) findViewById(R.id.nextButton);
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
}
