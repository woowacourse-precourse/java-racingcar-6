package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Controller {
    public static List<Car> inputNames() throws IllegalArgumentException{
        System.out.println(OutputMessage.MESSAGE_INPUT_NAME);
        String string = Console.readLine();
        return Car.parseCars(string);
    }

    public static int inputCount() throws IllegalArgumentException{
        System.out.println(OutputMessage.MESSAGE_INPUT_COUNT);
        try {
            int count = Integer.parseInt(Console.readLine());

            if (count < 0) {
                throw new IllegalArgumentException(OutputMessage.ERROR_COUNT_IS_NEGATIVE);
            }

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputMessage.ERROR_COUNT_NOT_A_NUMBER);
        }
    }

    public static void printResultText() {
        System.out.println(OutputMessage.MESSAGE_RESULT_TEXT);
    }

    public static void printCarStates(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }
}
