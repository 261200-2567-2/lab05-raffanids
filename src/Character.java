public class Character {
    private final String name;
    public String Job;
    private int level;
    private int exp;
    private double speed;
    private double regene;
    private Stats stats;
    private Job job;
    private Equipment equipment;
    private Acces acces;

    public Character(String name, int level, Stats stats) {
        this.name = name;
        this.level = level;
        this.exp = 0;
        this.speed = 10.0;
        this.regene = 5.0;
        this.stats = stats;
        this.equipment = new Equipment();
    }

    public void levelUp() {
        while (exp >= calExpToNextLevel()) {
            exp -= calExpToNextLevel();
            level++;
            stats.updateStats(level); // อัปเดตค่าสถานะตามเลเวลใหม่
            System.out.println("You leveled up! Level " + (level - 1) + " -> Level " + level);
        }
    }

    public double attack(String attackType) {
        if (attackType.equalsIgnoreCase("punch")) {
            return stats.getbaseDamage();
        } else if (attackType.equalsIgnoreCase("slash") && equipment.getSword() != null) {
            return equipment.getSword().getDamage();
        } else {
            System.out.println("You don't have a sword to slash with!");
            return 0.0;
        }
    }

    public void defend() {
        System.out.println("You brace yourself for the incoming attack!");
    }

    public void takeDamage(double damage) {
        double totalDefense = 0.0;
        if (equipment.getShield() != null) {
            totalDefense = equipment.getShield().getDefense();
        }
        double actualDamage = damage - totalDefense;
        if (actualDamage < 0) actualDamage = 0;
        stats.takeDamage(actualDamage);
        System.out.println("You took " + actualDamage + " damage!");
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return stats.getcrrHP() > 0;
    }

    private int calExpToNextLevel() {
        return level * 100;
    }

    public Stats getStats() {
        return stats;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void gainExp(int exp) {
        this.exp += exp;
        System.out.println("You gained " + exp + " EXP!");
        levelUp();
    }

    public void equipAccessory(Acces accessory) {
        this.speed += accessory.getSpeed();
        this.regene += accessory.getRegene();
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nLevel: " + level + "\nSpeed: " + speed + "\nRegene: " + regene;
    }
}
