package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

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

        for (String readlineCarName : readlineCarNames) {
            if (readlineCarName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 각 5글자 이내여야 합니다.");
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
            throw new IllegalArgumentException(Integer.MAX_VALUE + "이하의 자연수만 입력하세요.");
        }

        if (gameTimes <= 0) {
            throw new IllegalArgumentException(Integer.MAX_VALUE + "이하의 자연수만 입력하세요.");
        }
        return gameTimes;
    }

    private LinkedHashMap<String, String> eachRace() {
        racingProgress.forEach((carName, driveLength) -> {
            if (Randoms.pickNumberInRange(1, 9) >= 4) {
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
