package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String[] carNames = namingCars();
        int tryCount = racingTimes();

        userInput(carNames, tryCount);

        Car[] cars = racingCarCandidates(carNames);
        racingStart(tryCount, cars);
        printWinners(cars);
    }

    private static void userInput(String[] carNames, int tryCount) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException("최소 두 대의 자동차를 입력해주세요");
        }
        if (tryCount < 1) {
            throw new IllegalArgumentException("한 번 이상의 이동 횟수를 입력해주세요!");
        }
    }

    private static String[] namingCars() {
        System.out.print("경주할 자동차 이름 입력(쉼표 기준): ");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static int racingTimes() {
        System.out.print("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        validateRacingTimes(tryCount);
        return tryCount;
    }

    private static void validateRacingTimes(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("한 번 이상의 이동 횟수를 입력해주세요!");
        }
    }

    private static Car[] racingCarCandidates(String[] carNames) {
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    private static void racingStart(int tryCount, Car[] cars) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.moveOrStop(Randoms.pickNumberInRange(0, 9));
                System.out.println(car.getName() + ":" + getPositionString(car.getPosition()));
            }
            System.out.println();
        }
    }

    private static void printWinners(Car[] cars) {
        int maxPosition = getMaxPosition(cars);
        String winners = printWinners(cars, maxPosition);
        System.out.println("최종 우승자:" + winners);
    }

    private static int getMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static String printWinners(Car[] cars, int maxPosition) {
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName()).append(" : ").append(getPositionString(car.getPosition()));
            }
        }
        return winners.toString();
    }

    private static String getPositionString(int position) {
        return "-".repeat(Math.max(0, position));
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
