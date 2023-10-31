package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int trials;

    public void getInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        NameInput.inputNames(cars);
        System.out.println("시도할 회수는 몇회인가요?");
        trials = TrialInput.inputTrial();
        System.out.println();
    }

    public void start() {
        System.out.println("실행 결과");
        IntStream.range(0, trials)
                .peek(i -> cars.forEach(Car::trial))
                .peek(i -> printMoves())
                .forEach(i -> System.out.println());
    }

    public void printMoves() {
        cars.forEach(Car::printMoves);
    }

    public void printWinner() {
        int maxPosition = getMaxPosition();
        List<String> winningCarNames = getWinningCarNames(maxPosition);
        System.out.println("\n최종 우승자 : " + String.join(", ", winningCarNames));
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
