package racingcar.method;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;

public class RacingCar {
    public ArrayList<Car> createCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        ArrayList<Car> car_list = new ArrayList<>();
        for (String s : input.split(",")) {
            if (s.length() <= 5) {
                car_list.add(new Car(s));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return car_list;
    }
}
