package creatures;

import java.util.Random;
import java.util.Scanner;

public class Player extends Creature {
    private int healthPotion = 4;
    private int maxHealth;

    private Player PLAYER;
    public Player createPlayer () {
        if (PLAYER == null) {
            PLAYER = new Player();
        }

        Scanner sc = new Scanner(System.in);
        do  {
            System.out.println("Введите имя персонажа:\n(не более 12 символов)");
            setName(sc.nextLine());
        } while (getName().length() > 12);

        Random random = new Random();

        setAttack(random.nextInt(30) + 1);
        setDefence(random.nextInt(30) + 1);
        setHealth(random.nextInt(100) + 30);
        maxHealth = getHealth();
        setWeapon(Weapon.KNIFE);

        return PLAYER;
    }

    public void toHeal() {
        if (healthPotion == 0) {
            System.out.println("Зелья лечения кончились");
            return;
        }
        int newHealth = getHealth() + (int)(maxHealth * 0.3);
        if(newHealth > maxHealth) {
            setHealth(maxHealth);
        } else {
            setHealth(newHealth);
        }
        healthPotion--;
    }

    public String playerInfo() {
        // закинуть все в БД и вытаскивать оттуда
        return getName() + "\n" +
                "атака - " + getAttack() + "\n" +
                "защита - " + getDefence() + "\n" +
                "здоровье - " + getHealth() + "\n" +
                "____________" + "\n" +
                getWeapon().name + "\n" +
                "урон - (" + getWeapon().minDamage + " - " + getWeapon().maxDamage + ")\n\n";
    }


    public int getHealthPotion() {
        return healthPotion;
    }
}
