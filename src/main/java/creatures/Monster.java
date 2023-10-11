package creatures;

import java.util.Random;

public class Monster extends Creature {

    public void createEasyMonster () {
        Random random = new Random();
        setName("Easy");
        setAttack(random.nextInt(10) + 1);
        setDefence(random.nextInt(10) + 1);
        setHealth(random.nextInt(30) + 10);
        setWeapon(Weapon.CLAW);
    }
    public void createNormalMonster () {
        Random random = new Random();
        setName("Normal");
        setAttack(random.nextInt(30) + 1);
        setDefence(random.nextInt(30) + 1);
        setHealth(random.nextInt(100) + 30);
        setWeapon(Weapon.KNIFE);

    }
    public void createHardMonster () {
        Random random = new Random();
        setName("Hard");
        setAttack(random.nextInt(50) + 30);
        setDefence(random.nextInt(50) + 30);
        setHealth(random.nextInt(100) + 100);
        setWeapon(Weapon.SWORD);
    }

    public String monsterInfo() {
        return getName() + "\n" +
                "атака - " + getAttack() + "\n" +
                "защита - " + getDefence() + "\n" +
                "здоровье - " + getHealth() + "\n" +
                "____________" + "\n" +
                getWeapon().name + "\n" +
                "урон - (" + getWeapon().minDamage + " - " + getWeapon().maxDamage + ")\n\n";
    }
}
