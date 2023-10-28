package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<Car> cars = createCars(inputCarNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            cars.forEach(car -> car.moveAccordingToInput(Randoms.pickNumberInRange(1, 9)));
            GameResult.result(cars);
            System.out.println();
        }
        GameResult.finalResult(calculateWinners(cars));

    }

    public List<Car> createCars(String inputCarNames) {
        String[] split = inputCarNames.split(",");
        return Arrays.stream(split)
                .map(inputCarName -> new Car(inputCarName))
                .collect(Collectors.toList());
    }

    public List<String> calculateWinners(List<Car> cars) {
        int maxCount = cars.stream()
                .map(car -> car.getMovingCount())
                .max(Integer::compareTo)
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.getMovingCount() == maxCount)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
