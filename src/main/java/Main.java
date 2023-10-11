import creatures.Creature;
import creatures.Monster;
import creatures.Player;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        player.createPlayer();
        System.out.println(player.playerInfo());

        Monster monster = new Monster();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите сложность: \n(1,2 или 3)");

            int sc = scanner.nextInt();

            if (sc == 1) {
                monster.createEasyMonster();
                break;
            } else if (sc == 2) {
                monster.createNormalMonster();
                break;
            } else if (sc == 3) {
                monster.createHardMonster();
                break;
            } else {
                System.out.println("1, 2 или 3!!!");
            }
        }
        System.out.println(monster.monsterInfo());
        Thread.sleep(4000);

        System.out.println("Начинается Великая битва!!!\n" + player.getName() + " встретил " + monster.getName());
        while (true) {
            if (battle(player, monster)) break;
        }



    }

    private static boolean battle(Player player, Monster monster) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (player.getHealthPotion() > 0) {
                System.out.println("Атаковать(а)? или Выпить зелье?(з)");
            } else {
                System.out.println("Атаковать(а)?");
            }

            String answer = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (answer.equals("а") || answer.equals("a") || answer.equals("")) {
                break;
            } else if (answer.equals("з") || answer.equals("3")) {
                player.toHeal();
                System.out.println("здоровье " + player.getName() + " = " + player.getHealth() + "\n");
            }
        }
        System.out.println(player.getName() + " бьет " + monster.getName());
        hit(player, monster);
        System.out.println("здоровье монстра " + monster.getHealth() + "\n");
        if (monster.getHealth() <= 0) {
            System.out.println(player.getName() + " winner!!!");
            return true;
        }
        Thread.sleep(1000);

        System.out.println(monster.getName() + " бьет " + player.getName());
        hit(monster, player);
        System.out.println("здоровье " + player.getName() + " = " + player.getHealth() + "\n");
        if (player.getHealth() <= 0) {
            System.out.println(monster.getName() + " winner!!!");
            return true;
        }
        Thread.sleep(500);
        return false;


    }


    private static void hit(Creature creatureOne, Creature creatureTwo){
        int attackModifier;
        int dice;
        boolean isHit = false;
        Random random = new Random();

        attackModifier = creatureOne.getAttack() - (creatureTwo.getDefence() + 1);
        if(attackModifier <= 0) {
            attackModifier = 1;
        } 
        for (int i = 0; i <= attackModifier; i++) {
            dice = random.nextInt(5) + 1;
            if(dice >= 5) {
                isHit = true;
                break;
            }
        }

        if(isHit == true) {
            creatureOne.setDamage(creatureOne.getWeapon().minDamage, creatureOne.getWeapon().maxDamage);
            creatureTwo.setHealth(creatureTwo.getHealth()-creatureOne.getDamage());
            System.out.println("урон - " + creatureOne.getDamage());
        } else {
            System.out.println("промах!");
        }
    }

    
}