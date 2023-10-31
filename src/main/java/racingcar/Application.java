package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars;
        List<StringBuilder> presentDistance = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        cars = List.of(input.split(","));

        validateCarName(cars, presentDistance);
    }

    private static void validateCarName(List<String> cars, List<StringBuilder> presentDistance) {
        for (int i = 0; i < cars.size(); i++) {
            cars.set(i, cars.get(i).trim());

            if (cars.get(i).length() > 5 || cars.get(i).isEmpty())
                throw new IllegalArgumentException();

            presentDistance.add(new StringBuilder());
        }
    }
}
