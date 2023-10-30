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
        int playCount = toInt(inputView.inputPlayCount());

        System.out.println();
        System.out.println("실행 결과");

        playRace(playCount);
    }

    private void playRace(int playCount) {
        Iterator<Map.Entry<String, Integer>> iterator;
        Map.Entry<String, Integer> entry;

        for (int i = 0; i < playCount; i++) {
            iterator = car.getCars().entrySet().iterator();

            while (iterator.hasNext()) {
                entry = iterator.next();
                car.forward(entry, NumberGenerator.generateRandomNumber());
                outputView.currentScore(entry);
            }
            System.out.println();
        }
        Map<String, Integer> cars = car.getCars();
        outputView.winner(Winner.winnerList(cars, Winner.maxForward(cars)));
    }

    private int toInt(String inputPlayCount) {
        return Integer.parseInt(inputPlayCount);
    }
}
