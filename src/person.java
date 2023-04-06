import java.io.IOException;
import java.security.Permission;
import java.util.Scanner;

public class person 
{
    // A LOT OF THIS HAS TO BE REWRITTEN TO GEL WITH THE GUI
    // PATIENCE!!!

    // TO DO:
    // - 
    private String name;
    private static String[] location = new String[3];
    private String tempPreference;

    public static void main(String[] args) throws IOException, InterruptedException
    {
        person user = new person();
        weatherGroup userWeather = new weatherGroup(location[0], location[1], location[2]);
    }

    public person()
    {
        // PREF THINGS NEED TO BE CODED :((
        Scanner input = new Scanner(System.in);
        setName(input);
        setLocation(input);
        //setPref(input);
        input.close();
    }

    private void setName(Scanner input)
    {
        //Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = input.nextLine();
        //input.close();

        this.name = firstName + " " + lastName;
    }

    public String getName()
    {
        return this.name;
    }

    private void setLocation(Scanner input)
    {
        //Scanner input = new Scanner(System.in);

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

        this.location[0] = city;
        this.location[1] = state;
        this.location[2] = country;

    }

    private String[] getLocation()
    {
        return this.location;
    }

    private void setPref(Scanner input)
    {
        // THIS WILL PROBABLY CHANGE WITH THE GUI
        System.out.println("Do you prefer to be warmer or colder? Please enter 0 for colder or 1 for warmer");
        //Scanner input = new Scanner(System.in);
        String pref = input.nextLine();

        while ((pref.length() != 1) || ((pref != "0") || (pref != "1")))
        {
            System.out.println("Improper input. Please enter 0 for colder or 1 for warmer");
            pref = input.nextLine();
        }
        this.tempPreference = pref;
    }
}
