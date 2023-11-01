package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.validator.RacingGameValidator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;
    private final MovingCount movingCount;
    private final OutputView outputView;
    private final RacingGameValidator racingGameValidator;

    public RacingGame(MovingCount movingCount, OutputView outputView, RacingGameValidator racingGameValidator) {
        this.movingCount = movingCount;
        this.outputView = outputView;
        this.racingGameValidator = racingGameValidator;
    }

    public List<String> playRacingGame(List<String> carList, String attempt) {
        int attemptCount = Integer.parseInt(attempt);
        int size = carList.size();

        movingCount.initMovingCount(size);
        outputView.showDefaultResultSentence();

        for (int i = 0; i < attemptCount; i++) {
            extractRandomNumber(carList);
        }

        List<String> winnerList = extractResult(carList, size);
        return winnerList;
    }

    public List<Integer> extractRandomNumber(List<String> carList) {
        List<Integer> numberList = new ArrayList<>();
        int size = carList.size();

        for (int i = 0; i < size; i++) {
            numberList.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }

        moveCars(carList, numberList);
        return numberList;
    }

    public void moveCars(List<String> carList, List<Integer> numberList) {
        int size = numberList.size();

        for (int i = 0; i < size; i++) {
            int count = movingCount.getEachMovingCount(i);
            int target = numberList.get(i);
            String car = carList.get(i);
            int movingCount = evaluateMoving(target, count, i);
            outputView.showResult(car, movingCount);
        }

        System.out.println();
    }

    public int evaluateMoving(int target, int count, int index) {
        if (target >= STANDARD_NUMBER) {
            count = movingCount.addCount(index);
        }
        return count;
    }

    public List<String> extractResult(List<String> carList, int size) {
        List<Integer> resultList = extractResultList();
        racingGameValidator.validateGameTerminated(resultList);

        List<String> winnerList = new ArrayList<>();
        int max = Collections.max(resultList);

        for (int i = 0; i < size; i++) {
            if (resultList.get(i) == max) {
                winnerList.add(carList.get(i));
            }
        }
        return winnerList;
    }

    public List<Integer> extractResultList() {
        List<Integer> resultList = movingCount.getMovingCount();
        return resultList;
    }
}
