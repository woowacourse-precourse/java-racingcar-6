package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final static String INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    private final static String RETRY_NUM_MSG = "시도할 회수는 몇회인가요?";
    private final static String ROUND_RESULT_MSG = "실행 결과";
    private final static String WINNER_MSG = "최종 우승자 : ";

    public static void printInputMsg(){
        System.out.println(INPUT_MSG);
    }

    public static void printRetryNumMsg(){
        System.out.println(RETRY_NUM_MSG);
    }

    public static void printResultMsg(){
        System.out.println("");
        System.out.println(ROUND_RESULT_MSG);
    }
    public static void printRoundResultMsg(List<Car> cars){

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(WINNER_MSG + winnerNames);
    }


}
