import creatures.Creature;
import creatures.Monster;
import creatures.Player;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        player.createPlayer();
        System.out.println(player.playerInfo());

        Monster monster = new Monster();
        monster.createEasyMonster();
        System.out.println(monster.monsterInfo());

        while (true) {
            if (battle(player, monster)) break;
        }


    }

    private static boolean battle(Player player, Monster monster) throws InterruptedException {
        System.out.println(player.getName() + " бьет " + monster.getName());
        hit(player, monster);
        System.out.println("здоровье монстра " + monster.getHealth() + "\n");
        if(monster.getHealth() <= 0) {
            System.out.println(player.getName() + " winner!!!");
            return true;
        }
        Thread.sleep(2000);

        System.out.println(monster.getName() + " бьет " + player.getName());
        hit(monster, player);
        System.out.println("здоровье " + player.getName() + " = " + player.getHealth() + "\n");
        if(player.getHealth() <= 0) {
            System.out.println(monster.getName() + " winner!!!");
            return true;
        }
        Thread.sleep(2000);
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