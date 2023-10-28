package Model;

public class CarName {
    private String carName;

    public CarName(String carName) {
        this.carName = carName;
    }

    public boolean isNameUnder5Characters() {
        return carName.length() <= 5;
    }

    public boolean isCarNameEmpty() {
        return carName.isEmpty();
    }

    public String getCarName() {
        return carName;
    }
}
