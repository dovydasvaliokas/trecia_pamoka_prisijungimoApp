public class PaprastasVartotojas extends Vartotojas
{
    public PaprastasVartotojas()
    {
    }

    public PaprastasVartotojas(String username, String password)
    {
        super(username, password);
    }

    public PaprastasVartotojas(String username, String password, int gimDataMetai, int gimDataMenuo, int gimDataDiena)
    {
        super(username, password, gimDataMetai, gimDataMenuo, gimDataDiena);
    }

    @Override
    public String vartotojoIsvedimas()
    {
        String tempTekstas = super.vartotojoIsvedimas();
        tempTekstas += "\n" + "ŠIS VARTOTOJAS YRA: PAPRASTAS";
        return tempTekstas;
    }
}
