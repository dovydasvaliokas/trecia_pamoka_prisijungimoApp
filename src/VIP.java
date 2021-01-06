public class VIP extends Vartotojas
{
    public VIP()
    {
    }

    public VIP(String username, String password)
    {
        super(username, password);
    }

    public VIP(String username, String password, int gimDataMetai, int gimDataMenuo, int gimDataDiena)
    {
        super(username, password, gimDataMetai, gimDataMenuo, gimDataDiena);
    }

    @Override
    public String vartotojoIsvedimas()
    {
        String tempTekstas = super.vartotojoIsvedimas();
        tempTekstas += "\n" + "ŠIS VARTOTOJAS YRA: VIP";
        return tempTekstas;
    }
}
