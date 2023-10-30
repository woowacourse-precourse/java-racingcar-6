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
        String[] splittedInput = input.split(",");
        for (String s : splittedInput) {
            carList.add(new Car(s));
        }
    }
}
