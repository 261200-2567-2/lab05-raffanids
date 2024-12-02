import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        int level = 0;
        while (level < 1 || level > 100) {
            System.out.print("Choose your level (1-100): ");
            level = scanner.nextInt();
            if (level < 1 || level > 100) {
                System.out.println("Invalid level. Please choose between 1 - 100.");
            }
        }

        // Create initial stats for character
        Stats stats = new Stats(100 + 10 * level, 50 + 5 * level, 10, 10, 10.0, 5.0 + (level * 0.5));
        Character hero = new Character(name, level, stats);

        // Choose Job for the character
        System.out.println("Choose a job for your character (1: Fighter, 2: Berserk):");
        int jobChoice = scanner.nextInt();

        if (jobChoice == 1) {
            System.out.println("You chose Fighter!");
        } else if (jobChoice == 2) {
            System.out.println("You chose Berserk!");
        } else {
            System.out.println("Invalid choice! Defaulting to Fighter.");
        }

        System.out.println("Choose an accessory (1: Boot, 2: Ring):");
        int accesChoice = scanner.nextInt();

        if (accesChoice == 1) {
            hero.equipAccessory(new Boot());
            System.out.println("You equipped Boots!");
        } else if (accesChoice == 2) {
            hero.equipAccessory(new Ring());
            System.out.println("You equipped Ring!");
        } else {
            System.out.println("Invalid choice! No accessory equipped.");
        }

        System.out.print("Do you want to equip a sword? (y/n): ");
        scanner.nextLine();
        String equipSword = scanner.nextLine();
        while (!equipSword.equalsIgnoreCase("y") && !equipSword.equalsIgnoreCase("n")) {
            System.out.println("Invalid input. Please type 'y' or 'n'.");
            System.out.print("Do you want to equip a sword? (y/n): ");
            equipSword = scanner.nextLine();
        }
        if (equipSword.equalsIgnoreCase("y")) {
            Sword sword = new Sword(level, 15.0, 2.0, 3.0);
            hero.getEquipment().equipSword(sword);
        }

        System.out.print("Do you want to equip a shield? (y/n): ");
        String equipShield = scanner.nextLine();
        while (!equipShield.equalsIgnoreCase("y") && !equipShield.equalsIgnoreCase("n")) {
            System.out.println("Invalid input. Please type 'y' or 'n'.");
            System.out.print("Do you want to equip a shield? (y/n): ");
            equipShield = scanner.nextLine();
        }
        if (equipShield.equalsIgnoreCase("y")) {
            Shield shield = new Shield(level, 10.0, 3.0);
            hero.getEquipment().equipShield(shield);
        }

        System.out.println("\n--- Your Character Stats ---");
        System.out.println("Name: " + hero.getName());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("HP: " + hero.getStats().getcrrHP() + "/" + hero.getStats().getmaxHP());
        System.out.println("Mana: " + hero.getStats().getcrrMana() + "/" + hero.getStats().getmaxMana());
        System.out.println("Run Speed: " + hero.getStats().getcrrSpeed());
        System.out.println("Base Damage: " + hero.getStats().getbaseDamage());
        if (hero.getEquipment().getSword() != null) {
            System.out.println("Equipped Sword: Level: " + hero.getEquipment().getSword().getLevel() + " Damage: " + hero.getEquipment().getSword().getDamage());
        } else {
            System.out.println("Equipped Sword: None");
        }
        if (hero.getEquipment().getShield() != null) {
            System.out.println("Equipped Shield: Level: " + hero.getEquipment().getShield().getLevel() + " Defense: " + hero.getEquipment().getShield().getDefense());
        } else {
            System.out.println("Equipped Shield: None");
        }

        System.out.println("\nYou have received a quest from the guild to eliminate \nthe goblin monsters in the forest so that villagers \ncan safely enter the forest.");

        System.out.println("\nYou are traveling into the forest in search of goblins...");
        System.out.println("Soon, you encounter a goblin!");

        boolean decisionMade = false;
        while (!decisionMade) {
            System.out.print("Do you want to attack the goblin? (y/n): ");
            String engage = scanner.nextLine();
            if (engage.equalsIgnoreCase("y")) {
                battle(hero, scanner);
                decisionMade = true;
            } else if (engage.equalsIgnoreCase("n")) {
                System.out.println("\nAre you sure you don't want to help the villagers? Please think carefully.");
                System.out.print("Do you want to attack the goblin? (y/n): ");
                engage = scanner.nextLine();
                if (engage.equalsIgnoreCase("y")) {
                    battle(hero, scanner);
                    decisionMade = true;
                } else {
                    System.out.println("\nYou fled from the goblin. You're a fake hero!");
                    decisionMade = true;
                }
            } else {
                System.out.println("Invalid input. Please type 'y' or 'n'.");
            }
        }
    }

    public static void battle(Character hero, Scanner scanner) {
        Monster goblin = new Monster("Goblin", hero.getLevel());
        System.out.println("\nBattle Start!");

        while (hero.isAlive() && goblin.isAlive()) {
            System.out.println("\n--- Your Turn ---");
            System.out.println("Your HP: " + hero.getStats().getcrrHP() + "/" + hero.getStats().getmaxHP());
            System.out.println("Goblin Level: " + goblin.getLevel());
            System.out.println("Goblin HP: " + goblin.getCurrentHP() + "/" + goblin.getMaxHP());
            System.out.println("Choose your action:");
            System.out.println("1. Punch with fist");
            System.out.println("2. Slash with sword");
            System.out.println("3. Defend");
            System.out.print("Enter the number of your action: ");
            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    double punchDamage = hero.attack("punch");
                    goblin.takeDamage(punchDamage);
                    break;
                case "2":
                    double slashDamage = hero.attack("slash");
                    if (slashDamage > 0) {
                        goblin.takeDamage(slashDamage);
                    }
                    break;
                case "3":
                    hero.defend();
                    break;
                default:
                    System.out.println("Invalid action. You lost your turn.\nPlease choose '1' or '2' or '3'.");
                    break;
            }

            System.out.println("\n--- Goblin's Turn ---");
            double monsterDamage = goblin.attack();
            hero.takeDamage(monsterDamage);

            if (!hero.isAlive()) {
                System.out.println("\nYou were defeated by the " + goblin.getName() + ". Game Over.");
                return;
            }

            if (!goblin.isAlive()) {
                System.out.println("\nYou defeated the " + goblin.getName() + "!");
                hero.gainExp(goblin.getExpReward());
                System.out.print("Do you want to continue or end here? (c/e): ");
                String choice = scanner.nextLine();

                while (!choice.equalsIgnoreCase("c") && !choice.equalsIgnoreCase("e")) {
                    System.out.println("\nInvalid input. Please type 'c' or 'e'.");
                    System.out.print("Do you want to continue or end here? (c/e): ");
                    choice = scanner.nextLine();
                }

                if (choice.equalsIgnoreCase("c")) {
                    System.out.println("\nYou venture deeper into the forest...");
                    battle(hero, scanner);
                } else if (choice.equalsIgnoreCase("e")) {
                    System.out.println("\nYou have become a hero to the villagers. Well done!");
                }
                return;
            }
        }
    }
}