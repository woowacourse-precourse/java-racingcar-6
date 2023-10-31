package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.*;

public class Application {
    public static void main(String[] args) {
        startMission();
    }

    public static void startMission() {
        printStartMessage();
        List<Car> cars = inputCarNames();
        printQuestionMessage();
        int nums = inputNumberOfTimes();
        tryCarSteps(cars, nums);

    }

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static List<Car> inputCarNames() {
        String s = readLine();
        String[] carNames = s.split(",");
        if (checkCarNamesError(carNames)) {
            throw new IllegalArgumentException();
        }
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static boolean checkCarNamesError(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) return true;
        }
        return false;
    }

    public static void printQuestionMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static int inputNumberOfTimes() {
        String s = readLine();
       /* if (checkNumsError(s)) {
            throw new IllegalArgumentException();
        }*/
        return Integer.parseInt(s);
    }

    private static boolean checkNumsError(String s) {
        int tmp = Integer.parseInt(s);
        if (tmp <= 0 || tmp > 9) return true;
        return false;
    }

    public static int createRandomNumber() {
        return pickNumberInRange(0, 9);
    }

    public static void tryCarSteps(List<Car> cars, int steps) {
        for (int tryNums = 0; tryNums < steps; tryNums++) {
            cars = checkCarSteps(cars);
            printCarSteps(cars);
        }
        printWinners(checkWinners(cars));
    }

    public static void printWinners(List<Car> cars) {
        StringBuilder message = new StringBuilder("최종 우승자 : ");
        for (Car car : cars) {
            message.append(car.getCarName() + ", ");
        }
        message.delete(message.length() - 2, message.length());
        System.out.println(message);
    }

    public static List<Car> checkWinners(List<Car> cars) {
        List<Car> results = new ArrayList<>();
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getSteps() - o1.getSteps();
            }
        });
        int maxSteps = cars.get(0).getSteps();
        for (int i = 0; i < cars.size(); i++) {
            if (maxSteps == cars.get(i).getSteps()) results.add(cars.get(i));
        }
        return results;
    }

    public static void printCarSteps(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            StringBuilder message = new StringBuilder(cars.get(i).getCarName() + " : ");
            for (int j = 0; j < cars.get(i).getSteps(); j++) {
                message.append("-");
            }
            System.out.println(message);
        }
    }

    public static List<Car> checkCarSteps(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = createRandomNumber();
            if (randomNumber >= 4) cars.get(i).setSteps(cars.get(i).getSteps() + 1);
        }
        return cars;
    }

}
