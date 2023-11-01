package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MessageContainer messageContainer = new MessageContainer();
        System.out.println(messageContainer.getEnterCarNames());
        String input = Console.readLine();
        Registration registration = new Registration();
        List<Car> carList = registration.createCarList(registration.getCarNames(input));

        System.out.println(messageContainer.getEnterTotalRounds());
        TotalRoundsConverter totalRoundsConverter = new TotalRoundsConverter();
        int totalRounds = totalRoundsConverter.convert(Console.readLine());

        System.out.println("\n" + messageContainer.getExecutionResult());
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < totalRounds; i++) {
            for (Car car : carList) {
                car.moveForward(numberGenerator.pickNumberFrom0To9());
            }
            for (Car car : carList) {
                System.out.println(messageContainer.showCarResult(car));
            }
            System.out.println();
        }

        Judgment judgment = new Judgment();
        List<String> winnerNames = judgment.getWinnerNames(carList, judgment.findMaxPosition(carList));
        System.out.println(messageContainer.showWinners(winnerNames));
    }
}
