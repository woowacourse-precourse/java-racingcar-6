package racingcar.utils;

import racingcar.domain.Car;
import racingcar.domain.Winner;

public class PrintGuide {
    private final String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_COUNT_MSG = "시도할 회수는 몇회인가요?";
    private final String RESULT_MSG = "\n실행 결과";
    private final String WINNER_MSG = "최종 우승자 : ";

    public void printInputCarName() {
        System.out.println(INPUT_CAR_NAME_MSG);
    }

    public void printInputCount() {
        System.out.println(INPUT_COUNT_MSG);
    }

    public void printRaceRound(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");
        stringBuilder.append("-".repeat(car.getScore()));

        System.out.println(stringBuilder);
    }

    public void printResult() {
        System.out.println(RESULT_MSG);
    }

    public void printWinner(Winner winner) {
        System.out.println(WINNER_MSG + String.join(", ", winner.getName()));
    }
}
