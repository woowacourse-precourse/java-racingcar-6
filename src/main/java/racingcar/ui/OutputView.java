package racingcar.ui;

import racingcar.business.Car;

public class OutputView {

    public void print(Output output) {
        System.out.println(output.getComment());
    }

    public void printMoveResult(Car car) {
        String toHyphen = convertDistanceToHyphen(car.getDistance());
        System.out.println(car.getName() + Output.SEPARATOR.getComment() + toHyphen);
    }

    public void printWinnerNames(String winnerNames) {
        System.out.println(Output.WINNER_COMMENT.getComment() + winnerNames);
    }

    private String convertDistanceToHyphen(Integer distance) {
        String result = "";

        for (int i = 0; i < distance; i++) {
            result += "-";
        }

        return result;
    }

}
