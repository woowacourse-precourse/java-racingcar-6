package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final RandomNumberGenerator numberGenerator;

    public GameController(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        // 게임 초기 설정
        List<Car> cars = createCars();
        int numberOfAttempts = InputView.readNumberOfAttempts();
        if (!(1 <= numberOfAttempts && numberOfAttempts <= 100)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상 100 이하만 가능합니다.");
        }

        // 게임 진행
        playRacing(cars, numberOfAttempts);
        List<String> winners = judge(cars);
        OutputView.printWinners(winners);
    }

    private List<Car> createCars() {
        List<String> carNames = InputView.readCarNames();
        if (!(2 <= carNames.size() && carNames.size() <= 10)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 10대 이하만 가능합니다.");
        }
        for (int i = 0; i < carNames.size(); i++) {
            List<String> remainingCarNames = carNames.subList(i + 1, carNames.size());
            if (remainingCarNames.contains(carNames.get(i))) {
                throw new IllegalArgumentException("[ERROR] 중복되는 자동차 이름이 존재합니다.");
            }
        }
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void playRacing(List<Car> cars, int numberOfAttempts) {
        OutputView.printRacingResultMessage();
        while (numberOfAttempts > 0) {
            List<Integer> forwardCounts = getForwardCounts(cars);
            List<String> carNames = getCarNames(cars);
            OutputView.printRacingResult(carNames, forwardCounts);
            numberOfAttempts--;
        }
    }

    private List<Integer> getForwardCounts(List<Car> cars) {
        List<Integer> forwardCounts = new ArrayList<>();
        for (Car car : cars) {
            int forwardCount = car.moveForward(numberGenerator.generate());
            forwardCounts.add(forwardCount);
        }
        return forwardCounts;
    }

    private List<String> getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    private List<String> judge(List<Car> cars) {
        Referee referee = new Referee();
        return getWinners(referee, cars);
    }

    private List<String> getWinners(Referee referee, List<Car> cars) {
        return referee.judge(cars)
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
