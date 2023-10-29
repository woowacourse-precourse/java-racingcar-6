package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingSystem {

    private static final String SEPARATOR = "";
    private static final int MAX_COUNT = 5;

    private List<Car> cars = new ArrayList<>();
    private Winners winners = new Winners();

    public RacingSystem() {
    }

    public void checkValid(String input) {
        String[] nameArray = input.split(SEPARATOR, -1);
        for(String name:nameArray){
            if(isInvalidName(name)) {
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
    }

    private boolean isInvalidName(String name) {
        return isDuplicated(name)
                || isOverMaxCount(name)
                || isEmptyString(name);
    }

    private boolean isDuplicated(String name) {
        for(Car car: cars) {
            if(name.equals(car.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isOverMaxCount(String name) {
        return name.length() > MAX_COUNT;
    }

    private boolean isEmptyString(String name) {
        return name == null || "".equals(name);
    }

}
