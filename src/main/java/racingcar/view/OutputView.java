package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.util.StringHandler;

public class OutputView {

    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "최종 우승자 : ";
    private static final String POSITION_STRING = "-";
    private static final String COLON_WITH_SPACE = " : ";

    public void printResultPhrase() {
        System.out.println(RESULT_PHRASE);
    }

    public void printWinner(List<Car> cars) {
        String winner = StringHandler.listToString(cars);
        String result = String.format("%s%s",WINNER_PHRASE,winner);

        System.out.println(result);
    }

    public void printGameProgress(Game game) {
        List<Car> cars = game.getCars();
        for(Car car : cars) {
            String progress = new StringBuilder()
                    .append(car.toString())
                    .append(COLON_WITH_SPACE)
                    .append(stackPositionString(car.getPosition()))
                    .toString();
            System.out.println(progress);
        }
    }

    public String stackPositionString(int position) {
        StringBuilder presentPosition = new StringBuilder();
        presentPosition.append(POSITION_STRING.repeat(position));

        return presentPosition.toString();
    }

    public void wrapLine() {
        System.out.println();
    }
}
