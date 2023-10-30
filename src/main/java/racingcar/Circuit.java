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

    public void setRepeat(String stringRepeat) {
        int repeat = Integer.parseInt(stringRepeat);
        if (repeat <= 0) {
            throw new IllegalArgumentException();
        }
        this.repeat = repeat;
    }

    public void race() {
        System.out.println("실행 결과");
        for (int i = 0; i < this.repeat; ++i) {
            for (Car car : this.carList) {
                car.move();
                car.print();
            }
            System.out.println();
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
