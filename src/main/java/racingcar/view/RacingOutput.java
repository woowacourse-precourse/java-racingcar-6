package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Match;
import racingcar.domain.Winner;

import java.util.List;
import java.util.stream.Collectors;

public class RacingOutput {

    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final char ENTER = '\n';

    public static void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRacingTryInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRacingResultMessage() {
        System.out.println(ENTER + "실행 결과");
    }

    public static void printRacingResult(Match match) {
        StringBuilder answer = new StringBuilder();
        List<Car> cars = match.getCars();

        for (Car c : cars) {
            answer.append(c.getName())
                    .append(COLON)
                    .append(c.getMoveCountToString())
                    .append(ENTER);
        }

        System.out.println(answer);
    }

    public static void printWinner(Winner winner) {
        List<Car> winners = winner.getWinners();
        String winnerJoinningString = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(COMMA));

        System.out.print("최종 우승자 : " + winnerJoinningString);
    }
}
