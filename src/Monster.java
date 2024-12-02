public class Monster {
    private String name;
    private int level;
    private int maxHP;
    private int currentHP;
    private double damage;
    private int expReward;

    public Monster(String name, int level) {
        this.name = name;
        this.level = level;
        this.maxHP = 50 + 8 * level;
        this.currentHP = maxHP;
        this.damage = 10.0 + (level * 0.7);
        this.expReward = 50 + level * 20;
    }

    public double attack() {
        return damage;
    }

    public void takeDamage(double damage) {
        currentHP -= damage;
        if (currentHP < 0) currentHP = 0;
        System.out.println(name + " took " + damage + " damage!");
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getExpReward() {
        return expReward;
    }
}
