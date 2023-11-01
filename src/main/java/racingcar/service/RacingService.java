package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.NoticeType;
import racingcar.util.Validator;

public class RacingService {

    private final int FORWARD_LIMIT = 4;
    private final int LENGTH_LIMIT = 5;
    public List<String> stringToList(String str) {
        String[] strArr = str.split(",");
        Validator.validateNameLength(strArr, LENGTH_LIMIT);
        Validator.validateNameDuplicate(Arrays.asList(strArr));

        return new ArrayList<>(Arrays.asList(strArr));
    }

    public int generateRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> generateCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name, 0);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> attempt(List<Car> cars) {
        for (Car car : cars) {
            int rNum = generateRandomNum();
            car.forward(rNum, FORWARD_LIMIT);
        }
        printAttemptResult(cars);
        return cars;
    }

    public void printAttemptResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printForwards(car);
            System.out.println();
        }
        System.out.println();
    }

    public void printForwards(Car car) {
        for(int i=0;i<car.getCurrent();i++) {
            System.out.print("-");
        }
    }

    public List<String> pickWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getCurrent());
        }
        for (Car car : cars) {
            if (max == car.getCurrent()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void printWinners(List<String> winners) {
        System.out.print(NoticeType.PRINT_WINNER.getMessage());
        System.out.print(String.join(", ", winners));
    }

}
