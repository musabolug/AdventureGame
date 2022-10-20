package Game;

import java.util.Random;

public class Snake extends Monster{
    int randomDamage;
    String randomTreasure;

    public Snake(){
        super(4,"Snake",12,3+(int)(Math.random()*4),0);
    }
}
