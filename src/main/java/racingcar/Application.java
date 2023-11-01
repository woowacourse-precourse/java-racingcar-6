package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("이름 입력");
        String input = Console.readLine();
        Registration registration = new Registration();
        List<Car> carList = registration.createCarList(registration.getCarNames(input));

        NumberGenerator numberGenerator = new NumberGenerator();
        MessageContainer messageContainer = new MessageContainer();

        System.out.println("\n실행 결과");
        for (Car car : carList) {
            car.moveForward(numberGenerator.pickNumberFrom0To9());
        }
        for (Car car : carList) {
            System.out.println(messageContainer.showCarResult(car));
        }
        System.out.println();

        Judgment judgment = new Judgment();
        List<String> winnerNames = judgment.getWinnerNames(carList, judgment.findMaxPosition(carList));
        System.out.println(messageContainer.showWinners(winnerNames));
    }
}
