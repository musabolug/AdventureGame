package Game;

public class Inventory {
        private Weapons weapon;
        private  Armor armor;
        boolean water;
        boolean food;
        boolean firewood;



        public Inventory(){
            this.weapon = new Weapons("Punch",-1,0,0);
            this.armor = new Armor(-1,"Rug",0,0);
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
}
