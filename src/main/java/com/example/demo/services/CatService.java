package com.example.demo.services;

import com.example.demo.models.CatFact;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class CatService {
    ArrayList<CatFact> catList = new ArrayList<>();

    public CatFact getSingleCatFact() throws IOException{
        URL catURL = new URL("https://cat-fact.herokuapp.com/facts/random");
        BufferedReader inputFromCatURL = new BufferedReader(new InputStreamReader(catURL.openStream()));
        CatFact data = new Gson().fromJson(inputFromCatURL, CatFact.class);
        inputFromCatURL.close();

        return data;
    }

    public String getTen() throws IOException{
        for (int i=0; i<10; i++){
            catList.add(getSingleCatFact());
        }
        return catList.toString();
    }

    public String getTenSortByDate() throws IOException{
      getTen();
      Collections.sort(catList);
      return catList.toString();
    }

    public String contains(char c, int amount) throws IOException{
        CatFact data = getSingleCatFact();
        int count = 0;
        for (int i=0; i<data.getText().length(); i++){
            if (data.getText().charAt(i)==c){
                count++;
            }
        }
        if (count>=amount){
            return "Congratulations, your character ("+c+") is contained at least ("+count+") amount of times in the cat fact!";
        } else {
            return "Sorry no luck";
        }
    }
}
