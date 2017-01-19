package com.fish.version2asset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv= (TextView) findViewById(R.id.aa);
        tv.setText(getAssetsString());
    }

    private String getAssetsString() {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("runtime_config");
            int size = inputStream.available();
            int len = -1;
            byte[] bytes = new byte[size];
            inputStream.read(bytes);
            inputStream.close();
            String string = new String(bytes);
            Log.d("aa", string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }


}
