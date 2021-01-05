import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrisijungimoApp
{
    public static void main (String[] args)
    {
        // BufferedReader ivedimas = new BufferedReader(new InputStreamReader(System.in));
        Scanner ivedimas = new Scanner(System.in);

        int skaicius = 100;

        int ivestasSkaicius = ivedimas.nextInt();



        if (skaicius == ivestasSkaicius)
        {
            System.out.println("skaiciai vienodi");
        }
        else
        {
            System.out.println("neveinodi");
        }


        String vartotojoUsername = ivedimas.next();
        String vartotojoPassword = ivedimas.next();



        String tikrasisUsername = "vartotojas123";
        String tikrasisPassword = "slaptazodis589";

        System.out.println("Vartotojas: " + vartotojoUsername);
        System.out.println("Slaptazodis: " + vartotojoPassword);
        if (arTinkaPrisijungimas(vartotojoUsername, vartotojoPassword, tikrasisUsername, tikrasisPassword))
        {
            System.out.println("Jus prisijungete");
        }
        else
        {
            System.out.println("Neteisingi prisijungimo duomenys");
        }
    }

    public static boolean arTinkaPrisijungimas(String vartotojoUsername, String vartotojoPassword, String tikrasisUsername, String tikrasisPassword)
    {
        boolean arTinka;

        if ((vartotojoUsername == tikrasisUsername) && (vartotojoPassword == tikrasisPassword))
        {
            arTinka = true;
          //  return true;
        }
        else
        {
            arTinka = false;
          //  return false;
        }
        return arTinka;
    }


}
