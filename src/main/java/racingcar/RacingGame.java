package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    public void start() {
        HashMap<String, String> racingProgress = inputCarNames();
        for (String name : racingProgress.keySet()) {
            // need change variable name - name > carName
            System.out.println(name + racingProgress.get(name));
        }

        Integer gameTimes = inputGameTimes();
        System.out.println(gameTimes);

        for (int i = 0; i < gameTimes; i++) {
            racingProgress = eachRace(racingProgress);
        }

    }

    private HashMap<String, String> inputCarNames() {
        HashMap<String, String> racingProgress = new HashMap<String, String>();
        String[] readlineCarNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            readlineCarNames = Console.readLine().split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        for (String readlineCarName : readlineCarNames) {
            racingProgress.put(readlineCarName, "");
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
            throw new IllegalArgumentException();
        }
        return gameTimes;
    }

    private HashMap<String, String> eachRace(HashMap<String, String> racingProgress) {
        for (String carName : racingProgress.keySet()) {
            if (Randoms.pickNumberInRange(1, 9) >= 4) {
                racingProgress.put(carName, racingProgress.get(carName) + "-");
            }
            System.out.println(carName + racingProgress.get(carName));

            ;

        }
        return racingProgress;
    }

}
