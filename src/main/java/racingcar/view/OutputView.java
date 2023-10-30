package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {
    private static final String PREFIX = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    public static void promptForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void promptForRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void announceWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(PREFIX + winnerNames);
    }

    public static void currentLocation(String name, int currentNum) {
        System.out.println(name + COLON + HYPHEN.repeat(currentNum));
    }

}
