package com.tmwdevelopments.barkeep;

import android.util.JsonReader;

import com.tmwdevelopments.barkeep.cocktails.Cocktail;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 6/5/2016.
 */
public class JsonParser {

    public List readJsonStream(InputStream in) throws IOException{
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try{
            return readCocktailArray(reader);
        }
        finally {
            reader.close();
        }
    }


    public List readCocktailArray(JsonReader reader) throws IOException {
        List cocktails = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()){
            cocktails.add(readCocktail(reader));
        }
        reader.endArray();
        return cocktails;
    }


    public Cocktail readCocktail(JsonReader reader) throws IOException {
        String drinkName = null;
        String mainIngredient = null;
        List ingredients = new ArrayList();
        List directions = new ArrayList();

        reader.beginObject();
        while (reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("drink_name")){
                drinkName = reader.nextString();
            }
            else if (name.equals("main_ingredient")){
                mainIngredient = reader.nextString();
            }
            else if (name.equals("ingredients")){
                ingredients = readArray(reader);
            }
            else if (name.equals("directions")){
                directions = readArray(reader);
            }
            else{
                reader.skipValue();
            }
        }
        reader.endObject();
        Cocktail cocktail = new Cocktail(drinkName, mainIngredient);
        cocktail.setIngredients(ingredients);
        cocktail.setDirections(directions);
        Cocktail.cocktailList.add(cocktail);
        Cocktail.cocktailMap.put(drinkName, cocktail);
        return cocktail;
    }


    public List readArray(JsonReader reader) throws IOException {
        List array = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()){
            array.add(reader.nextString());
        }
        reader.endArray();
        return array;
    }


}
