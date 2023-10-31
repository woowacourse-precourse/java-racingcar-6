package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;

public class OutputView {
    static private String STRING_START_GAME = "실행 결과";
    static private String STRING_RESULT = "최종 우승자 : ";

    public void printStartGame() {
        System.out.println();
        System.out.println(STRING_START_GAME);
    }

    public void printCurrentGame(Cars cars) {
        StringBuilder sb = new StringBuilder();
        cars.getCars().stream().forEach(car -> {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append("-".repeat(car.getDistance()));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    public void printResult(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(STRING_RESULT);
        if (winners.size() == 1) {
            sb.append(winners.get(0));
        }
        if (winners.size() > 1) {
            sb.append(winners.stream().collect(Collectors.joining(", ")));
        }
        System.out.println(sb);
    }
}
