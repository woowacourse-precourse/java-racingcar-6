package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String, String> forwardMap;

    public static void main(String[] args) {
        forwardMap = new HashMap<>();
        // 1. 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        getCars();

        // 2. 시도횟수 입력받기
        System.out.println("시도할 횟수는 몇회인가요?");
        int move = getMove();
        System.out.println();

        // 3. 시도횟수만큼 전진 처리
        System.out.println("실행 결과");
        for (int i = 0; i < move; i++) {
            move();
        }
    }

    static void getCars() {
        String carNames = Console.readLine();
        for (String car : carNames.split(",")) {
            String carName = car.trim();
            if (carName.length() > 5 || forwardMap.containsKey(carName)) {
                throw new IllegalArgumentException();
            }
            forwardMap.put(carName, "");
        }
    }

    static int getMove() {
        return Integer.parseInt(Console.readLine());
    }

    static void move() {
        for (String car : forwardMap.keySet()) {
            System.out.print(car + " : ");
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                forwardMap.put(car, forwardMap.get(car) + "-");
            }
            System.out.println(forwardMap.get(car));
        }
        System.out.println();
    }
}
