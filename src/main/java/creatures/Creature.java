package creatures;

import java.util.Random;

public class Creature {
    private String name;
    private int attack;
    private int defence;
    private int health;
    private int damage;


    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int min, int max) {
//        if (min > max) {
//
//            int temp = min;
//            min = max;
//            max = temp;
//        }
        Random random = new Random();
        this.damage =  random.nextInt(max - min) + min;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
            this.attack = attack;
        }

    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }





}



                                                                                         