package view;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import Model.Car;
public class CarRacingGameView {


    public List<String> getCarNames() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException("");
        }

        for (String name : carNames) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("");
            }
        }
        return carNames;
    }

    public int getNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        try {
            int numberOfAttempts = Integer.parseInt(input);
            return numberOfAttempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void printWinners(List<String> winners) {
        System.out.print("\n최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
    public void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
    }
}
