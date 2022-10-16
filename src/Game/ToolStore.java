package Game;

public class ToolStore extends NormalLocation {
    ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------- Welcome to Store ! ----------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Supplies");
            System.out.println("4- Exit");
            System.out.print("Please select : ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 4) {
                System.out.println("Invalid selection, Please select again : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    //printSupplies();
                    break;
                case 4:
                    System.out.println("See you later ");
                    showMenu = false;
                    break;
            }

        }
        return true;
    }


    public void printWeapon() {
        System.out.println("----- Weapons -----");
        System.out.println();
        for (Weapons w : Weapons.weapons()) {
            System.out.println("Id: " + w.getId() + w.getName() + " <Price : " + w.getPrice() + ", Damge : " + w.getDamage() + ">");
        }
        System.out.println("0- Exit");
    }

    public void buyWeapon() {
        System.out.print("Select a Weapon : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapons.weapons().length) {
            System.out.println("Invalid selection, Please select again : ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0){
            Weapons selectedWeapon = Weapons.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Your money is not enough");
                } else {
                    //Purchasing
                    System.out.println("You bought " + selectedWeapon.getName());
                    int balancce = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balancce);
                    System.out.println("Your new Money balance : " + this.getPlayer().getMoney());
                    System.out.println("Your Previous weapon :" + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new weapon :" + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }

    public void printArmor() {
        System.out.println("----- Armors -----");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println("Id: " + a.getId() + a.getName() + " <Price : " + a.getPrice() + ", Armor : " + a.getBlock() + ">");
        }
        System.out.println("0- Exit");

    }

    public void buyArmor() {
        System.out.print("Select an Armor : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid selection, Please select again : ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Your money is not enough");
                }
                else {
                    //Purchasing
                    System.out.println("You bought " + selectedArmor.getName());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    System.out.println("Your new Money balance : " + this.getPlayer().getMoney());
                    System.out.println("Your Previous Armor :" + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Your new Armor :" + this.getPlayer().getInventory().getArmor().getName());
                }
            }

        }
    }
}