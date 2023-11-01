package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final String name;
    private int position = 0;
    private final StringBuffer sb;


    public Car (String name) {
        this.name = name;
        this.sb = new StringBuffer();
        this.sb.append(name);
        this.sb.append(" : ");

    }
    public void move() {
        int num = Randoms.pickNumberInRange(1, 9);
        if (num >= 4) {
            this.position++;
            this.sb.append("-");
        }
    }
    public int carPosition() {
        return this.position;
    }

    public String carNamePrint() {
        return this.name;
    }

    public void finalresult() {
        System.out.println(sb);
    }

    public static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}

