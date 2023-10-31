package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Car implements Comparable<Car> {
    private String name;
    private String position = "";
    private int distance;
    private static int round;
    private final ArrayList<Car> cars = new ArrayList<>();

    Car() {
    }

    Car(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.distance, car.distance);
    }

    private boolean checkLength(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("이름의 길이는 5글자 이하입니다");
        }
        return true;
    }

    public void makeCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        for (String name : Console.readLine().split(",")) {
            if (checkLength(name)) {
                cars.add(new Car(name));
            }
        }
    }
}
