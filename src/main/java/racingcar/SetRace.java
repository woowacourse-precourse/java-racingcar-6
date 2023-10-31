package racingcar;

import model.Car;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class SetRace {
    private final List<Car> carsList = new ArrayList<>();
    public List<Car> createCar() {
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        String[] carNames = input.split(",");

        // 각 자동차 이름에 대해 Car 객체 생성
        for (String carName : carNames) {
            Car car = new Car(carName);
            carsList.add(car);
        }
        return carsList;
    }

    public int inputMovement() {
        System.out.println("이동할 횟수를 입력하세요");
        String time = Console.readLine();
        int number = Integer.parseInt(time);
        return number;
    }
}
