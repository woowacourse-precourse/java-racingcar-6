package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

import racingcar.domain.Trial;
import racingcar.domain.Judgement;

public class Application {
    public static void main(String[] args) {
        List<String> cars = askCars();
        int trialCount = askCount();

        List<Integer> distanceOfCars = getInitialDistances(cars);

        System.out.println();
        System.out.println("실행 결과");
        Trial trial = new Trial();
        for (int count = 0; count < trialCount; count++) {
            distanceOfCars = trial.moveForward(distanceOfCars);
            printCurrentTrial(cars, distanceOfCars);
        }

        Judgement judgement = new Judgement();
        List<String> winners = judgement.selectWinner(cars, distanceOfCars);

        printWinners(winners);
    }

    public static List<String> askCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputArray = input.split(",");

        List<String> cars = new ArrayList<>();
        for (String car : inputArray) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
            cars.add(car);
        }
        return cars;
    }

    public static int askCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> getInitialDistances(List<String> cars) {
        List<Integer> distanceOfCars = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            distanceOfCars.add(0);
        }
        return distanceOfCars;
    }

    public static void printCurrentTrial(List<String> cars, List<Integer> distanceOfCars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("%s : %s%n", cars.get(i), "-".repeat(distanceOfCars.get(i)));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s%n", winner);
    }
}
