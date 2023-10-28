package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Stadium {
    private final List<Car> cars = new ArrayList<>();
    private int tryCount;

    public Stadium() {
    }

    String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    void saveInputCars(String inputCars) {
        List<String> carNames = List.of(inputCars.split(","));
        for (String name : carNames) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("각 자동차 이름은 5자 이하여야 한다.");
            }
            this.cars.add(new Car(name, 0));
        }
    }

    String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    void saveTryCount(String inputNumber) {
        int count;
        try {
            count = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 한다.");
        }
        if (count < 0) {
            throw new IllegalArgumentException("음이 아닌 숫자만 입력해야 한다.");
        }

        this.tryCount = count;
    }

    void runAllCars() {
        this.cars.forEach(Car::run);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
