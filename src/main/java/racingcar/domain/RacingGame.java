package racingcar.domain;

import static racingcar.domain.User.attempts;
import static racingcar.domain.User.totalCars;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class RacingGame {
    public static final String ATTEMPTS_RESULT_MESSAGE = "\n실행 결과";
    private static final int MIN_CAR_FORWARD_NUM = 4;
    private static final int MAX_CAR_FORWARD_NUM = 9;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_RANDOM_NUM = 9;

    User user = new User();
    GameResult gameResult = new GameResult();
    private final List<Map.Entry<String, Integer>> scoreEntryList = new ArrayList<>();

    public void playGame() {
        user.setCarsName();
        user.setAttempts();
        setScoreEntryList(user.getCarsNameArray());

        runRaceAttempts();
        gameResult.printWinner(getScoreEntryList());
    }

    public void setScoreEntryList(String[] carNameArray) {
        for(String carName : carNameArray) {
            scoreEntryList.add(new AbstractMap.SimpleEntry<>(carName, 0));
        }
    }

    public void runRaceAttempts() {
        System.out.println(ATTEMPTS_RESULT_MESSAGE);
        for(int i = 0; i < attempts; i++) {
            singleRaceAttempt();
            gameResult.singleAttemptResult(getScoreEntryList());
        }
    }

    public void singleRaceAttempt() {
        for(int j = 0; j < totalCars; j++) {
            int randomDigit = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
            if(randomDigit >= MIN_CAR_FORWARD_NUM && randomDigit <= MAX_CAR_FORWARD_NUM) {
                carMoveOneStepForward(j);
            }
        }
    }

    public void carMoveOneStepForward(int j) {
        String key = scoreEntryList.get(j).getKey();
        int value = scoreEntryList.get(j).getValue();
        Map.Entry<String, Integer> newEntry = new AbstractMap.SimpleEntry<>(key, value + 1);
        scoreEntryList.set(j, newEntry);
    }

    public List<Map.Entry<String, Integer>> getScoreEntryList() {
        return scoreEntryList;
    }
}