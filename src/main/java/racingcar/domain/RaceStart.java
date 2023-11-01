package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RaceLog;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceStart {
    RaceLog raceLog = new RaceLog();

    public RaceStart() {
    }


    // 2-2. 무작위 값을 만든다: createRandomNumbers
    public HashMap createRandomNumbers(ArrayList<String> carNameList) {
        HashMap<String, Integer> carsPickNumbers = new HashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            carsPickNumbers.put(carNameList.get(i), randomNumber);
        }
        return carsPickNumbers;
    }

    // 2-3. 레이싱 기록을 업데이트 한다: pdateRaceLog
    public void updateRaceLog(ArrayList<String> carNameList, HashMap<String, Integer> tryOne, HashMap<String, String> carLogs, int raceCount) {
        for (int i = 0; i < tryOne.size(); i++) {
            String eachCarName = carNameList.get(i);
            if (raceLog.isCarAdvance(tryOne.get(eachCarName))) {
                raceLog.addEachCarsRaceLog(i, carLogs, carNameList);
            }
        }
    }

    // 2-4. 레이싱 기록(실행결과)을 출력한다: showRaceLog
    public void showRaceLog(ArrayList<String> carNameList, HashMap raceLog) {
        System.out.println("실행 결과");
        for (int i = 0; i < carNameList.size(); i++) {
            System.out.println(carNameList.get(i) + " : " + raceLog.get(carNameList.get(i)));
        }
    }
}
