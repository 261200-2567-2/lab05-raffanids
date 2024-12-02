public class Shield implements Gear {
    private int level;
    private double baseDefense;
    private double weight;

    public Shield(int level, double baseDefense, double weight) {
        this.level = level;
        this.baseDefense = baseDefense;
        this.weight = weight;
    }

    public double getDefense() {
        return baseDefense * (1 + 0.05 * level);
    }

    public double getSpeedPenalty() {
        return weight;
    }

    @Override
    public void levelUp() {
        this.level++;
        System.out.println("Shield leveled up to level " + level + "!");
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