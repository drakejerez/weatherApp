/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author chloeclawson
 */
public class Recommendations{
    public void recs(){
        Clothes f = new Clothes();
        clothesGroup g = new clothesGroup();
        Person h = new Person();
        ArrayList a = f.clothesSorter();
        ArrayList b = g.clothesSorter();
        int c = h.getPref();
        if(c==1){
            String d = "add layer";
            
            
        }
        else if(c==2){
            String d = "keep as is";
            
        }
        else if (c==3){
            String d = "remove layer";
        }
        
        System.out.println(h.getName+", according to the weather in your area you should wear"+ a + b + "based off your personal preferences you should"+ d);

    }


}
