public class Equipment {
    private Sword sword;
    private Shield shield;

    public Sword getSword() {
        return sword;
    }

    public void equipSword(Sword sword) {
        this.sword = sword;
        System.out.println("Equipped a new sword!");
    }

    public void unequipSword() {
        this.sword = null;
        System.out.println("Unequipped the sword!");
    }

    public Shield getShield() {
        return shield;
    }

    public void equipShield(Shield shield) {
        this.shield = shield;
        System.out.println("Equipped a new shield!");
    }

    public void unequipShield() {
        this.shield = null;
        System.out.println("Unequipped the shield!");
    }
}
