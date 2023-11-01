package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;




public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        String[] cars = input.getCars();

        int trys = input.getTrys();

        Validator.validateInput(cars, trys);

        int carQuantity = cars.length;
        int[] positions = new int[carQuantity];

        for (int i = 0; i < trys; i++) {
            Move.moveForward(carQuantity, positions);
            Race.excute(cars, positions);
        }

        printWinners(cars, positions);
    }







    private static void printWinners(String[] carNames, int[] positions) {
        int maxPosition = 0;
        for (int position : positions) {
            maxPosition = getMaxPosition(maxPosition, position);
        }

        StringBuilder winners = new StringBuilder();
        for (int i = 0; i < carNames.length; i++) {
            if (positions[i] == maxPosition) {
                appendWinners(winners, carNames[i]);
            }
        }

        System.out.println("최종 우승자 : " + winners.toString());
    }

    private static int getMaxPosition(int maxPosition, int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
        return maxPosition;
    }

    private static void appendWinners(StringBuilder winners, String carNames) {
        if (winners.length() > 0) {
            winners.append(", ");
        }
        winners.append(carNames);
    }
}
