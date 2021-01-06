public class Vartotojas
{
    //--------------------------------------
    //-- Kintamieji
    //--------------------------------------
    private String username = "username'as";
    private String password;
    private int gimDataMetai;
    private int gimDataMenuo;
    private int gimDataDiena;
    private String dataPerBriuksniuka;

    //---------------------------------------
    // Konstruktoriu methodai
    //---------------------------------------

    // Tuscias konstruktorius
    public Vartotojas()
    {

    }

    // Konstruktorius su username ir password
    public Vartotojas(String username, String password)
    {
        this.username = username;
        this.password = password;
    }


    // Konstruktorius su username ir su password
    public Vartotojas(String username, String password, int gimDataMetai, int gimDataMenuo, int gimDataDiena)
    {
     //   this.dataPerBriuksniuka = PrisijungimoApp.gimimoDataPerBruksniukus(this.gimDataMetai, this.gimDataMenuo, this.gimDataDiena);
        this.username = username;
        this.password = password;
        this.gimDataMetai = gimDataMetai;
        this.gimDataMenuo = gimDataMenuo;
        this.gimDataDiena = gimDataDiena;
        this.dataPerBriuksniuka = PrisijungimoApp.gimimoDataPerBruksniukus(gimDataMetai, gimDataMenuo, gimDataDiena);
    }


    //----------------------------------------------
    // Klases metodai
    //----------------------------------------------


    // Overload
    // Overload - metodas gauna skirtinga skaiciu kintamuju arba gauna skirtingo tipo kintamuosiuos parametruose
    public boolean equals(Vartotojas obj)
    {
        boolean arVienodi = false;
        if ((this.username.equals(obj.getUsername())) && (this.password.equals(obj.getPassword())))
        {
            arVienodi = true;
        }
        return arVienodi;
     //   return ((this.username.equals(obj.getUsername()) && this.password.equals(obj.getPassword())));
    }

    @Override
    public String toString()
    {
        return "Vartotojas{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gimDataMetai=" + gimDataMetai +
                ", gimDataMenuo=" + gimDataMenuo +
                ", gimDataDiena=" + gimDataDiena +
                ", dataPerBriuksniuka='" + dataPerBriuksniuka + '\'' +
                '}';
    }

    public String vartotojoIsvedimas()
    {
        String temp_isvestasTekstas = "";

        temp_isvestasTekstas += "Šio vartotojo vardas: " + username + "\n";
        temp_isvestasTekstas += "Šio vartotojo slaptažodis: " + this.password + "\n";
        temp_isvestasTekstas += "Šio vartotojo gimimo data: " + PrisijungimoApp.gimimoDataPerBruksniukus(gimDataMetai, gimDataMenuo, gimDataDiena);

        return temp_isvestasTekstas;
    }

    public String vartotojoIsvedimasIDBFaila()
    {
        String temp_isvestasTekstas = "";
        temp_isvestasTekstas += "vartotojo_vardas: " + this.username + "\n";
        temp_isvestasTekstas += "vartotojo_slaptazodis: " + this.password + "\n";
        temp_isvestasTekstas = temp_isvestasTekstas + "vartotojo_gimMetai: " + this.gimDataMetai + "\n";       // tas pats kas rasyti += operatoriu
        temp_isvestasTekstas += "vartotojo_gimMenuo: " + this.gimDataMenuo + "\n";
        temp_isvestasTekstas += "vartotojo_gimDiena: " + this.gimDataDiena;
        return temp_isvestasTekstas;
    }



    //---------------------------------
    // Getters and setters methods
    //---------------------------------
    public String getDataPerBriuksniuka()
    {
        return dataPerBriuksniuka;
    }

    public void setDataPerBriuksniuka(String dataPerBriuksniuka)
    {
        this.dataPerBriuksniuka = dataPerBriuksniuka;
    }

    public int getGimDataMetai()
    {
        return gimDataMetai;
    }

    public void setGimDataMetai(int gimDataMetai)
    {
        this.gimDataMetai = gimDataMetai;
    }

    public int getGimDataMenuo()
    {
        return gimDataMenuo;
    }

    public void setGimDataMenuo(int gimDataMenuo)
    {
        this.gimDataMenuo = gimDataMenuo;
    }

    public int getGimDataDiena()
    {
        return gimDataDiena;
    }

    public void setGimDataDiena(int gimDataDiena)
    {
        this.gimDataDiena = gimDataDiena;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }




    // Ranka rasyti getteriai ir setteriai
    public String gautiUsername()
    {
        return this.username;
    }

    public String gautiPassword()
    {
        return this.password;
    }

    public void nustatytiUsername(String slapyvardis)
    {
        this.username = slapyvardis;
    }

    public void nustatytiPassword(String password)
    {
        this.password = password;
    }
}
