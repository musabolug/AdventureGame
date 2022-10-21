package Game;

import java.util.Scanner;

public class Player {
    private  int damage;
    private int health;
    private int defHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory  inventory;

    public Player( String name ) {
        this.name =name;
        this.inventory = new Inventory();
    }
    public void selectChar(){

        GameCharacter[] characterList = { new Samurai(),new Archer(),new Knight()};

        System.out.println("-----------------------------");
        for (GameCharacter gameCharacter : characterList){
            System.out.println("Id :"+gameCharacter.getID()+
                    "\t Character :"+gameCharacter.getName()+
                    "\t Damage: "+gameCharacter.getDamage()+
                    "\t Health "+gameCharacter.getHealth()+
                    "\t Money "+gameCharacter.getMoney());
        }
        System.out.println("-----------------------------");

        System.out.print("Please select your Mighty Warrior :");
        int selectChar = input.nextInt();
        if (selectChar>= 1 && selectChar<=3) {
            switch (selectChar) {
                case 1:
                    initPlayer(new Samurai());
                    break;
                case 2:
                    initPlayer(new Archer());
                    break;
                case 3:
                    initPlayer(new Knight());
                    break;
            }
        }
        while(selectChar>3||selectChar<1){
            System.out.println("Please select an existing cahracter!");
            System.out.print("Please select your Mighty Warrior :");
            selectChar = input.nextInt();
            switch (selectChar) {
                case 1:
                    initPlayer(new Samurai());
                    break;
                case 2:
                    initPlayer(new Archer());
                    break;
                case 3:
                    initPlayer(new Knight());
                    break;
            }
        }

    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setDefHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }

    public  void  printInfo(){
        System.out.println("Your Weapon :"+this.getInventory().getWeapon().getName()+
                ", Your Armor: "+this.getInventory().getArmor().getName()+
                ", Your Damage: "+this.getTotalDamage()+
                ", Your Health:" + this.getTotalHealth()+
                ", Your Money;"+ this.getMoney());

    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }
    public int getTotalHealth(){
        return health + this.getInventory().getArmor().getBlock();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public  String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapons getWeapon(){
        return this.getInventory().getWeapon();
    }
    public Armor getArmor(){
        return this.getInventory().getArmor();
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
