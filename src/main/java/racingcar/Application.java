package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static List<String> createCarNames(String userInput) {
        return Arrays.asList(userInput.split(","));
    }


    private static int calculateMaxDistance(Car car) {
        int maxDistance = 0;

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance <= car.movedDistances.get(i).length()) {
                maxDistance = car.movedDistances.get(i).length();
            }

        }

        return maxDistance;
    }

    private static void findWinner(Car car, int maxDistance) {
        System.out.print("최종 우승자 : ");
        int count = 0;

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance == car.movedDistances.get(i).length()) {

                if (count++ != 0) {
                    System.out.print(", ");
                }

                System.out.print(car.names.get(i));
            }
        }
    }

    private static int createRoundCount(String userInput) {
        Validator.checkPositiveNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구 현

        // 1. 자동차 이름 입력
        Car car = new Car(createCarNames(getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")));

        car.move(Application.createRoundCount(getInput("시도할 회수는 몇회인가요?")));

        Application.findWinner(car, Application.calculateMaxDistance(car));

    }
}
