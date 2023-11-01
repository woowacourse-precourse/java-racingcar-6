package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.RandomNumberGenerator;
import racingcar.View.RacingGameView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class RacingGameController {
    private List<Car> cars;
    private RacingGameView view;
    private RandomNumberGenerator randomNumberGenerator;
    public RacingGameController(List<String> carNames, RacingGameView view,RandomNumberGenerator randomNumberGenerator) {
        this.view = view;
        cars = new ArrayList<>();
        this.randomNumberGenerator = randomNumberGenerator;

        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : carNames) {
            if(carName.length()>5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            cars.add(new Car(carName));
        }
    }

    public void startGame(int game){
        if (game <= 0) {
            throw new IllegalArgumentException("게임 횟수는 1 이상이어야 합니다.");
        }
        for (int i = 0; i < game; i++) {
            for (Car car : cars) {
                car.move(randomNumberGenerator);

            }
            view.displayStatus(cars);
        }
        List<String> winners = findWinner(cars);
        view.printWinners(winners);
    }

    public List<String> findWinner(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}




