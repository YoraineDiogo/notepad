package com.example.a1diogy15.fileio;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String dir_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        EditText edit = (EditText) findViewById(R.id.notes);

        if(item.getItemId() == R.id.save)
        {
            // react to the menu item being selected...
            try {
                FileWriter fw = new FileWriter(dir_path + "/notes.txt");
                PrintWriter pw = new PrintWriter(fw);

                pw.println(edit.getText());
                pw.flush();
                pw.close();
            }
            catch(IOException e)
            {
                System.out.println ("I/O Error: " + e.getMessage());
            }
            return true;
        }

        else if(item.getItemId() == R.id.load)
        {
            // react to the menu item being selected...
            try {
                FileReader fr = new FileReader(dir_path + "/notes.txt");
                BufferedReader reader = new BufferedReader(fr);
                edit.setText(reader.readLine());
                reader.close();
            }
                catch(IOException e)
                {
                    System.out.println ("I/O Error: " + e.getMessage());
                }
                return true;
        }
        return false;
    }

}
