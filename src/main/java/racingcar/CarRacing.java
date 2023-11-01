package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarRacing {
    int attemptCount;
    List<Car> cars;

    CarRacing() {
        this.attemptCount = 0;
        this.cars = new ArrayList<Car>();
    }

    void setCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    void setAttemptCount(String count) {
        attemptCount = Integer.parseInt(count);
    }

    boolean isValidCarNames(String[] carNames) {
        int carNamesLength = carNames.length;
        for (String carName : carNames) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("이름은 1자 이상 5자 이하가 되어야 합니다.");
            }
        }

        if (carNamesLength < 2) {
            throw new IllegalArgumentException("참여 자동차가 2개 이상이어야 합니다.");
        }

        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (!carNameSet.add(carName)) {
                throw new IllegalArgumentException("같은 이름이 두개 이상 있습니다.");
            }
        }

        return true;
    }

    boolean isValidAttemptCount(String count) {
        for (int i = 0; i < count.length(); i++) {
            char c = count.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("입력된 값은 숫자여야 합니다");
            }
        }

        int stringToNum = Integer.parseInt(count);
        if (stringToNum <= 0) {
            throw new IllegalArgumentException("입력된 값은 0보다 커야 합니다.");
        }

        return true;
    }

    void runCarsOnce() {
        for (Car car : cars) {
            car.run();
        }
    }

    void printStepResults() {
        for (int i = 0; i < attemptCount; i++) {
            runCarsOnce();
            printCarsResult();
            System.out.print("\n");
        }
    }

    void printCarsResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getStep()));
        }
    }

    void execute() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String[] carNames = (Console.readLine()).split(",");
        if (isValidCarNames(carNames)) {
            setCars(carNames);
        }

        System.out.println("시도할 회수는 몇회인가요?");

        String count = Console.readLine();
        if (isValidAttemptCount(count)) {
            setAttemptCount(count);
        }

        System.out.println("\n실행 결과");
        printStepResults();

    }
}
