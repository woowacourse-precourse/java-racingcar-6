package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "실행 결과";

    private static final String SEPARATOR = ",";

    public void play() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        List<Car> cars = splitToCarList(input);

        System.out.println(INPUT_COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println(GAME_RESULT);
        for (int i = 0; i < count; i++) {
           cars.forEach(Car::forward);
            System.out.println();
        }
    }

    private List<Car> splitToCarList(String input) {
        return Stream.of(input.split(SEPARATOR))
                .map(Car::new)
                .toList();
    }
}
