package racingcar;

import java.util.ArrayList;

public class Circuit {
    private ArrayList<Car> carList;
    private int repeat;

    private final int IS_EMPTY = 0;
    private final int MAX_SIZE = 5;

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
        for (int i = 0; i < this.repeat; ++i) {
            for (Car car : this.carList) {
                car.move();
                car.print();
            }
            System.out.println();
        }
    }

    public void printResult() {
        int max = 0;
        for (Car car : carList) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }
        System.out.print("최종 우승자 : ");
        boolean flag = false;
        for (Car car : carList) {
            if (car.getLocation() != max) {
                continue;
            }
            if (flag) {
                System.out.print(", " + car.getName());
            } else {
                System.out.print(car.getName());
                flag = true;
            }
        }
        System.out.println();
    }

    private boolean checkInputError(String[] input) {
        if (input.length == IS_EMPTY) {
            return true;
        }
        for (String s : input) {
            if (s.length() > MAX_SIZE || s.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
