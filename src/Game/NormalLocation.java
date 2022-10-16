package Game;

public abstract class NormalLocation extends Location{
    public NormalLocation(Player player, String locationType){
        super(player, locationType);
    }
   @Override
   public boolean onLocation(){
        return true;
    }


}
