package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> cars = List.of(Console.readLine().split(","));

//        cars.forEach(carName -> System.out.println(carName));
        // 자동차 이름 검사 로직
        for (String name : cars) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException();
            if (name.length() > 5) throw new IllegalArgumentException();
        }

        // 시도 회수 검사 로직
        int tryCount;

        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (tryCount == 0) throw new IllegalArgumentException();










    }
}
