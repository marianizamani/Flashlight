package Torch;

public class Battery {
    private int charge = 100;

    public void consumePower(int amount) {
        charge -= amount;
        if (charge < 0) charge = 0;
        if (charge > 100) charge = 100;
    }

    public boolean isDead() {
        return charge <= 0;
    }

    public int getCharge() {
        return charge;
    }
}
