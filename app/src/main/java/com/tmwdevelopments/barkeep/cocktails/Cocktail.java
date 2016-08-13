package com.tmwdevelopments.barkeep.cocktails;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tom on 5/30/2016.
 */
public class Cocktail {

    private String cocktailName;
    private String mainIngredient;
    private List<String> ingredients;
    private List<String> directions;
    private final String DEFAULT_STRING = "DEFAULT";
    public static List<Cocktail> cocktailList = new ArrayList<>();
    public static Map<String, Cocktail> cocktailMap = new HashMap<String, Cocktail>();

    public Cocktail(String cocktailName, String mainIngredient){
        setCocktailName(cocktailName);
        setMainIngredient(mainIngredient);
        ingredients = new ArrayList<>();
        directions = new ArrayList<>();
    }

    private void setCocktailName(String cocktailName){
        if (cocktailName != null && !cocktailName.equals("")){
            this.cocktailName = cocktailName;
        }
        else{
            this.cocktailName = DEFAULT_STRING;
        }
    }

    public String getCocktailName(){
        return this.cocktailName;
    }

    private void setMainIngredient(String mainIngredient){
        if (mainIngredient != null && !mainIngredient.equals("")){
            this.mainIngredient = mainIngredient;
        }
        else{
            this.mainIngredient = DEFAULT_STRING;
        }
    }

    public String getMainIngredient(){
        return this.mainIngredient;
    }

    public void addIngredient(String ingredient){
        if (ingredient != null && !ingredient.equals("")){
            this.ingredients.add(ingredient);
        }
    }

    public List<String> getIngredients(){
        return this.ingredients;
    }

    public void addDirection(String direction){
        if (direction != null && !direction.equals("")){
            this.directions.add(direction);
        }
    }

    public List<String> getDirections(){
        return this.directions;
    }

    public void setIngredients(List<String> ingredients){
        this.ingredients = ingredients;
    }

    public void setDirections(List<String> directions){
        this.directions = directions;
    }

}
