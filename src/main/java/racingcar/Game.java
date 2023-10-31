package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public List<Car> createCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        for (String name : carNames) {
            Util.validateCarName(name);
        }

        Util.checkForDuplicates(carNames);

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int setAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void playGame(List<Car> cars, int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car);
            }
            System.out.println();
        }
    }

    public int getMaxValue(List<Car> cars) {
        int maxValue = 0;
        for (Car car : cars) {
            maxValue = Math.max(maxValue, car.getPosition().length());
        }

        return maxValue;
    }

    public List<String> getWinners(List<Car> cars, int maxValue) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().length() == maxValue) {
                winners.add(car.getName());
            }
        }

    }


}
