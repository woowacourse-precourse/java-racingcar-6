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
        List<String> carList = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carMap.put(carName, 0);
            carList.add(carName);
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
            carMovement(carMap, carName);
        }
    }
    public static void carMovement(Map<String, Integer> carMap, String carName) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carMap.put(carName, carMap.get(carName) + 1);
        }
        System.out.print(carName + " : ");
        for (int i = 0; i<carMap.get(carName); i++) {
            System.out.print("-");
        }
    }
}
