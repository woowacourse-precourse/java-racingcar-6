package racingcar.model;

public class CarNameManager {

    public void setName(Car car, String name) {
        if (isValidName(name)) {
            car.setCarName(name);
        } else {
            throw new IllegalArgumentException("Invalid name format.");
        }
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

