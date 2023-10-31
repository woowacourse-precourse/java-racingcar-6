package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Iterator;
import java.util.Map;

public class Race {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Car car;

    public Race() {
    }

    public void run() {
        car = new Car(inputView.inputCarName());
        int playCount = NumberGenerator.toInt(inputView.inputPlayCount());

        System.out.println();
        System.out.println("실행 결과");

        playRace(playCount);
    }

    private void playRace(int playCount) {
        Map<String, Integer> cars = car.getCars();

        for (int i = 0; i < playCount; i++) {
            for (Map.Entry<String, Integer> entry : cars.entrySet()) {
                car.forward(entry, NumberGenerator.generateRandomNumber());
                outputView.currentScore(entry);
            }
            System.out.println();
        }
        outputView.winner(Winner.winnerList(cars, Winner.maxForward(cars)));
    }
}
