/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.*;
/**
 *
 * @author chloeclawson
 */
public class Clothes {

    /**
     * @param args the command line arguments
     */
    
  
    public Map dictionaryTops(){
        
        String[] longSleeve = {"Long sleeved shirt","Sweatshirt","Sweater"};
        //create top dictionary
        Map top = new HashMap();
        top.put("1","Tanktop");
        top.put(2,"T-shirt");
        top.put(3,longSleeve);
        
        return top;
    }
    public Map dictionaryBottoms(){
        //create bottoms dictionary
        Map bottoms = new HashMap();
        bottoms.put(1, "Shorts");
        bottoms.put(2,"Jeans");
        bottoms.put(3,"Sweatpants");
        return bottoms;
    }
    public Map dictionaryOut(){
        String[] rain = {"umbrella","Rain Jacket"};
        String[] snow = {"coat","hat","gloves"};
        //create jackets dictionary
        Map outerwear = new HashMap();
        outerwear.put("Rain",rain);
        outerwear.put("Snow",snow);
        return outerwear;
    }
    public Map dictionaryShoes(){
        //create shoes dictionary
        Map shoes = new HashMap();
        shoes.put(1,"Sandals");
        shoes.put(2, "Sneakers");
        shoes.put(3, "Boots");
        
        return shoes;
        
    }
        
        
    
    public ArrayList clothesSorter(){
        ArrayList outfit = new ArrayList();
        String obj = makeWeatherReport();
        
        Map shirt = dictionaryTops();
        Map pants = dictionaryBottoms();
        Map shoes = dictionaryShoes();
        Map outerwear = dictionaryOut();
       
        
     
        
        if(obj.contains("Warm")){
            outfit.add(shirt.get(1));
            outfit.add(pants.get(1));
            outfit.add(shoes.get(1));
        }
        else if(obj.contains("Normal")){
            outfit.add(shirt.get(2));
            outfit.add(pants.get(2));
            outfit.add(shoes.get(2));
        }
        else if(obj.contains("Freezing")){
            outfit.add(shirt.get(3));
            outfit.add(pants.get(3));
            outfit.add(shoes.get(3));
        }
        else if(obj.contains("Rain")){
            outfit.add(outerwear.get("Rain"));
            
        }
        else if(obj.contains("Freezing")&(obj.contains("Rain"))){
            outfit.add(outerwear.get("Snow"));
        }
        
        return outfit;
        
        
    }
}

