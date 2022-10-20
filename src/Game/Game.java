package Game;

import java.util.Scanner;
import Game.Inventory;
import Game.Player;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to Adventure Game !");
        System.out.print("Please enter a Name : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("-----------------------------");
        System.out.println(player.getName() +" Welcome to your new adventure !");
        System.out.println("-----------------------------");
        System.out.println("Characters");
        player.selectChar();
        Location location = null;

        while (true){
            player.printInfo();
            System.out.println("-----------LOCATIONS-----------");
            System.out.println("1- Safe House ==> This is a safe place with no enemy  for you to rest ! ");
            System.out.println("2- Store ==> This is a place for buy or sell equipment ! ");
            System.out.println("3- Cemetery ==> This place is a Battle Location full of Zombies ! ");
            System.out.println("4- Cursed Castle ==> This place is a Battle Location full of Vampires ! ");
            System.out.println("5- Mordor ==> This place is a Battle Location full of Orcs ! ");
            System.out.println("0- Exit ==> Finis game !");

            System.out.print("Please select the location you want to go : ");
            int selectLocation = input.nextInt();

                switch (selectLocation) {
                    case 0:
                        location = null;
                        break;
                    case 1:
                        if (player.getInventory().isFood()== true&&player.getInventory().isWater()== true&& player.getInventory().isFirewood()== true ){
                            System.out.println("---------- WİN WİN ---------- ");
                            location = null;

                        }
                        else {
                            location = new SafeHouse(player);
                        }
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:

                        if (player.getInventory().isFood()== true){
                            System.out.println("You can't get here please select another place !");
                        }
                        else {
                            location = new Cemetery(player);
                        }
                        break;
                    case 4:
                        if (player.getInventory().isWater() == true){
                            System.out.println("You can't get here please select another place !");
                        }
                        else {
                            location = new CursedCastle(player);
                        }
                        break;
                    case 5:
                        if (player.getInventory().isFirewood()== true){
                            System.out.println("You can't get here please select another place !");
                        }
                        else {
                            location = new Mordor(player);
                        }
                        break;
                    default:
                        location = new SafeHouse(player);
                        break;
                }
            if (location == null){
                System.out.println("GAME OVER !!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER !!");
                break;
            }
        }


    }


}
