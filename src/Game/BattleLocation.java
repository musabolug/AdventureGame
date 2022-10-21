package Game;
import java.util.Random;
import java.util.stream.StreamSupport;
import Game.Inventory;

public class BattleLocation extends Location{
    private Monster monster;
    private String award;
    private int maxMonster;
    public BattleLocation(Player player, String name,Monster monster,String award,int maxMonster){
        super(player,name);
        this.monster = monster;
        this.award = award;
        this.maxMonster =maxMonster;
    }
    @Override
    public boolean  onLocation(){
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("You are here now :"+this.getLocationType());
        System.out.println("Watch out! there might be "+monsterNumber+" "+ this.getMonster().getName()+" living here! ");
        System.out.print("<B> Battle or <R> Run :");
        String selectCase = input.nextLine().toUpperCase();
        while (!selectCase.equals("B")&& !selectCase.equals("R")){
            System.out.println("You entered a wrong input!");
            selectCase = input.nextLine().toUpperCase();
        }
        if (selectCase.equals("B")&&  combat(monsterNumber)){
            System.out.println("Battle states :");
            System.out.println("You beated every monster in the "+this.getLocationType());
            return true;
        } else if (selectCase.equals("R")) {
            System.out.println("You proved your cowardice by running away from war!! ");
        }

        if (this.getPlayer().getTotalHealth() <=0){
            System.out.println("You are dead !");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber){
        for (int i= 1; i <= monsterNumber; i++){
            int firstHit= ramdomHitChance();
        this.getMonster().setHealth(this.getMonster().getDefHealth());
        playerStats();
        enemyStats(i);
        while (this.getPlayer().getTotalHealth()>0 && this.getMonster().getHealth()>0){
            System.out.print("<H> Hit or <R> Run : ");
            String selectCombat = input.nextLine().toUpperCase();
            while (!selectCombat.equals("H") && !selectCombat.equals("R")){
                System.out.println("You entered a wrong input!");
                selectCombat = input.nextLine().toUpperCase();
            }
            if (selectCombat.equals("R")){
                return false;
            }
            if (selectCombat.equals("H")){
                if (firstHit==0){
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    System.out.println("You hit !");
                    System.out.println("Hitten damage: " + this.getPlayer().getTotalDamage());
                    System.out.println("Your health: " + this.getPlayer().getHealth());
                    System.out.println(this.getMonster().getName() + " Health : " + this.getMonster().getHealth());
                    System.out.println();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println(this.getMonster().getName() +" hit you");
                        this.getPlayer().setHealth(this.getPlayer().getTotalHealth()-this.getMonster().getDamage());
                        afterHit();
                    }
                }
                if (firstHit==1){
                    System.out.println(this.getMonster().getName()+ " hit you!");
                    this.getPlayer().setHealth(this.getPlayer().getTotalHealth()-this.getMonster().getDamage());
                    System.out.println("Hitten damage: " + this.getMonster().getDamage());
                    System.out.println("Your health : " + this.getPlayer().getTotalHealth());
                    System.out.println("You hit !");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    System.out.println("Hitten damage: " + this.getPlayer().getTotalDamage());
                    System.out.println("Your health: " + this.getPlayer().getHealth());
                    System.out.println(this.getMonster().getName() + " Health : " + this.getMonster().getHealth());
                    System.out.println();
                    afterHit();
                }

            }
        }

        }
        if (this.getMonster().getHealth()<this.getPlayer().getHealth()){
            System.out.println("You Defeated the Enemies! ");
            if (this.getLocationType().equals("Mine")){
                snakeAwards();
            }else {
                System.out.println("You find a Battle award : " + this.getAward());
                if (this.getAward().equals("Food")) {
                    getPlayer().getInventory().setFood(true);
                } else if (this.getAward().equals("Water")) {
                    getPlayer().getInventory().setWater(true);
                } else if (this.getAward().equals("Firewood")) {
                    getPlayer().getInventory().setFirewood(true);
                }
                System.out.println("You Deserve this treasure : " + this.getMonster().getTreasure() + " Gold");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getTreasure());
                System.out.println("Your new Money :" + this.getPlayer().getMoney());
            }
        }else {
            return false;
        }
        return  true;
    }
    public void snakeAwards(){
        Random a = new Random();
        int precentage= a.nextInt(100);
        int weapon = a.nextInt(100);
        int armor = a.nextInt(100);
        int money = a.nextInt(100);
        if ( precentage<=15){
            if (weapon<=50){
                if (this.getPlayer().getInventory().getWeapon().getId()<=1){
                    System.out.println("You find Degger ! ");
                    this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjByID(1));
                }
            }
            if (weapon>50 && weapon<=80){
                if (this.getPlayer().getInventory().getWeapon().getId()<=2){
                    System.out.println("You find Sword ! ");
                    this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjByID(2));
                }
            }
            if (weapon>80){
                if (this.getPlayer().getInventory().getWeapon().getId()<=3){
                    System.out.println("You find Axe ! ");
                    this.getPlayer().getInventory().setWeapon(Weapons.getWeaponObjByID(3));
                }
            }

        }else if(precentage> 15&& precentage<=30){
            if (armor<= 50){
                if (this.getPlayer().getInventory().getArmor().getId()<=1){
                    System.out.println("You Find Light Armor ! ");
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
                }
            }
            if (armor> 50 && armor <=80){
                if (this.getPlayer().getInventory().getArmor().getId()<=2){
                    System.out.println("You Find Middle Armor ! ");
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
                }
            }
            if (armor>80){
                if (this.getPlayer().getInventory().getArmor().getId()<=3){
                    System.out.println("You Find Heavy Armor ! ");
                    this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
                }
            }
            else if(precentage>30 && precentage<= 55){
                if (money<=50){
                    System.out.println("You Find 1 Money ! ");

                    this.getPlayer().setMoney(getPlayer().getMoney()+1);
                }
                if (money>50 && money<=80){
                    System.out.println("You Find 5 Money ! ");

                    this.getPlayer().setMoney(getPlayer().getMoney()+5);

                }
                if (money >80){
                    System.out.println("You Find 10 Money ! ");
                    this.getPlayer().setMoney(getPlayer().getMoney()+10);
                }
            }
            
        } else if (precentage>55) {
            System.out.println("You can't find anyting.");
        }
    }
    public void afterHit(){
        System.out.println("Your Health :" + this.getPlayer().getTotalHealth());
        System.out.println(this.getMonster().getName() +" Health :"+ this.getMonster().getHealth());
    }
    public void enemyStats(int i){
        System.out.println("---------------------");
        System.out.println(i+"."+this.getMonster().getName()+  " Stats: ");
        System.out.println("---------------------");
        System.out.println("Health : "+ getMonster().getHealth());
        System.out.println("Damage : "+getMonster().getDamage());
        System.out.println("Reward :"+getMonster().getTreasure());
    }
    public void playerStats(){
        System.out.println("---------------------");
        System.out.println("Player Stats: ");
        System.out.println("---------------------");
        System.out.println("Health :"+getPlayer().getTotalHealth());
        System.out.println("Armor :"+getPlayer().getArmor().getName());
        System.out.println("Damage :"+getPlayer().getTotalDamage());
        System.out.println("Weapon :"+getPlayer().getWeapon().getName());
        System.out.println("Money :"+getPlayer().getMoney());


    }
    public int ramdomHitChance(){
        Random hitChacne = new Random();
        return  hitChacne.nextInt(2);
    }
    public  int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster())+1;
    }
    public int getMaxMonster(){
        return this.maxMonster;
    }
    public void setMaxMonster(int maxMonster){
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

}
