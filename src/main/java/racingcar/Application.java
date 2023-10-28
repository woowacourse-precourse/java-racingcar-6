package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        if (!isValidInput(input, String.valueOf(tryCount))) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }

        List<Car> cars = createCars(carNames);
        runRace(tryCount, cars);
        List<String> winners = getWinnners(cars);
        printWinners(winners);

    }

    private static boolean isValidInput(String carnames, String tryCount) {
        if (carnames == null || tryCount == null) {
            return false;
        }

        String[] carNameArray = carnames.split(",");
        for (String carname : carNameArray) {
            if (carname.isEmpty() || carname.length() > 5) {
                return false;
            }
        }

        try {
            int tryCountValue = Integer.parseInt(tryCount);
            if (tryCountValue <= 0) {
                return false;
            }
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private static void runRace(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            printCurrentStatus(cars);
        }
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars ){
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private static void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            car.printStatus();
        }
    }

    private static List<String> getWinnners (List<Car> cars) {
        int maxPoSition = getMaxPosition(cars);
        return findWinnners(cars, maxPoSition);
    }

    private static int getMaxPosition (List<Car> cars) {
        return  cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }

    private static List<String> findWinnners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
class Car{
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

    public void move(int randomValue) {
        if (randomValue >= 4) {
            position++;
        }
    }

    public void printStatus() {
        System.out.println(name + " : " + "-".repeat(position));
    }

}
