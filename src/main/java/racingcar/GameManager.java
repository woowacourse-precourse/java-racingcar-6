package racingcar;

import racingcar.domain.RandomCar;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;

    private Referee referee;
    List<RandomCar> randomCars = new ArrayList<>();

    public GameManager(InputView inputView, OutputView outputView, Referee referee) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.referee = referee;
    }

    public void launch() {
        List<String> names = inputView.inputCarNames();
        createRandomCars(names);

        int trialCount = inputView.inputTrialCount();
        moveRandomCars(trialCount);

        List<RandomCar> winnerCars = referee.selectWinners(randomCars);

        outputView.printWinnerList(winnerCars);
    }

    private void createRandomCars(List<String> names) {
        names.forEach(name -> randomCars.add(new RandomCar(name)));
    }

    private void moveRandomCars(int trialCount) {
        for (int i = 0; i < trialCount; i++) {
            for (RandomCar randomCar : randomCars) {
                randomCar.move();
            }
            outputView.printCarsPosition(randomCars);
        }
    }
}
