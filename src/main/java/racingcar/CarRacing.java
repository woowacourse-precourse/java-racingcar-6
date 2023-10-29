package racingcar;

import static racingcar.Enum.COLON;
import static racingcar.Enum.MOVE;
import static racingcar.Enum.WINNER;

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

        int tmpCountTrial = 0;
        // 사용자가 입력한 횟수에 다가갈 때 까지 반복
        while (tmpCountTrial < countTrial) {
            boolean ifMoved = moveCar();
            // 하나라도 움직인 차가 있다면 tmpCount 횟수 증가
            if (ifMoved == true) {
                tmpCountTrial++;
            }
            printRacingCar();
        }
    }

    public static void printWinner() {
        ArrayList<String> winner = new ArrayList<>();

        for (Entry<String, Integer> e : carMoveMap.entrySet()) {
            String key = e.getKey();
            int value = e.getValue();

            if (value == countTrial) {
                winner.add(key);
            }
        }

        System.out.println(WINNER.getMessage() + String.join(", ", winner));
    }

    public static void initCarMoveToZero() {
        for (String carName : carNameList) {
            carMoveMap.put(carName, 0);
        }
    }

    //  랜덤으로 0-9 사이 숫자 하나를 생성해서 반환
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean moveCar() {
        boolean ifMoved = false; // 이동한 자동차가 하나라도 있는지 확인

        for (Entry<String, Integer> m : carMoveMap.entrySet()) {
            String key = m.getKey();
            int value = m.getValue();

            if (createRandomNumber() >= 4) {
                carMoveMap.replace(key, value + 1);
                ifMoved = true;
            }
        }

        return ifMoved;
    }

    public static void printRacingCar() {
        for (Entry<String, Integer> e : carMoveMap.entrySet()) {
            String key = e.getKey();
            int value = e.getValue();

            System.out.print(key + COLON.getMessage());
            for (int i = 0; i < value; i++) {
                System.out.print(MOVE.getMessage());
            }
            System.out.println();
        }
        System.out.println();
    }
}