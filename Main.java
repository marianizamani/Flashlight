package Torch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Battery battery = new Battery();
        RechargeableFlashlight flashlight = new RechargeableFlashlight(battery);

        flashlight.start();


        Thread.sleep(2000);
        flashlight.pressPowerButton(); // Turn ON

        Thread.sleep(4000);
        flashlight.pressPowerButton(); // Turn OFF


    
        
     flashlight.charge();          //  solar charging
     flashlight.electricCharge();  // electric charging
     Thread.sleep(4000);
     flashlight.stopAllCharging();     
    }
}

