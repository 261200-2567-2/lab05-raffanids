public interface Acces {
    double getSpeed();
    double getRegene();
}

class Boot implements Acces{
    public double getSpeed() {
        return 20.0;
    }
    public double getRegene() {
        return 0.0;
    }
}

class Ring implements Acces {
    public double getSpeed() {
        return 0.0;
    }
    public double getRegene() {
        return 15.0;
    }
}
