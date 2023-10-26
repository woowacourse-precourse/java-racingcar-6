package racingcar;

import java.util.List;
import java.util.Arrays;

class Stadium {
    int first_pos;
    List<Car> cars;

    public stadium() {
        first_pos = 0;
        cars = new List<>();
    }

    public void carEnters(String line) {
        carNames = Arrays.asList(line.split(","));
        for (String name : carNames) {
            validateName(name);
            cars.add(new Car(name))
        }
    }

    private static void validateName(String string) throws IllegalArgumentException {

    }

    public void race() {

    }

    public void getStatus() {

    }

    public void winner() {

    }


}