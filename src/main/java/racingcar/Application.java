package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        Map<String, Integer> carMap = new HashMap<>();
        Map<String, Integer> sameName = new HashMap<>();
        List<String> carList = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (carMap.containsKey(carName)) {
                sameName.put(carName, sameName.getOrDefault(carName, 0) + 1);
                carMap.put(carName + " " + sameName.get(carName), 0);
                carList.add(carName + " " + sameName.get(carName));
            } else {
                carMap.put(carName, 0);
                carList.add(carName);
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum;
        try {
            tryNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        System.out.println("실행 결과");
        for (String carName : carList) {
            carMovement(carMap, carName, tryNum);
        }
        List<String> winner = new ArrayList<>();
        int highestValue = 0;
        for (String carName : carList) {
            int carValue = carMap.get(carName);
            if (carValue > highestValue) {
                highestValue = carValue;
                winner.clear();
                winner.add(carName);
            } else if (carValue == highestValue) {
                winner.add(carName);
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            String[] winnerSameName = winner.get(i).split(" ");
            System.out.print(winnerSameName[0]);
            if (i != winner.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void carMovement(Map<String, Integer> carMap, String carName, int count) {
        for (int i = 0; i < count; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carMap.put(carName, carMap.get(carName) + 1);
            }
        }
        String[] sameName = carName.split(" ");
        System.out.print(sameName[0] + " : ");
        for (int i = 0; i < carMap.get(carName); i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
