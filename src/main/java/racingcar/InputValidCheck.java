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

    public void isDigit(String input) {

        char[] count = input.toCharArray();

        for( char x : count ) {
            if ( !(x >= '0' && x <= '9') ) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void isValidLength(String input) {

        if ( input.length() > 5 ) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidCarCount(String[] input) {

        if ( input.length < 2 ) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidRacingCount(String input) {

        if ( input.isEmpty() ) {
            throw new IllegalArgumentException();
        }

        if ( input.isBlank() ) {
            throw new IllegalArgumentException();
        }
    }
}