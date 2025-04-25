package Torch;

public class SolarPanel extends Thread {
    private Battery battery;
    private boolean running = true;

    public SolarPanel(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void run() {
        while (running) {
            if (battery.getCharge() < 100) {
                battery.consumePower(-2);
                System.out.println("Solar Panel charging... Battery: " + battery.getCharge() + "%");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("☀️  Solar Panel stopped by exception.");
                break;
            }
        }
        System.out.println("☀️  Solar Panel stopped.");
    }
}

