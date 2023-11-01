package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee {

    public int inputCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycle = Integer.parseInt(Console.readLine());
        if (cycle <= 0) {
            throw new IllegalArgumentException("횟수는 0보다 커야 합니다.");
        }
        return cycle;
    }

    public Car makeCar(String carNames) {
        Car car = new Car(carNames);
        return car;
    }

    public List<String> splitStringCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = Console.readLine();
        String[] carNameStringSplit = carNameString.split(",");
        List<String> carNames = new ArrayList<String>(Arrays.asList(carNameStringSplit));
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("적어도 한 대의 자동차 이름이 필요합니다.");
        }
        return carNames;
    }

    public List<Car> cars(List<String> carNamesList) {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNamesList) {
            cars.add(makeCar(carName));
        }
        return cars;
    }
}
