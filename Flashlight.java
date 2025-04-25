package Torch;

public abstract class Flashlight extends Thread {
    protected LightSource light;
    protected PowerButton button;
    protected Battery battery;
    private boolean running = true;

    public Flashlight(Battery battery) {
        this.light = new LEDLight();
        this.button = new PowerButton();
        this.battery = battery;
    }

    public void pressPowerButton() {
        button.press();
        if (button.isOn()) {
            light.turnOn(); // Immediately turn on the light
            System.out.println("Flashlight is ON.");
        } else {
            light.turnOff(); // Immediately turn off the light
            System.out.println("Flashlight is OFF.");
        }
    }

    public abstract void charge();

    @Override
    public void run() {
    	 while (running) {
            if (button.isOn() && !battery.isDead()) {
                light.turnOn();
                battery.consumePower(5);
            } else {
            	running=false;
                light.turnOff();
                break;
            }
       
            System.out.println("Battery: " + battery.getCharge() + "%");
            
           
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Flashlight stopped.");
                break;
            }
        }
    }
}