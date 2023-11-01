package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(Console.readLine().split(","));

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = getTryNumber();
        if (tryNumber < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상만 가능합니다.");
        }
    }

    private static int getTryNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }
}
