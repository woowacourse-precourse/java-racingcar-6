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
            moveForward(carQuantity, positions);
            printRoundResults(cars, positions);
        }

        printWinners(cars, positions);
    }

    private static void moveForward(int carQuantity, int[] positions) {
        for (int j = 0; j < carQuantity; j++) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                positions[j]++;
            }
        }
    }



    private static void printRoundResults(String[] carNames, int[] positions) {
        for (int i = 0; i < carNames.length; i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < positions[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
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
