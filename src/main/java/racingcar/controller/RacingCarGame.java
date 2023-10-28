package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {
    private Car car;
    private Validator validator;
    private int[] count;

    public RacingCarGame() {
        car = new Car();
        validator = new Validator();
        count = new int[splitCarNamesByComma().size()];
    }

    public List<String> splitCarNamesByComma() {
        List<String> carNameList = new ArrayList<>();

        String carName = InputView.getCarNameFromPlayer();
        if (validator.isCarNameFromPlayerValidate(carName)) {
            String[] carNameArray = carName.split(",");
            for (int i = 0; i < carNameArray.length; i++) {
                carNameList.add(carNameArray[i]);
            }
        }
        return carNameList;
    }

    public void moveCarForward() {
        for (int i = 0; i < splitCarNamesByComma().size(); i++) {
            OutputView.printExecutionResult(splitCarNamesByComma().get(i));
            count[i]++;
        }
    }

    public void accumulateCarMoving() {
        String attempt = InputView.getNumberFromPlayer();
        int attemptNumber = Integer.parseInt(attempt);
        if (validator.isNumberFromPlayerValidate(attempt)) {
            for (int i = 0; i < attemptNumber; i++) {
                moveCarForward();
            }
        }
    }

    public void compareCarsAndGetWinner() {
        int max = Arrays.stream(count).max().getAsInt();
        IntStream maxIndex = IntStream.range(0, count.length).filter(i -> count[i] == max);
        List<String> carNameList = splitCarNamesByComma();

        if (maxIndex.count() == 1) {
            int maxIndexNumber = Integer.parseInt(maxIndex.toString());
            String winner = carNameList.get(maxIndexNumber);
            OutputView.printSoleWinner(winner);
        } else {
            int[] maxIndexNumberArray = maxIndex.toArray();
            String[] winners = new String[maxIndexNumberArray.length];
            for (int i = 0; i < maxIndexNumberArray.length; i++) {
                winners[i] = carNameList.get(i);
            }
            OutputView.printJointWinner(winners);
        }
    }
}
