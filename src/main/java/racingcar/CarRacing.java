package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CarRacing {
    private static ArrayList<String> carNameList;
    private static int countTrial;
    private static TreeMap<String, Integer> carMoveMap = new TreeMap<>();

    CarRacing(ArrayList<String> carNameList, int countTrial) {
        this.carNameList = carNameList;
        this.countTrial = countTrial;
    }

    public static void race() {
        // 각 자동차 별로 이동 횟수 0으로 초기화
        initCarMoveToZero();
    }


    public static void initCarMoveToZero() {
        for (String carName : carNameList) {
            carMoveMap.put(carName, 0);
        }
    }
}
