interface Job {
    String getRole();
    void abilityjob();
    double getDamage();
    double getDefense();
}

class Fighter implements Job {
    @Override
    public String getRole() {
        return "Fighter";
    }

    @Override
    public void abilityjob() {
        System.out.println("Fighter uses Power Slash!");
    }

    @Override
    public double getDamage() {
        return 10.0;
    }

    @Override
    public double getDefense() {
        return 5.0;
    }
}

class Berserker implements Job {
    @Override
    public String getRole() {
        return "Berserker";
    }

    @Override
    public void abilityjob() {
        System.out.println("Berserker uses Rage Attack!");
    }

    @Override
    public double getDamage() {
        return 15.0;
    }

    @Override
    public double getDefense() {
        return 3.0;
    }
}