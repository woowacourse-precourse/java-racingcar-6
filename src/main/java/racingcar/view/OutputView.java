package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Winner;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String HYPHEN = "-";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String COMMA = ", ";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printMoveRacingCar(RacingCars racingCars) {
        for(RacingCar racingCar : racingCars.getRacingCars()){
            System.out.println(drawMoveCar(racingCar));
        }
        System.out.println();

    }

    public static void printWinner(Winner winner) {
        System.out.print(String.format(WINNER_MESSAGE, String.join(COMMA, winner.getWinners())));
    }

    private static String drawMoveCar(RacingCar racingCar){
        String carMoveString = drawHyphen(racingCar.getMove());
        return racingCar.getName() + " : " + carMoveString;
    }

    private static String drawHyphen(int moveCount){
        return HYPHEN.repeat(moveCount);
    }
}
