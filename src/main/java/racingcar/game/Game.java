package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.utils.PrintGuide;
import racingcar.utils.Validator;

public class Game {
    String[] carsInput;
    List<Car> carList = new ArrayList<>();
    List<String> carNames = new ArrayList<>();
    int countInputNumber;

    PrintGuide printGuide = new PrintGuide();

    public void start() {
        printGuide.printInputCarName();
        carsInput = Console.readLine().split(",");
        carNames = new ArrayList<>(Arrays.asList(carsInput));
        Validator.checkCarNameLength(carNames);
        Validator.checkCarNameCount(carNames);

        carNames.stream()
                .map(Car::new)
                .forEach(carList::add);
        printGuide.printInputCount();
        countInputNumber = Validator.checkDigit(Console.readLine());
        printGuide.printResult();

        printGuide.printWinner(game(carList, countInputNumber));
    }

    private Winner game(List<Car> cars, int count) {
        while (count-- > 0) {
            cars.stream().forEach(car -> race(car));
            cars.stream().forEach(car -> printGuide.printRaceRound(car));
            System.out.println();
        }
        Winner winner = findWinner(carList);
        return winner;
    }

    private void race(Car car) {
        int flag = Randoms.pickNumberInRange(0, 9);

        if (flag >= 4) {
            car.go();
        }
    }

    private Winner findWinner(List<Car> carsList) {
        int highestScore = carsList.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElse(0);

        ArrayList<String> winnerNames = new ArrayList<>();
        for (Car car : carsList) {
            if (car.getScore() == highestScore) {
                winnerNames.add(car.getName());
            }
        }

        return new Winner(winnerNames, highestScore);
    }
}
