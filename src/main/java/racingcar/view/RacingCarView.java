package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RacingCarView {

    private static final String CARS_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static RacingCarView instance;

    private RacingCarView() {
    }

    public static RacingCarView getInstance() {
        if (instance == null) {
            instance = new RacingCarView();
        }

        return instance;
    }

    public void printInputCarNameMessage() {
        System.out.println(CARS_NAME_PROMPT);
    }

    public void printInputTryCountMessage() {
        System.out.println(TRY_COUNT_PROMPT);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printMoveResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car: cars) {
            sb.append(car.getName()).append(" : ");
            sb.append("-".repeat(Math.max(0, car.getCount())));
            sb.append('\n');
        }

        sb.append('\n');
        System.out.println(sb);
    }

    public void printWinner(List<Car> winnerList) {
        System.out.print("최종 우승자 : ");

        StringBuilder sb = new StringBuilder();
        for (Car winner : winnerList) {
            sb.append(winner.getName()).append(", ");
        }

        // 마지막 쉼표 제거
        String winnerString = sb.toString();
        winnerString = winnerString.substring(0, winnerString.length() - 2);

        System.out.println(winnerString);
    }
}
