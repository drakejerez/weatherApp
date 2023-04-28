/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.layerz;

import java.util.ArrayList;

/**
 *
 * @author chloeclawson
 */
public class Recommendations{
    // GUI notes by drake, modifications to code may be made
    // make recs take a person as a parameter? Probably the easiest thing to do no?
    // recommendations doesnt have a constructor in its original form, maybe make the constructor
    // to replace the code in recs? No its fine as is android studio just screamed at me

    public String recs(person user, weatherGroup today){
        Clothes f = new Clothes();
        clothesGroup g = new clothesGroup();
        //person h = new person();
        ArrayList a = f.clothesSorter(today.getGroup());
        ArrayList b = g.clothesSorter(today.getGroup());
        int c = user.getPref();


        String msg = "You should wear " + a + b + ", based off your personal preferences you should";
        String d = "";
        if(c==1){
            d = " add a layer";
            msg = msg + d;
        }
        else if(c==2){
            d = " keep as is";
            msg = msg + d;
        }
        else if (c==3){
            d = " remove a layer";
            msg = msg + d;
        }

        //String msg = "You should wear "+ a + ", based off your personal preferences you should"+ d;
        return msg;
    }
}