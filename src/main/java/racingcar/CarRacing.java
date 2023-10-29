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

        int tmpCount = 0;
        while (tmpCount < countTrial) {
            createRandomNumberAndMoveCar();
        }
    }

    public static void initCarMoveToZero() {
        for (String carName : carNameList) {
            carMoveMap.put(carName, 0);
        }
    }

    public static boolean createRandomNumberAndMoveCar() {
        boolean ifMoved = false; // 이동한 자동차가 하나라도 있는지 확인

        for (Entry<String, Integer> m : carMoveMap.entrySet()) {
            String key = m.getKey();
            int value = m.getValue();
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMoveMap.replace(key, value + 1);
                ifMoved = true;
            }
        }
        return ifMoved;
    }
}
