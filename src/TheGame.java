import java.util.Scanner;

public class TheGame {
    private static Scanner scanner;
    private static Hero theHero;
    private static Battle battle;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        battle = new Battle();

        System.out.print("Добро пожаловать в игру!\nВведите имя героя:");

        input(scanner.next());
    }

    private static void input(String str) {
        if (theHero == null){
            theHero = new Hero(str, 20, 1, 2, 0, 0);
            printNavigation();
        }
        switch (str){
            case "1": toMerchant(); break;
            case "2": toDarkWood(); break;
            case "3": System.exit(1); break;
            case "да": input("2"); break;
            case "нет": {
                printNavigation();
                input(scanner.next());
            }; break;
            default: input(scanner.next()); break;
        }
    }

    private static void toDarkWood() {
        Creature monster;
        if((Math.random() * 10) > 5){
            monster = new Goblin("Goblin", 10, 1, 1, 2, 5);
        }else{
            monster = new Goblin("Skeleton", 10, 2, 2, 5, 7);
        }
        battle.fight(theHero, monster, new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println("Хотите продолжить прогулку по лесу?[да/нет]");
                input(scanner.next());
            }

            @Override
            public void fightLost() {
                input("3");
            }
        });

    }

    private static void toMerchant() {
        System.out.println("Торговец еще не вышел на работу(");
        printNavigation();
        input(scanner.next());
    }

    private static void printNavigation() {
        System.out.println(
                "Куда вы хотите направиться?\n" +
                "1)К торговцу\n" +
                "2)В темный лес\n" +
                "3)Выход\n"
        );
    }

}
