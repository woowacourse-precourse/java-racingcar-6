package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(getCar().toString());
    }

    public static String[] getCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String answer = Console.readLine();
        String[] carNames = answer.split(",");
        return carNames;
    }

    public static int getCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String answer = Console.readLine();
        //TODO: Max값 확인도 해야하지 않을까?
        if (!answer.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(answer);
    }

    public static Map<String, Integer> cars;

    public static void race() {
        cars = new HashMap<>();
        String[] carNames = getCar();
        for (String name : carNames) {
            cars.put(name, 0);
        }

        int count = getCount();
        for (int i = 0; i < count; i++) {
            //TODO: 들여쓰기!!!!
            for (int j = 0; j < cars.size(); j++) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    cars.put(carNames[j], cars.get(carNames[j]) + 1);
                }
            }
        }
    }

}
