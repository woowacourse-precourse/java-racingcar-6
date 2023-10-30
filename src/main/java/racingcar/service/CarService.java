package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.data.Car;

public class CarService {
    private List<Car> carList = new ArrayList<>();
    private int round;

    public void start() {
        carList = getCarList();
        round = getRound();
    }

    private List<Car> getCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] inputs = Console.readLine().split(",");

        List<Car> carList = new ArrayList<>();
        for (String input : inputs) {
            if (input.length() > 5) {
                throw new IllegalArgumentException();
            }

            carList.add(new Car(input, 0));
        }

        return carList;
    }

    private int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
