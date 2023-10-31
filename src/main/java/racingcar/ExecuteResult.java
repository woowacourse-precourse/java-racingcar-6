package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ExecuteResult {

    private final String executeStartAnnouncement = "실행 결과";
    private List<String> winnerCarList;

    public void execute(Map<String, Integer> carMap, int tryNumber) {
        System.out.println(executeStartAnnouncement);
        for (int tn = 0; tn < tryNumber; tn++) {
            executeVerification(carMap);
            executePrint(carMap);
        }

        resultPrint(carMap);
    }

    public Map<String, Integer> executeVerification(Map<String, Integer> carMap) {
        for (String key : carMap.keySet()) {
            int randomNumber = makeRandomNumber();
            if (randomNumber >= 4) {
                carMap.put(key, carMap.get(key) + 1);
            }
        }

        return carMap;
    }

    public void executePrint(Map<String, Integer> carMap) {
        StringBuilder sb = new StringBuilder();
        for (String key : carMap.keySet()) {
            sb.append(key + " : ").append("-".repeat(carMap.get(key)) + "\n");
        }

        System.out.println(sb);
    }

    public int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void resultPrint(Map<String, Integer> carMap) {
        winnerCarList = new ArrayList<>();
        int maxValue = Collections.max(carMap.values());

        maxValueVerification(carMap, maxValue);

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 :");
        for (int w = 0; w < winnerCarList.size(); w++) {
            if (w == winnerCarList.size() - 1) {
                sb.append(" " + winnerCarList.get(w));
            } else {
                sb.append(" " + winnerCarList.get(w) + ",");
            }

        }

        System.out.println(sb);
        Console.close();
    }

    public List<String> maxValueVerification(Map<String, Integer> carMap, int maxValue) {
        for (Map.Entry<String, Integer> c : carMap.entrySet()) {
            if (c.getValue() == maxValue) {
                winnerCarList.add(c.getKey());
            }
        }
        return winnerCarList;
    }
}
