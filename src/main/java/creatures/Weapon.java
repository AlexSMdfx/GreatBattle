package creatures;

public enum Weapon {

    KNIFE ("нож", 1, 6),
    SWORD("меч", 2, 8),
    CLAW("когти", 1, 5);

    public String name;
    public int minDamage;
    public int maxDamage;

    Weapon(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
}

