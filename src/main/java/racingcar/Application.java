package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static Map<String, Integer> countOfStep;
    private static int numberOfTimes = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        input();
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTimes; i++) {
            set();
        }
    }

    private static void set() {
        for (String car : countOfStep.keySet()) {
            if(Randoms.pickNumberInRange(0,9) >= 4)
                countOfStep.put(car, countOfStep.get(car) + 1);
        }

        for (Map.Entry<String, Integer> entry : countOfStep.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
        System.out.println();
    }


    private static void input() {
        countOfStep = new HashMap<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        for (String carName : input.split(",")) {
            if (countOfStep.containsKey(carName))
                throw new IllegalArgumentException("경주할 자동차 이름이 중복되었습니다. 고유한 이름을 입력해주세요.");
            else if (carName.length() > 5)
                throw new IllegalArgumentException("경주할 자동차 이름을 5자 이내로 설정해주세요.");
            else if (carName.length() > 0)
                countOfStep.put(carName, 0);
        }

        if (countOfStep.size() < 2)
            throw new IllegalArgumentException("경주할 자동차는 2대 이상을 입력해주세요.");

        System.out.println("시도할 회수는 몇회인가요?");
        numberOfTimes = Integer.parseInt(Console.readLine());
        if (numberOfTimes < 1 || numberOfTimes > 100)
            throw new IllegalArgumentException("시도 횟수는 1-100 사이의 숫자를 입력해주세요.");
    }
}
