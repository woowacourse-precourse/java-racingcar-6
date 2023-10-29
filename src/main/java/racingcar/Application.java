package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class Application {

    private static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static List<String> createCarNames(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    private static int checkPositiveNumber(String userInput) {
        int roundCount;

        try {
            roundCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }

        if (roundCount <= 0) {
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요.");
        }
        return roundCount;
    }

    private static int calculateMaxDistance(Car car) {
        int maxDistance = 0;

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance <= car.movedCount.get(i).length()) {
                maxDistance = car.movedCount.get(i).length();
            }

        }

        return maxDistance;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구 현

        // 1. 자동차 이름 입력
        Car car = Car.getInstance(createCarNames(getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")));

        car.initializeMovedCount();
        car.move(Application.checkPositiveNumber(getInput("시도할 회수는 몇회인가요?")));

        // 4. 우승자 출력
        int maxDistance = Application.calculateMaxDistance(car);

        System.out.print("최종 우승자 : ");
        int count = 0;

        for (int i = 0; i < car.names.size(); i++) {

            if (maxDistance == car.movedCount.get(i).length()) {

                if (count++ != 0) {
                    System.out.print(", ");
                }

                System.out.print(car.names.get(i));
            }
        }
    }
}
