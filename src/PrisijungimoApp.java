import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PrisijungimoApp
{
    public static void main (String[] args) throws FileNotFoundException
    {
        // BufferedReader ivedimas = new BufferedReader(new InputStreamReader(System.in));

        // Susikuriamas scanner objektas - nuskaityti informacijai is konsoles
        Scanner ivedimas = new Scanner(System.in);

        int kelintasVartotojas = 0;
        Vartotojas[] dbVartotojai = new Vartotojas[100];
        String arRegistracija = "";
        System.out.println("Iveskite \"Registracija\" jei norite registruotis arba iveskite \"Prisijungimas\", jei norite prisijungti");
        arRegistracija = ivedimas.next();

        if (arRegistracija.equals("Registracija"))
        {
            System.out.println("NORIME REGISTRUOTIS");
            String dbFailoPavadinimas = "db_prisijungimai.txt";
            File dbFailas = new File(dbFailoPavadinimas);
            try
            {
                FileWriter failoRas = new FileWriter(dbFailas, true);
                BufferedWriter failoRasytuvas = new BufferedWriter(failoRas);

                Vartotojas registruojamasVartotojas = new Vartotojas();

                System.out.println("Iveskite savo REG vartotojo varda: ");
              //  String temp_Username = ivedimas.next();
              //  registruojamasVartotojas.setUsername(temp_Username);
                registruojamasVartotojas.setUsername(ivedimas.next());
                System.out.println("Iveskite savo REG slaptazodi: ");
                registruojamasVartotojas.setPassword(ivedimas.next());
                System.out.println("Iveskite savo REG gimimo datos metus: ");
                registruojamasVartotojas.setGimDataMetai(ivedimas.nextInt());
                System.out.println("Iveskite savo REG gimimo datos menesi: ");
                registruojamasVartotojas.setGimDataMenuo(ivedimas.nextInt());
                System.out.println("Iveskite savo REG gimimo datos diena: ");
                registruojamasVartotojas.setGimDataDiena(ivedimas.nextInt());

                failoRasytuvas.newLine();
                failoRasytuvas.write(registruojamasVartotojas.vartotojoIsvedimasIDBFaila());

                failoRasytuvas.close();
                failoRas.close();
                System.out.println("JUS BUVOTE UZREGISTRUOTAS");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
        else
            if (arRegistracija.equals("Prisijungimas"))
            {
                try
                {
                    String dbFailoPavadinimas = "db_prisijungimai.txt";
                    File dbFailas = new File(dbFailoPavadinimas);
                    Scanner failoSkaitytuvas = new Scanner(dbFailas);


                    String[] eilute = new String[5];
                    int kelintaEilute = 0;
                    while (failoSkaitytuvas.hasNextLine())
                    {
                        eilute[kelintaEilute] = apdorotiEilute(failoSkaitytuvas.nextLine());
                        //     System.out.println(eilute[kelintaEilute]);
                        kelintaEilute++;

                        if (kelintaEilute == 5)
                        {
                            dbVartotojai[kelintasVartotojas] = new Vartotojas(eilute[0], eilute[1], Integer.parseInt(eilute[2]), Integer.parseInt(eilute[3]), Integer.parseInt(eilute[4]));
                            //  System.out.println(dbVartotojai[kelintasVartotojas].vartotojoIsvedimas());
                            kelintasVartotojas++;
                            kelintaEilute = 0;
                        }
                    }
                } catch (IOException e)
                {
                    String dbFailoPavadinimas = "db_prisijungimai.txt";
                    File naujasFailas = new File(dbFailoPavadinimas);
                    System.out.println("Ivyko klaida: " + e);
                    try
                    {
                        naujasFailas.createNewFile();
                    } catch (IOException e1)
                    {
                        System.out.println("Negalima sukurti failo, gautas error: " + e1);
                    }
                }

                for (int i = 0; i < kelintasVartotojas; i++)
                {
                    System.out.println(dbVartotojai[i].vartotojoIsvedimas());
                }

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

                // Ivedama vartotojo informacija - konsoleje parodoma ka ivesti ir vartotojas turi ivesti
                System.out.println("Iveskite savo vartotojo varda: ");
                String temp_ivestasVartotojoVardas = ivedimas.next();
                System.out.println("Iveskite savo slaptazodi: ");
                String temp_ivestasVartotojoPassword = ivedimas.next();
                System.out.println("Iveskite savo gimimo datos metus: ");
                int temp_gimDataMetai = ivedimas.nextInt();
                System.out.println("Iveskite savo gimimo datos menesi: ");
                int temp_gimDataMenuo = ivedimas.nextInt();
                System.out.println("Iveskite savo gimimo datos diena: ");
                int temp_gimDataDiena = ivedimas.nextInt();


                // Susikuriamas najas Vartotojas klases objektas - musu vartotojas
                Vartotojas ivestasVartotojas = new Vartotojas(temp_ivestasVartotojoVardas, temp_ivestasVartotojoPassword);
                Vartotojas prisijungesVartotojas = new Vartotojas(temp_ivestasVartotojoVardas, temp_ivestasVartotojoPassword, temp_gimDataMetai, temp_gimDataMenuo, temp_gimDataDiena);

                System.out.println(prisijungesVartotojas.vartotojoIsvedimas());
                System.out.println(prisijungesVartotojas.toString());
                System.out.println("---------------------------");

                for (int i = 0; i < kelintasVartotojas; i++)
                {
                    if (prisijungesVartotojas.equals(dbVartotojai[i]))
                    {
                        System.out.println("RASTI VIENODI VARTOTOJAI");
                        System.out.println(prisijungesVartotojas.vartotojoIsvedimas());
                        System.out.println(dbVartotojai[i].vartotojoIsvedimas());
                    }
                }
            }
            else
            {
                System.out.println("Neteisingai ivestas pasirinkimas");
            }
       /*     System.out.println("Vartotojas objekto username: " + ivestasVartotojas.gautiUsername());
            System.out.println("Vartotojas objekto password: " + ivestasVartotojas.gautiPassword());
            System.out.println("Kitas vartotojas objekto username: " + kitasVartotojas.getUsername());
            System.out.println("Kitas vartotojas objekto passwrod: " + kitasVartotojas.getPassword());
            System.out.println("Kitas vartotojas objekto metai: " + kitasVartotojas.getGimDataMetai());
            System.out.println("Kitas vartotojas objekto menuo: " + kitasVartotojas.getGimDataMenuo());
            System.out.println("Kitas vartotojas objekto diena: " + kitasVartotojas.getGimDataDiena());
            System.out.println("Kitas vartotojas objekto isvedimas per bruksniuka: " + kitasVartotojas.getDataPerBriuksniuka());*/
       /*     // Nuskaitomas slapyvardis ir slaptazodis is konsoles
            String vartotojoUsername = ivedimas.next();
         //   String vartotojoUsernameGavimoBudas = "Gavo per Scanner";
            String vartotojoPassword = ivedimas.next();*/
       /*     // Nuskaitoma gimimo data is konsoles
            int vartotojoMetai = ivedimas.nextInt();

            while (vartotojoMetai < 0)
            {
                System.out.println("Blogai ivesti metai. Iveskite per naujo: ");
                vartotojoMetai = ivedimas.nextInt();*/
           /*  Neveikiantis tikrinimo budas, kadangi tikrina tik viena syki - o po to vartotojas vel gali klaidingai ivedineti
            if (vartotojoMetai < 0)
            {
                System.out.println("Blogai ivesti metai. Iveskite per naujo: ");
                vartotojoMetai = ivedimas.nextInt();
            }*/
       /*     int vartotojoMenuo = ivedimas.nextInt();
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
            }*/
       /*     // Isvedama bei tikrinama informacija
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
            }*/
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

    public static String apdorotiEilute (String eilute)
    {
        String tempEilute = eilute;
        tempEilute = tempEilute.split(":")[1];
        tempEilute = tempEilute.trim();
        return tempEilute;
     //   return eilute.split(":")[1].trim();
    }
}
