package racingcar.view;

import java.util.List;
import racingcar.car.Car;

public class OutputView {
    public String printToResult(List<String> winners) {
        String result = winnersToMulti(winners);
        return "최종 우승자 : " + result;
    }

    private String winnersToMulti(List<String> winners) {
        if (winners.size() > 1) {
            return String.join(", ", winners);
        }
        return winners.get(0);
    }

    public String resultForMiddle(List<String> names, Car car) {
        StringBuilder result = new StringBuilder();

        for (String name : names) {
            result.append(name)
                    .append(" : ")
                    .append(currentOnGO(car.getValue(name)))
                    .append("\n");
        }
        return result.toString();
    }

    private String currentOnGO(int count) {
        return "-".repeat(count);
    }
}
