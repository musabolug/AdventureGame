package Game;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome to Adventure Game !");
        System.out.print("Please enter a Name : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() +" Welcome to your new adventure !");
        player.selectChar();
        Location location = null;
        while (true){
            player.printInfo();
            System.out.println("-----------LOCATIONS-----------");
            System.out.println("1- Safe House ==> This is a safe place with no enemy  for you to rest ! ");
            System.out.println("2- Store ==> This is a place for buy or sell equipment !");
            System.out.println("0- Exit ==> Finis game !");

            System.out.print("Please select the location you want to go : ");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 0:
                    location = null;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
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
