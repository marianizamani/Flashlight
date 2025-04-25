package Torch;

public class ElectricCharger extends Thread {
    private Battery battery;
    private boolean running = true;

    public ElectricCharger(Battery battery) {
        this.battery = battery;
    }

    @Override
    public void run() {
    	 while (running) {
            if (battery.getCharge() < 100) {
                battery.consumePower(-3);  // faster charging
                System.out.println("⚡ Electric charging... Battery: " + battery.getCharge() + "%");
            }
//            if(battery.getCharge()==0) running =false;

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("⚡ Electric charging stopped.");
                break;
            }
        }
    }
}


