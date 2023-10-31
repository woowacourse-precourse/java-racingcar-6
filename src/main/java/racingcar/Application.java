package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static List<Car> cars;

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        splitInputToCarNames(input);

        validateCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int trial = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < trial; i++) {
            for (int j = 0; j < cars.size(); j++) {
                pickRandomNumberAndPrintResult(cars.get(j));
            }
            System.out.println();
        }

        List<Car> winners = new ArrayList<>();
        findWinners(winners);

        printWinners(winners);
    }

    private static void splitInputToCarNames(String input) {
        Arrays.stream(input.split(","))
                .iterator()
                .forEachRemaining(car -> {
                    car = car.trim();
                    cars.add(new Car(car));
                });
    }

    private static void validateCarName() {
        for (int i = 0; i < cars.size(); i++) {
            int lengthOfCarName = cars.get(i).getLengthOfName();
            if (lengthOfCarName > 5 || lengthOfCarName == 0)
                throw new IllegalArgumentException();
        }
    }

    private static void pickRandomNumberAndPrintResult(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4)
            car.forward();
        System.out.printf("%s : %s\n", car.getName(), car.getPosition());
    }

    private static void findWinners(List<Car> winners) {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getPositionByLength() > maxDistance) {
                winners = new ArrayList<>();
                winners.add(car);
            } else if (car.getPositionByLength() == maxDistance) {
                winners.add(car);
            }
        }
    }

    private static void printWinners(List<Car> winners) {
        StringBuilder result = new StringBuilder();
        winners.stream()
                .iterator()
                .forEachRemaining(car -> result.append(car.getName()).append(", "));
        result.delete(result.length() - 2, result.length());
        System.out.printf("최종 우승자 : %s", result);
    }
}
