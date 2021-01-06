public class Admin extends Vartotojas
{
    public Admin()
    {
    }

    public Admin(String username, String password)
    {
        super(username, password);
    }

    public Admin(String username, String password, int gimDataMetai, int gimDataMenuo, int gimDataDiena)
    {
        super(username, password, gimDataMetai, gimDataMenuo, gimDataDiena);
    }

    public void istrintiVartotoja(int index)
    {
        System.out.println("Admin'as norėjo ištrinti " + index + " vartotoją");
    }



}
