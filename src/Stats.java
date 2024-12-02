public class Stats {
    private int maxHP;
    private int crrHP;
    private int maxMana;
    private int crrMana;
    private int strength;
    private int agility;
    private double baseSpeed;
    private double crrSpeed;
    private double baseDamage;
    private double baseDefense;

    public Stats(int maxHP, int maxMana, int strength, int agility, double baseSpeed, double baseDamage) {
        this.maxHP = maxHP;
        this.crrHP = maxHP;
        this.maxMana = maxMana;
        this.crrMana = maxMana;
        this.strength = strength;
        this.agility = agility;
        this.baseSpeed = baseSpeed;
        this.crrSpeed = baseSpeed;
        this.baseDamage = baseDamage;
        this.baseDefense = 0.0;
    }

    public void updateStats(int level) {
        this.maxHP = 100 + 10 * level;
        this.crrHP = this.maxHP;
        this.maxMana = 50 + 5 * level;
        this.crrMana = this.maxMana;
        this.baseDamage = 5.0 + (level * 0.5);
    }

    public void takeDamage(double damage) {
        this.crrHP -= damage;
        if (this.crrHP < 0) this.crrHP = 0;
    }

    public double getbaseDamage() {
        return baseDamage;
    }

    public double getBaseDefense() {
        return baseDefense;
    }

    public int getcrrHP() {
        return crrHP;
    }

    public int getmaxHP() {
        return maxHP;
    }

    public int getcrrMana() {
        return crrMana;
    }

    public int getmaxMana() {
        return maxMana;
    }

    public double getcrrSpeed() {
        return crrSpeed;
    }
}