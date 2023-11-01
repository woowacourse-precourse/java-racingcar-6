package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputConsole {

    static final StringBuilder sb = new StringBuilder();
    public static final String DISTANCE = "-";
    public static final String PARTITION = " : ";
    public static final String NEWLINE_CHARACTER = "\n";
    public static final String WINNER_MESSAGE = "최종 우승자";
    public static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String STATUS_MESSAGE = "실행 결과";

    static public void print(String message) {
        System.out.println(message);
    }

    static public void printStatus(List<Status> statuses) {
        for (Status status : statuses) {
            sb.append(status.getName())
                    .append(PARTITION)
            .append(DISTANCE.repeat(Math.max(0, status.getDistance())))
            .append(NEWLINE_CHARACTER);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    static public void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        sb.append(WINNER_MESSAGE)
                .append(PARTITION)
                .append(String.join(", ", winnerNames))
                .append(NEWLINE_CHARACTER);
        System.out.println(sb);
        sb.setLength(0);
    }

}
