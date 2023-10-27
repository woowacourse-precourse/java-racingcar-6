package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        List<String> cars = Arrays.stream(Console.readLine().split(","))
                        .toList();
        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());
        // System.out.println(cars);
        // System.out.println(round);
        Console.close();
    }
}
