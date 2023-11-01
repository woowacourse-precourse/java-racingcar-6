package racingcar.model;

public class Car {
    private String carName;
    private int carCurrentPosition;

    public Car(String name) {
        setCarName(name);
        this.carCurrentPosition = 0;
    }

    public void moveFowardCar() {
        carCurrentPosition++;
    }

    public void setCarName(String name) {
        if (isValidName(name)) {
            carName = name;
        } else {
            throw new IllegalArgumentException("정상적이지 않은 이름입니다.");
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getCarCurrentPosition() {
        return carCurrentPosition;
    }

    private boolean isValidName(String name) {
        String[] names = name.split(",");
        if (names.length == 0) {
            return false;
        }
        for (String singleName : names) {
            if (singleName.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
