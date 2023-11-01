package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> carNames;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = List.of(Console.readLine().split(","));

        for (String car : carNames) {
            if(car.length() > 5)
                throw new IllegalArgumentException();
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int forwardCount = Integer.parseInt(Console.readLine());

    }
}
