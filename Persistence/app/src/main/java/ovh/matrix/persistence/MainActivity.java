package ovh.matrix.persistence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    private Button btnWriteData;
    private TextView txtFilename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFilename = (TextView) findViewById(R.id.txtFilename);

        btnWriteData = (Button) findViewById(R.id.btnWriteData);
        btnWriteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String filename = txtFilename.getText().toString();

                if (!getFileStreamPath(filename).exists()) {

                    try {

                        writeFile(filename);

                        String text = readFile(filename);
                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private void writeFile(String filename) throws IOException {

        FileOutputStream outputStream = openFileOutput(filename, MODE_PRIVATE);
        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.write("Testing from writefile...");

        printWriter.close();
        outputStream.close();
    }


    private String readFile(String filename) throws IOException {

        FileInputStream inputStream = openFileInput(filename);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String result = "";

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result = result + line;
        }

        bufferedReader.close();
        inputStream.close();

        return result;
    }
}
