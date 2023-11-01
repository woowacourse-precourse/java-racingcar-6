package racingcar.view;

import racingcar.model.Car;
import racingcar.util.GameMessage;
import java.util.List;



public class OutputView {

    private static final String SEPARATOR_NAME_MOVE = " : ";
    private static final String SEPARATOR_WINNER = ", ";
    private static final String SIGN_MOVE = "-";

    public static void printRequestCarNames() {
        System.out.println(GameMessage.REQUEST_CAR_NAMES.getMessage());
    }

    public static void printRequestNumberOfTurns() {
        System.out.println(GameMessage.REQUEST_NUMBER_OF_TURNS.getMessage());
    }

    public static void printRaceResultTitle() {
        System.out.println(GameMessage.RACE_RESULT_TITLE.getMessage());
    }

    public static void printTurns(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + SEPARATOR_NAME_MOVE);
            printMove(car.getPosition());
        }
        System.out.println();
    }
    public static void printRaceWinners(List<String> winners) {
        System.out.print(GameMessage.RACE_WINNER.getMessage());
        String raceWinners = String.join(SEPARATOR_WINNER, winners);
        System.out.println(raceWinners);
    }

    public static void printMove(int count) {
        String signMove = SIGN_MOVE.repeat(count);
        System.out.println(signMove);
    }






}
