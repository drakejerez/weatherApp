package com.example.layerz;
// Author: Drake Jerez
// CNIT25501 Final Project
// Note: Grayed out text can be enabled again to display things in Logcat terminal
//       inside of android studio IDE. Do this if something breaks to debug o7

public class person
{
    // A LOT OF THIS HAS TO BE REWRITTEN TO GEL WITH THE GUI
    // TO DO:
    // - make getWeather, return numbers
    //clothesGroup 

    private String name;
    private static String[] location = new String[3];
    private int tempPreference;
    public person(String name, String city, String state, String country, int prefNumber)
    {
        //Scanner input = new Scanner(System.in);
        setName(name);
        setLocation(city, state, country);
        setPref(prefNumber);
        //input.close();
    }

    private void setName(String name)
    {
        //Scanner input = new Scanner(System.in);
        // THIS IS CODE FOR THE TERMINAL VERSION OF THE PROGRAM
        /*
        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();
        //input.close();
        this.name = firstName + " " + lastName;
         */
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    private void setLocation(String city, String state, String country)
    {
        //Scanner input = new Scanner(System.in);
        // THIS IS CODE FOR THE TERMINAL VERSION OF THE PROGRAM
        /*
        System.out.println("Enter your city: ");
        String city = input.nextLine();
        city = city.replaceAll(" ", "%20");
        while (city.length() <=1)
        {
            System.out.println("Improper city name length. Please enter the full city name: ");
            city = input.nextLine().replaceAll(" ", "%20");
        }
        
        System.out.println("Enter your ISO state/province code: ");
        String state = input.nextLine().toUpperCase();
        while ((state.length() > 3))
        {
            System.out.println("Improper code. Please use the ISO 3166-2 State/Province code: ");
            state = input.nextLine().toUpperCase();
        }

        System.out.println("Enter your two letter ISO country code: ");
        String country = input.nextLine().toUpperCase();

        while ((country.length() != 2))
        {
            System.out.println("Improper code. Please use the two letter ISO 3166-2 country code: ");
            country = input.nextLine().toUpperCase();
        }

        //input.close();
        */
        this.location[0] = city;
        this.location[1] = state;
        this.location[2] = country;

    }

    public String[] getLocation()
    {
        return this.location;
    }

    private void setPref(int pref)
    {
        // THIS WILL PROBABLY CHANGE WITH THE GUI
        // THIS IS CODE FOR THE TERMINAL VERSION OF THE PROGRAM
        /*
        System.out.println("Do you prefer to be warmer or colder? Please enter 1 for warmer, 2 if you don't have a"
         + "preference, or 3 for warmer");
        //Scanner input = new Scanner(System.in);
        // normal colder warmer
        String pref = input.nextLine();

        while ((pref.length() != 1) || ((pref != "0") || (pref != "1")))
        {
            System.out.println("Improper input. Please enter 0 for colder or 1 for warmer");
            pref = input.nextLine();
        }
        this.tempPreference = pref;
         */
        this.tempPreference = pref;
    }

    public int getPref()
    {
        return this.tempPreference;
    }
}
