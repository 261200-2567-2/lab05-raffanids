public class Sword implements Gear {
    private int level;
    private double baseDamage;
    private double baseDefense;
    private double weight;

    public Sword(int level, double baseDamage, double baseDefense, double weight) {
        this.level = level;
        this.baseDamage = baseDamage;
        this.baseDefense = baseDefense;
        this.weight = weight;
    }

    public double getDamage() {
        return baseDamage * (1 + 0.1 * level);
    }

    public double getDefense() {
        return baseDefense;
    }

    public double getSpeedPenalty() {
        return weight;
    }

    @Override
    public void levelUp() {
        this.level++;
        System.out.println("Sword leveled up to level " + level+ "!");
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getLevel() {
        return level;
    }
}