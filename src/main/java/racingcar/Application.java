package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Application app = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        Car[] cars = app.getCarInformationInput();

        System.out.println("시도할 회수는 몇회인가요?");
        int count = app.getCountInput();

        System.out.println("실행 결과");
        app.startRacing(count, cars);

        List<Car> winners = app.getWinners(cars);
        app.printWinners(winners);
    }

    private Car[] getCarInformationInput() {
        String input = Console.readLine();
        String[] names = input.split(",");

        final int numOfCars = names.length;
        Car[] cars = new Car[numOfCars];

        for (int i = 0; i < numOfCars; i++) {
            if (names[i].length() >= 5)
                throw new IllegalArgumentException();
            cars[i] = new Car(names[i], 0);
        }

        return cars;
    }

    private int getCountInput() {
        String input = Console.readLine();
        if (input.length() > 1 || !Character.isDigit(input.charAt(0)))
            throw new IllegalArgumentException();
        return Integer.parseInt(input);
    }

    private void startRacing(int count, Car[] cars) {
        while (count-- > 0) {
            for (Car car : cars) {
                int distance = Randoms.pickNumberInRange(0, 9);
                car.move(distance);
            }
            System.out.println();
        }
    }

    private List<Car> getWinners(Car[] cars) {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getLocation() > maxDistance)
                maxDistance = car.getLocation();
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getLocation()) winners.add(car);
        }
        return winners;
    }

    private void printWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) sb.append(winners.get(i).getName());
            else sb.append(winners.get(i).getName()).append(",");
        }
        System.out.println(sb);
    }
}
