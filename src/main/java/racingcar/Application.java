package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

import racingcar.domain.Trial;

public class Application {
    public static void main(String[] args) {
        List<String> cars = askCars();
        int trialCount = askCount();
//        System.out.println(trialCount);

        List<Integer> distanceOfCars = getInitialDistances(cars);
        for (int integer : distanceOfCars) {
            System.out.println(integer);
        }

        Trial trial = new Trial();
        for (int j = 0; j < trialCount; j++) {
            distanceOfCars = trial.moveForward(distanceOfCars);
            //printCurrentTrial(distanceOfCars);
        }
        for (int integer : distanceOfCars) {
            System.out.println(integer);
        }

    }

    public static List<String> askCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] inputArray = input.split(",");

        List<String> cars = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            String car = inputArray[i];
            if (car.length() > 5) {
                throw new IllegalArgumentException("유효하지 않은 입력입니다.");
            }
            cars.add(inputArray[i]);
        }
        return cars;
    }

    public static int askCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static List<Integer> getInitialDistances(List<String> cars) {
        List<Integer> distanceOfCars = new ArrayList();

        for (String car: cars) {
            distanceOfCars.add(0);
        }
        return distanceOfCars;
    }

//    public static void printCurrentTrial(List<String> cars, List<Integer> distanceOfCars) {
//
//    }
}
