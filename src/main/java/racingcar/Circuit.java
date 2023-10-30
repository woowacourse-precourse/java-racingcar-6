package racingcar;

import java.util.ArrayList;

public class Circuit {
    private ArrayList<Car> carList;
    private int repeat;

    public Circuit() {
        this.carList = new ArrayList<Car>();
        this.repeat = 0;
    }

    public void makeCarList(String input) {
        String[] splitInput = input.split(",");
        if (checkInputError(splitInput)) {
            throw new IllegalArgumentException();
        }
        for (String s : splitInput) {
            carList.add(new Car(s));
        }
    }

    private boolean checkInputError(String[] input) {
        for (String s : input) {
            if (s.length() > 5 || s.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
