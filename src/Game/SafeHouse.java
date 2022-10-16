package Game;

import java.util.SplittableRandom;

public class SafeHouse extends  NormalLocation{
    public SafeHouse(Player player){
        super(player, "Safe House");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Welcome to Safe House !");
        System.out.println("Your health and supplies are renewed ");
        return true;
    }


}
