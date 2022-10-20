package Game;

import java.util.Random;

public class Mine extends  BattleLocation{
    public Mine(Player player){
        super(player,"Mine",new Snake(),"Money/Armor/Weapon",5);
    }

}
