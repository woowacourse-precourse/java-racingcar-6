package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int trials;

    public void getInfo() {
        NameInput.inputNames(cars);
        trials = TrialInput.inputTrial();
    }

    public void start() {
        IntStream.range(0, trials).forEach(i -> cars.forEach(Car::trial));
    }

    public void printMoves() {
        cars.forEach(Car::printMoves);
    }

    public void printWinner() {
        int maxPosition = getMaxPosition();
        List<String> winningCarNames = getWinningCarNames(maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winningCarNames));
    }

    private List<String> getWinningCarNames(int maxPosition) {
        List<String> winningCarNames = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .forEach(car -> winningCarNames.add(car.getName()));
        return winningCarNames;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
