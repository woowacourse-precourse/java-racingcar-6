package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

public class Screen {
    static private final String MARK = "-";

    static public String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        for (String name : names) {
            checkValidName(name);
        }
        return names;
    }

    static private void checkValidName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw (new IllegalArgumentException("Invalid Argument"));
        }
    }

    static public int askRacingTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        String time = Console.readLine();
        if (!time.matches("\\d+"))
            throw (new IllegalArgumentException("Invalid Argument"));
        return Integer.parseInt(time);
    }

    static public void displayResult(List<Car> cars) {
        for (Car car : cars) {
            String result = String.format("%s : %s", car.getName(), MARK.repeat(car.getNumberOfMove()));
            System.out.println(result);
        }
        System.out.println();
    }

    static public void displayWinners(final List<Car> cars) {
        System.out.print("최종 우승자 : ");
        System.out.println(getWinners(cars));
    }

    static private String getWinners(final List<Car> cars) {
        StringBuilder winners = new StringBuilder();
        int maximumMove = Collections.max(cars).getNumberOfMove();

        for (Car car : cars) {
            if (car.getNumberOfMove() == maximumMove) {
                winners.append(", ");
                winners.append(car.getName());
            }
        }
        return winners.toString().replaceFirst(", ", "");
    }
}
