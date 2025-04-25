package Torch;

public class PowerButton {
    private boolean isOn = false;

    public void press() {
        isOn = !isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getState() {
        return isOn ? "ON" : "OFF";
    }
}

