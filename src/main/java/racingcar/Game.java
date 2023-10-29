package racingcar;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private Cars cars = new Cars(setName());

    List<Car> setName() {
        List<Car> cars = new ArrayList<>();
        out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        if (validate(names)) {
            for (String name : names) {
                cars.add(new Car(name));
                // createCars(name);
            }
        }
        return cars;
    }

    boolean validate(String[] names) {
        boolean result = true;
        for (String name : names) {
            if (name.length() > 5) {
                result = false;
                IllegalArgumentException e = new IllegalArgumentException();
                throw e;
            }
        }
        return result;
    }

    int setNumOfTime() {
        out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    void advance(Car car) {
        int gauge = car.getGauge();
        car.setGauge(++gauge);
    }

    void race(Cars cars) {
        for (Car car : cars.getList()) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (number > 3) {
                advance(car);
            }
        }
    }

    void play() {
        int numOfTime = setNumOfTime();
        for (int i = 0; i < numOfTime; i++) {
            race(cars);
            printResult(cars);
        }
        printWinner(cars);
    }

    void printResult(Cars cars) {
        for (Car car : cars.getList()) {
            String name = car.getName();
            int gauge = car.getGauge();
            out.print(name + " : ");
            for (int i = 0; i < gauge; i++) {
                out.print("-");
            }
            out.println("");
        }
        out.println("");
    }

    void printWinner(Cars cars) {
        int winnerScore = 0;
        List<Car> winners = new ArrayList<>();
        List<String> winnersName = new ArrayList<>();
        for (Car car : cars.getList()) {
            if (winnerScore < car.getGauge()) {
                winnerScore = car.getGauge();
                winners.clear();
                winners.add(car);
            } else if (winnerScore == car.getGauge()) {
                winners.add(car);
            }
        }
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }
        out.print("최종 우승자 : ");
        out.println(String.join(", ", winnersName));
    }
}
