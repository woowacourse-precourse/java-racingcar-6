package racingcar.model;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        validName(carName);
        this.carName = carName;
    }

    private void validName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getRawName(){
        return carName;
    }
}
