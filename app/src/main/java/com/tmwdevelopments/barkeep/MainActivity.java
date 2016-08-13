package com.tmwdevelopments.barkeep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readCocktailJsonFile();
        Intent intent = new Intent(this, CocktailListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart(){
        super.onStart();

    }

    public void goToList(View view) {
        Intent intent = new Intent(this, CocktailListActivity.class);
        startActivity(intent);
    }


    public void readCocktailJsonFile(){
        JsonParser parser = new JsonParser();
        InputStream cocktailJsonFile = null;
        try{
            cocktailJsonFile = getAssets().open("cocktails.json");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try {
            parser.readJsonStream(cocktailJsonFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
