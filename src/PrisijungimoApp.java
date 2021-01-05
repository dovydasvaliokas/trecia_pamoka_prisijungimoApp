import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrisijungimoApp
{
    public static void main (String[] args)
    {
        // BufferedReader ivedimas = new BufferedReader(new InputStreamReader(System.in));
        Scanner ivedimas = new Scanner(System.in);
     /*   int skaicius = 100;
        int ivestasSkaicius = ivedimas.nextInt();*/
     /*   if (skaicius == ivestasSkaicius)
        {
            System.out.println("skaiciai vienodi");
        }
        else
        {
            System.out.println("neveinodi");
        }*/


        String vartotojoUsername = ivedimas.next();
     //   String vartotojoUsernameGavimoBudas = "Gavo per Scanner";
        String vartotojoPassword = ivedimas.next();


        int vartotojoMetai = ivedimas.nextInt();

        while (vartotojoMetai < 0)
        {
            System.out.println("Blogai ivesti metai. Iveskite per naujo: ");
            vartotojoMetai = ivedimas.nextInt();
        }
       /*  Neveikiantis tikrinimo budas, kadangi tikrina tik viena syki - o po to vartotojas vel gali klaidingai ivedineti
        if (vartotojoMetai < 0)
        {
            System.out.println("Blogai ivesti metai. Iveskite per naujo: ");
            vartotojoMetai = ivedimas.nextInt();
        }*/
        int vartotojoMenuo = ivedimas.nextInt();
        while ((vartotojoMenuo <= 0) || (vartotojoMenuo > 12))
        {
            System.out.println("Blogai ivestas menuo. Iveskite per naujo: ");
            vartotojoMenuo = ivedimas.nextInt();
        }

        int vartotojoDiena = ivedimas.nextInt();
        while ((vartotojoDiena <= 0) || (vartotojoDiena > 31))
        {
            System.out.println("Blogai ivesta diena. Iveskite per naujo: ");
            vartotojoDiena = ivedimas.nextInt();
        }



        String tikrasisUsername = "vartotojas123";
     //   String tikrasisUsernameGavimoBUdas = "Gavo per Koda";
        String tikrasisPassword = "slaptazodis589";

        System.out.println("Vartotojas: " + vartotojoUsername);
        System.out.println("Slaptazodis: " + vartotojoPassword);
        System.out.println("Gimimo data: " + gimimoDataPerBruksniukus(vartotojoMetai, vartotojoMenuo, vartotojoDiena));

        // Tikriname ar vartotojo prisijungo duomenys tinka issaugotus
        if (arTinkaPrisijungimas(vartotojoUsername, vartotojoPassword, tikrasisUsername, tikrasisPassword))
        {
            System.out.println("Jus prisijungete");
        }
        else
        {
            System.out.println("Neteisingi prisijungimo duomenys");
        }
        // Tikriname ar varotojas gime 21 amziuje
        if (arMetai21Amziaus(vartotojoMetai))
        {
            System.out.println("Vartotojas gime 21 amziuje");
        }
        else
        {
            System.out.println("Vartotojas gime 20 amziuje");
        }

    }

    // Tikriname ar ivesti prisijungimo duomenys atitinka saugojamus prisijungimo duomenis
    public static boolean arTinkaPrisijungimas(String vartotojoUsername, String vartotojoPassword, String tikrasisUsername, String tikrasisPassword)
    {
        boolean arTinka;

        if ((vartotojoUsername.equals(tikrasisUsername)) && (vartotojoPassword.equals(tikrasisPassword)))
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

    public static String gimimoDataPerBruksniukus(int metai, int menuo, int diena)
    {
        // Jeigu menuo/diena maziau uz 10
        // Pakeisti i string naudojant valueOf()
        // Prideti i pirma raide "0", o esanti skaiciu perkelti i gala
        String gimData = metai + "-" + menuo + "-" + diena;
        return gimData;
    }

    public static boolean arMetai21Amziaus(int metai)
    {
        boolean ar21Amzius;
        if (metai >= 2000)
        {
            ar21Amzius = true;
        }
        else
        {
            ar21Amzius = false;
        }
        return ar21Amzius;
    }
}
