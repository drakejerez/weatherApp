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
public class clothesGroup extends Clothes{
    public ArrayList clothesEditor(){
        
        ArrayList e = clothesSorter();
        String[] d = Weather.filterReport();
        
        if(Integer.parseInt(d[2])>65){
           String humidity = "Based off of humidity it is recommended to remove a layer";
    }
        if((Integer.parseInt(d[4])> 3)&&(Integer.parseInt(d[2])<50)){
            String wind = "Based off of wind speed and temperature, it is recommended to add a layer";
    }
    }
    
    
}
