package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    List<RandomCar> randomCars = new ArrayList<>();

    public GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void launch() {
        List<String> names = inputView.inputCarNames();
        createRandomCars(names);

        int attemptCount = inputView.inputMoveNumber();
        moveRandomCars(attemptCount);

        selectWinners();

    }

    private void createRandomCars(List<String> names) {
        names.forEach(name -> randomCars.add(new RandomCar(name)));
    }

    private void moveRandomCars(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (RandomCar randomCar : randomCars) {
                randomCar.move();
                randomCar.printPosition();
            }
            System.out.println();
        }
    }

    private List<RandomCar> selectWinners() {
        int maxPosition = getMaxPosition();

        return randomCars.stream()
                .filter(randomCar -> randomCar.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return randomCars.stream()
                .mapToInt(RandomCar::getPosition)
                .max()
                .getAsInt();
    }
}
