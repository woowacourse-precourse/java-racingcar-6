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

        for (int i = 0; i < playCount; i++) {
            Iterator<Map.Entry<String, Integer>> iterator = car.getCars().entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                if (car.isForward(NumberGenerator.generateRandomNumber())) {
                    car.forward(entry);
                }
                outputView.currentScore(entry);
            }
            System.out.println();
        }
    }

    private int toInt(String inputPlayCount) {
        return Integer.parseInt(inputPlayCount);
    }
}
