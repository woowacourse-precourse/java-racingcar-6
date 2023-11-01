package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;
    private static final String MOVING_INDICATORS = "-";
    private final MovingCount movingCount;

    public RacingGame(MovingCount movingCount) {
        this.movingCount = movingCount;
    }

    public List<String> playRacingGame(List<String> carList, String attempt) {
        int attemptCount = Integer.parseInt(attempt);
        int size = carList.size();
        movingCount.initMovingCount(size);
        System.out.println("\n실행 결과");
        for(int i = 0; i < attemptCount; i++) {
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
            if (numberList.get(i) >= STANDARD_NUMBER) {
                System.out.println(carList.get(i) + " : " + MOVING_INDICATORS.repeat(movingCount.addCount(i)));
            }
            else {
                System.out.println(carList.get(i) + " : " + MOVING_INDICATORS.repeat(count));
            }
        }
        System.out.println();
    }

    public List<String> extractResult(List<String> carList, int size) {
        List<Integer> resultList = extractResultList();
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
