package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private List<Car> cars = new ArrayList<>();
    private int numOfTime;

    void setName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        if (validate(names)) {
            for (String name : names) {
                createCars(name);
            }
        }
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

    void createCars(String name) {
        cars.add(new Car(name));
    }

    void setNumOfTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            this.numOfTime = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    void race(List<Car> cars) {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (number > 3) {
                car.advance();
            }
        }
    }

    void play() {
        setName();
        setNumOfTime();
        for (int i = 0; i < numOfTime; i++) {
            race(cars);
            printResult(cars);
        }
        printWinner(cars);
    }

    void printResult(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            int gauge = car.getGauge();
            System.out.print(name + " : ");
            for (int i = 0; i < gauge; i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void printWinner(List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        List<String> winnersName = new ArrayList<>();
        winner.add(cars.get(0));
        for (Car car : cars) {
            if (winner.get(0).getGauge() < car.getGauge()) {
                winnersName.clear();
                winnersName.add(car.getName());
            } else if (winner.get(0).getGauge() == car.getGauge()) {
                winnersName.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnersName));
    }
}
