package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.validate.ValidateNumber;

public class Output {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String RACE_RESULT_INTRO = "실행 결과";
    private static final String ONE_COUNT = "-";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";


    public static void askCarName() {
        System.out.println(ASK_CAR_NAME);
    }

    public static void askGameCount() {
        System.out.println(ASK_GAME_COUNT);
    }

    public static void printRaceResultIntro() {
        System.out.println(RACE_RESULT_INTRO);
    }

    public static void printCurrentLocation(String name, Long forwardCount) {
        System.out.println(name + " : " + makePointMessage(forwardCount));
    }

    public static void printFinalWinner(List<Car> winners) {
        String winnersList = makeWinnerList(winners);
        System.out.println(FINAL_WINNER + winnersList);
    }

    private static String makePointMessage(Long forwardCount) {
        StringBuilder pointMessageBuilder = new StringBuilder();
        ValidateNumber.validateForwardCount(forwardCount);
        while (forwardCount > 0) {
            forwardCount--;
            pointMessageBuilder.append(ONE_COUNT);
        }
        return pointMessageBuilder.toString();
    }

    private static String makeWinnerList(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
