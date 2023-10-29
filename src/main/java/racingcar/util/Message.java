package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class Message {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printCreateCarListMessage(String car) {
        System.out.println(car);
    }

    public void printAskCountMessage(int num) {
        System.out.println(ASK_COUNT_MESSAGE + "\n" + num);
    }

    public void printRacingResultMessage(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }

    public void printMoveResultMessage(List<Car> carList) {
        carList.forEach(x ->
                System.out.println(x.getName() + " : " + "-".repeat(x.getMoveCount()))
        );
        System.out.println();
    }
}
