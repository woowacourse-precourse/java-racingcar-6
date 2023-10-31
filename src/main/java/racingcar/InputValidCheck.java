package racingcar;

import java.util.ArrayList;
public class InputValidCheck {

    public void isNameRepeat(ArrayList<Car> cars) {

        ArrayList<String> existName = new ArrayList<>();

        for ( Car car : cars ) {
            if ( existName.contains(car.name) ) {
                throw new IllegalArgumentException();
            } else {
                existName.add(car.name);
            }
        }
    }

}
