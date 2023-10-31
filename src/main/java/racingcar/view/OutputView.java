package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.StringHandler;

public class OutputView {

    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "최종 우승자 : ";

    public void printResultPhrase() {
        System.out.println(RESULT_PHRASE);
    }

    public void printWinner(List<Car> cars) {
        String winner = StringHandler.listToString(cars);
        String result = String.format("%s%s",WINNER_PHRASE,winner);

        System.out.println(result);
    }

}
