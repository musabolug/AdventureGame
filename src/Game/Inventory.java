package Game;

public class Inventory {
        private Weapons weapon;
        private  Armor armor;

        private boolean water;
        private boolean firewood;
        private boolean food;



        public Inventory(){
            this.weapon = new Weapons("Punch",-1,0,0);
            this.armor = new Armor(-1,"Rug",0,0);
            this.water = false;
            this.firewood = false;
            this.food = false;
        }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isWater(){
            return water;
    }
    public void setWater(boolean water){
            this.water = water;
    }
    public boolean isFood(){
            return food;
    }
    public void setFood(boolean food) {
            this.food = food;
    }
    public boolean isFirewood(){
            return firewood;
    }
    public void setFirewood(boolean firewood){
            this.firewood = firewood;
    }
}
