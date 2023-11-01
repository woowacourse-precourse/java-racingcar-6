package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.replaceAll("\\s", "");
    }

    static String[] splitCarName(String carString) {
        return carString.split(",");
    }

    static boolean isValidate(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    static void createCars(String[] cars, List<Car> carArr) {
        for (String car : cars) {
            carArr.add(new Car(car));
        }
    }

    static int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String numString = Console.readLine();
        return Integer.parseInt(numString);
    }

    static List<Integer> createDistanceArr(List<Car> carArr) {
        List<Integer> distanceArr = new ArrayList<>();
        for (Car car : carArr) {
            distanceArr.add(car.distance);
        }
        return distanceArr;
    }

    static int findMaxValue(List<Integer> distanceArr) {
        return Collections.max(distanceArr);
    }

    static List<Integer> findAllMaxIndex(List<Integer> distanceArr) {
        List<Integer> maxIndex = new ArrayList<>();
        int max = findMaxValue(distanceArr);

        for (int i = 0; i < distanceArr.size(); i++) {
            if (distanceArr.get(i) == max) {
                maxIndex.add(i);
            }
        }
        return maxIndex;
    }

    static List<String> findWinnerIndex(List<Car> carArr, List<Integer> maxIndex) {
        List<String> winnerArr = new ArrayList<>();
        for (int value : maxIndex) {
            winnerArr.add(carArr.get(value).name);
        }
        return winnerArr;
    }

    static void printWinner(List<String> winnerArr) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerArr));
    }

    static void game_process(List<Car> carArr) {
        int number = inputNumber();
        System.out.println("\n실행 결과");
        for (int i = 0; i < number; i++) {
            for (Car car : carArr) {
                car.moveForward();
                car.printState();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] cars = splitCarName(inputCarName());
        List<Car> carArr = new ArrayList<>();

        if (isValidate(cars)) {
            createCars(cars, carArr);
        }

        game_process(carArr);

        List<Integer> distanceArr = createDistanceArr(carArr);
        printWinner(findWinnerIndex(carArr, findAllMaxIndex(distanceArr)));
    }
}
