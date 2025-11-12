import utilities.InputGetter;

public class ShopkeepCounter {
    private RecordKeeper recordKeeper = new RecordKeeper();
    private Order currentOrder; // After an order is completed, if another order is created, make sure to start a fresh order

    public ShopkeepCounter() {

    }

    private void startRecordKeeper() {
        recordKeeper.readPricesFromRecords();
    }

    public void greetCustomer() {
        String userName = InputGetter.getString("What's your name?\n");
//        int orderNumber = recordKeeper.getOrderNumber();
        int orderNumber = 73;
        currentOrder = new Order(userName, orderNumber);
        openShop();
    }

    // Begin prompting user for input from selections
    public void openShop() {
        startRecordKeeper();

        int userInput = 0;
        while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3)) && (!(userInput == 8)) && (!(userInput == 99)))
            userInput = InputGetter.getInt("""
                    \n
                    \t1) Sword
                    \t2) Axe
                    \t3) Mace
                    \t8) Check Order
                    \t99) Leave
                    
                    What do you want?
                    """);

        switch (userInput) {
            case 1 -> processWeaponCreationRequest("Sword");
            case 2 -> processWeaponCreationRequest("Axe");
            case 3 -> processWeaponCreationRequest("Mace");
            case 8 -> processCheckOrderRequest();
        }
    }

    private void processCheckOrderRequest() {
        currentOrder.displayItemsInOrder();
        InputGetter.getString("\n Wake me up when you're ready to continue... Zzzzz...\n");
        openShop();
    }

    private void processWeaponCreationRequest(String weaponType) {
        String weaponMaterial = "";
        String weaponSubType = "";
        String gemType = "";
        boolean isInlaid = false;
        int userInput = 0;

        switch (weaponType) {
            case "Sword" -> {
                while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3))) {


                    System.out.printf("\n\t1) Shortsword: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Shortsword"));
                    System.out.printf("\n\t2) Longsword: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Longsword"));
                    System.out.printf("\n\t3) Greatsword: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Greatsword"));


                    userInput = InputGetter.getInt("\n\nWhat kind?\n");

                    switch (userInput) {
                        case 1 -> weaponSubType = "Shortsword";
                        case 2 -> weaponSubType = "Longsword";
                        case 3 -> weaponSubType = "Greatsword";
                    }
                }

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3)) && (!(userInput == 4))) {

                    System.out.printf("\n\t1) Iron: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Iron", weaponSubType));
                    System.out.printf("\n\t2) Steel: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Steel", weaponSubType));
                    System.out.printf("\n\t3) Mithral: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Mithral", weaponSubType));
                    System.out.printf("\n\t4) Adamantine: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Adamantine", weaponSubType));

                    userInput = InputGetter.getInt("\n\nWhat material do you want?\n");

                    switch (userInput) {
                        case 1 -> weaponMaterial = "Iron";
                        case 2 -> weaponMaterial = "Steel";
                        case 3 -> weaponMaterial = "Mithral";
                        case 4 -> weaponMaterial = "Adamantine";
                    }
                }

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 2))) {

                    userInput = InputGetter.getInt("""
                            
                            \t1) Yes
                            \t2) No
                            
                            Want a gem inlaid into it?
                            """);

                    if (userInput == 1) {
                        isInlaid = true;
                        gemType = processGemInlayRequest();
                    } else {
                        gemType = "None";
                    }
                }

                Sword sword = new Sword(recordKeeper.getReadPrice("Weapon", "Base", weaponSubType), weaponMaterial, isInlaid, gemType, weaponType, weaponSubType, recordKeeper);
                System.out.printf("\nThis would cost you $%.2f, shall I add it to your order?", sword.getTotalPrice());

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 99))) {
                    userInput = InputGetter.getInt("""
                            \n
                            1) Yes
                            99) No
                            """);

                    switch (userInput) {
                        case 1 -> {
                            currentOrder.addPurchase(sword);
                            openShop();
                        }
                        case 99 -> openShop();
                    }
                }
            }

            case "Axe" -> {
                while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3))) {


                    System.out.printf("\n\t1) Hatchet: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Hatchet"));
                    System.out.printf("\n\t2) Broadaxe: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Broadaxe"));
                    System.out.printf("\n\t3) Greataxe: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Greataxe"));


                    userInput = InputGetter.getInt("\n\nWhat kind?\n");

                    switch (userInput) {
                        case 1 -> weaponSubType = "Hatchet";
                        case 2 -> weaponSubType = "Broadaxe";
                        case 3 -> weaponSubType = "Greataxe";
                    }
                }

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3)) && (!(userInput == 4))) {

                    System.out.printf("\n\t1) Iron: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Iron", weaponSubType));
                    System.out.printf("\n\t2) Steel: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Steel", weaponSubType));
                    System.out.printf("\n\t3) Mithral: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Mithral", weaponSubType));
                    System.out.printf("\n\t4) Adamantine: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Adamantine", weaponSubType));

                    userInput = InputGetter.getInt("\n\nWhat material do you want?\n");

                    switch (userInput) {
                        case 1 -> weaponMaterial = "Iron";
                        case 2 -> weaponMaterial = "Steel";
                        case 3 -> weaponMaterial = "Mithral";
                        case 4 -> weaponMaterial = "Adamantine";
                    }
                }

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 2))) {

                    userInput = InputGetter.getInt("""
                            
                            \t1) Yes
                            \t2) No
                            
                            Want a gem inlaid into it?
                            """);

                    if (userInput == 1) {
                        isInlaid = true;
                        gemType = processGemInlayRequest();
                    } else {
                        gemType = "None";
                    }
                }

                Axe axe= new Axe(recordKeeper.getReadPrice("Weapon", "Base", weaponSubType), weaponMaterial, isInlaid, gemType, weaponType, weaponSubType, recordKeeper);
                System.out.printf("\nThis would cost you $%.2f, shall I add it to your order?", axe.getTotalPrice());

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 99))) {
                    userInput = InputGetter.getInt("""
                            \n
                            1) Yes
                            99) No
                            """);

                    switch (userInput) {
                        case 1 -> {
                            currentOrder.addPurchase(axe);
                            openShop();
                        }
                        case 99 -> openShop();
                    }
                }
            }

            case "Mace" -> {

                while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3))) {


                    System.out.printf("\n\t1) Battle Mace: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Battle Mace"));
                    System.out.printf("\n\t2) Warhammer: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Warhammer"));
                    System.out.printf("\n\t3) Maul: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Maul"));


                    userInput = InputGetter.getInt("\n\nWhat kind?\n");

                    switch (userInput) {
                        case 1 -> weaponSubType = "Battle Mace";
                        case 2 -> weaponSubType = "Warhammer";
                        case 3 -> weaponSubType = "Maul";
                    }
                }

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3)) && (!(userInput == 4))) {

                    System.out.printf("\n\t1) Iron: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Iron", weaponSubType));
                    System.out.printf("\n\t2) Steel: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Steel", weaponSubType));
                    System.out.printf("\n\t3) Mithral: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Mithral", weaponSubType));
                    System.out.printf("\n\t4) Adamantine: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Adamantine", weaponSubType));

                    userInput = InputGetter.getInt("\n\nWhat material do you want?\n");

                    switch (userInput) {
                        case 1 -> weaponMaterial = "Iron";
                        case 2 -> weaponMaterial = "Steel";
                        case 3 -> weaponMaterial = "Mithral";
                        case 4 -> weaponMaterial = "Adamantine";
                    }
                }

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 2))) {

                    userInput = InputGetter.getInt("""
                            
                            \t1) Yes
                            \t2) No
                            
                            Want a gem inlaid into it?
                            """);

                    if (userInput == 1) {
                        isInlaid = true;
                        gemType = processGemInlayRequest();
                    } else {
                        gemType = "None";
                    }
                }

                Mace mace = new Mace(recordKeeper.getReadPrice("Weapon", "Base", weaponSubType), weaponMaterial, isInlaid, gemType, weaponType, weaponSubType, recordKeeper);
                System.out.printf("\nThis would cost you $%.2f, shall I add it to your order?", mace.getTotalPrice());

                userInput = 0;
                while (!(userInput == 1) && (!(userInput == 99))) {
                    userInput = InputGetter.getInt("""
                            \n
                            1) Yes
                            99) No
                            """);

                    switch (userInput) {
                        case 1 -> {
                            currentOrder.addPurchase(mace);
                            openShop();
                        }
                        case 99 -> openShop();
                    }
                }

            }
        }
    }

    private void processSwordCreationRequest() {

        String weaponType = "Sword";
        String swordMaterial = "";
        String swordType = "";
        String gemType = "";
        boolean isInlaid = false;
        int userInput = 0;

        while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3))) {


            System.out.printf("\n\t1) Shortsword: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Shortsword"));
            System.out.printf("\n\t2) Longsword: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Longsword"));
            System.out.printf("\n\t3) Greatsword: Base price of $%.2f", recordKeeper.getReadPrice("Weapon", "Base", "Greatsword"));


            userInput = InputGetter.getInt("\n\nWhat kind?\n");

            switch (userInput) {
                case 1 -> swordType = "Shortsword";
                case 2 -> swordType = "Longsword";
                case 3 -> swordType = "Greatsword";
            }
        }

        userInput = 0;
        while (!(userInput == 1) && (!(userInput == 2)) && (!(userInput == 3)) && (!(userInput == 4))) {

            System.out.printf("\n\tIron: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Iron", swordType));
            System.out.printf("\n\tSteel: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Steel", swordType));
            System.out.printf("\n\tMithral: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Mithral", swordType));
            System.out.printf("\n\tAdamantine: Additional fee of $%.2f", recordKeeper.getReadPrice("Material", "Adamantine", swordType));

            userInput = InputGetter.getInt("\n\nWhat material do you want?\n");

            switch (userInput) {
                case 1 -> swordMaterial = "Iron";
                case 2 -> swordMaterial = "Steel";
                case 3 -> swordMaterial = "Mithral";
                case 4 -> swordMaterial = "Adamantine";
            }
        }

        userInput = 0;
        while (!(userInput == 1) && (!(userInput == 2))) {

            userInput = InputGetter.getInt("""
                    
                    \t1) Yes
                    \t2) No
                    
                    Want a gem inlaid into it?
                    """);

            if (userInput == 1) {
                isInlaid = true;
                gemType = processGemInlayRequest();
            } else {
                gemType = "None";
            }
        }

        Sword sword = new Sword(recordKeeper.getReadPrice("Weapon", "Base", swordType), swordMaterial, isInlaid, gemType, weaponType, swordType, recordKeeper);
        System.out.printf("\nThis would cost you $%.2f, shall I add it to your order?", sword.getTotalPrice());

        userInput = 0;
        while (!(userInput == 1) && (!(userInput == 99))) {
            userInput = InputGetter.getInt("""
                    \n
                    1) Yes
                    99) No
                    """);

            switch (userInput) {
                case 1 -> {
                    currentOrder.addPurchase(sword);
                    openShop();
                }
                case 99 -> openShop();
            }
        }
    }

    public String processGemInlayRequest() {
        String selection = "";
        int userInput = 0;

        while (!(userInput == 99) && (!(userInput == 1)) && (!(userInput == 2)) && (!(userInput == 3)) && (!(userInput == 4)) && (!(userInput == 5)) && (!(userInput == 6))) {

            System.out.printf("\n1) Amethyst: $%.2f", recordKeeper.getReadPrice("Upgrade", "Amethyst", "Inlay"));
            System.out.printf("\n2) Garnet: $%.2f", recordKeeper.getReadPrice("Upgrade", "Garnet", "Inlay"));
            System.out.printf("\n3) Emerald: $%.2f", recordKeeper.getReadPrice("Upgrade", "Emerald", "Inlay"));
            System.out.printf("\n4) Citrine: $%.2f", recordKeeper.getReadPrice("Upgrade", "Citrine", "Inlay"));
            System.out.printf("\n5) Sapphire: $%.2f", recordKeeper.getReadPrice("Upgrade", "Sapphire", "Inlay"));
            System.out.printf("\n6) Diamond: $%.2f", recordKeeper.getReadPrice("Upgrade", "Diamond", "Inlay"));
            System.out.println("\n99) Nevermind, nothing.\n");

            userInput = InputGetter.getInt("Which gem would you like?\n");


            switch (userInput) {
                case 1 -> selection = "Amethyst";
                case 2 -> selection = "Garnet";
                case 3 -> selection = "Emerald";
                case 4 -> selection = "Citrine";
                case 5 -> selection = "Sapphire";
                case 6 -> selection = "Diamond";
                case 99 -> selection = "None";
            }
        }
        return selection;
    }
}

