package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputNames.split(","));

        validateCarNames(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        List<Car> cars = initializeCars(carNames);

        Race race = new Race(cars,tryCount);
        race.start();

        List<String> winners = race.getWinners();
        viewWinners(winners);
    }

    public static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static void validateCarNames(List<String> carNames) {
        for (String carName: carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException();
        }
    }

    public static void viewWinners(List<String> winners) {
        if (winners.size() > 1) System.out.println("최종 우승자 : " + String.join(",", winners));
        else System.out.println("최종 우승자 : " + winners.get(0));
    }
}
