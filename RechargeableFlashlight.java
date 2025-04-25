package Torch;

public class RechargeableFlashlight extends Flashlight {
    private SolarPanel solarPanel;
    private ElectricCharger electricCharger;

    public RechargeableFlashlight(Battery battery) {
        super(battery);
        this.solarPanel = new SolarPanel(battery);
        this.electricCharger = new ElectricCharger(battery);
    }

    @Override
    public void charge() {
        if (!solarPanel.isAlive()) {
            solarPanel.start();
        }
    }

    public void electricCharge() {
        if (!electricCharger.isAlive()) {
            electricCharger.start();
        }
    }

    public void stopAllCharging() {
        solarPanel.interrupt();
        electricCharger.interrupt();
    }
}

