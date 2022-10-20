package Game;

public class Monster {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int treasure;
    private  int defHealth;
    public Monster(int id,String name, int health, int damage,int treasure){
        this.id = id;
        this.name = name;
        this.health = health;
        this.defHealth = this.health;
        this.damage = damage;
        this.treasure = treasure;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health = 0;
        }
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        this.treasure = treasure;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
