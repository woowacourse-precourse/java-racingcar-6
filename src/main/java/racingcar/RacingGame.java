package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
    private static final int ADVANCE_TRIGGER = 4;
    private static final int CAR_MAX_COUNT = Integer.MAX_VALUE;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final boolean CAR_NAME_DUPLICATION = false;
    private static final int MAX_GAME_TIMES = Integer.MAX_VALUE;

    LinkedHashMap<String, String> racingProgress;
    Integer gameTimes;

    public void start() {
        racingProgress = inputCarNames();

        gameTimes = inputGameTimes();

        racingProgress = racingWhileGameTimes();

        racingResult();

    }

    private LinkedHashMap<String, String> inputCarNames() {
        racingProgress = new LinkedHashMap<String, String>();
        String[] readlineCarNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            readlineCarNames = Console.readLine().split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        if (readlineCarNames.length > CAR_MAX_COUNT) {
            throw new IllegalArgumentException(CAR_MAX_COUNT + "개 이하의 자동차 이름을 입력해 주세요.");
        }
        for (String readlineCarName : readlineCarNames) {
            if (readlineCarName.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름은 각 5글자 이내여야 합니다.");
            } else if (CAR_NAME_DUPLICATION || racingProgress.containsKey(readlineCarName)) {
                throw new IllegalArgumentException("자동차의 이름은 서로 달라야 합니다.");
            } else {
                racingProgress.put(readlineCarName, "");
            }
        }

        return racingProgress;
    }

    private Integer inputGameTimes() {
        Integer gameTimes;

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            String readlineGameTimes = Console.readLine();
            gameTimes = Integer.parseInt(readlineGameTimes);
        } catch (Exception e) {
            throw new IllegalArgumentException(MAX_GAME_TIMES + "이하의 자연수만 입력하세요.");
        }

        if (gameTimes <= 0 || gameTimes > MAX_GAME_TIMES) {
            throw new IllegalArgumentException(MAX_GAME_TIMES + "이하의 자연수만 입력하세요.");
        }
        return gameTimes;
    }

    private LinkedHashMap<String, String> eachRace() {
        racingProgress.forEach((carName, driveLength) -> {
            if (Randoms.pickNumberInRange(1, 9) >= ADVANCE_TRIGGER) {
                racingProgress.put(carName, racingProgress.get(carName) + "-");
            }
            System.out.println(carName + " : " + racingProgress.get(carName));
        });

        System.out.println("");

        return racingProgress;
    }

    private LinkedHashMap<String, String> racingWhileGameTimes() {

        System.out.println("");
        System.out.println("실행 결과");

        for (int i = 0; i < gameTimes; i++) {
            racingProgress = eachRace();
        }

        return racingProgress;
    }

    private void racingResult() {
        int winnerDriveLength = 0;
        ArrayList<String> winner = new ArrayList<>();

        for (String carName : racingProgress.keySet()) {
            if (winnerDriveLength < racingProgress.get(carName).length()) {
                winner.clear();
                winner.add(carName);
                winnerDriveLength = racingProgress.get(carName).length();
            } else if (winnerDriveLength == racingProgress.get(carName).length()) {
                winner.add(carName);
            }
        }

        String result = String.join(",", winner);
        System.out.println("최종 우승자 : " + result);
    }
}
