package racingcar;

import racingcar.race.Car;
import racingcar.race.Race;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;


public class Application {

    private static List<Car> createCars() {
        String[] names = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static int getRounds(){
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수값만 입력해주세요.");
        }
    }

    private static void displayWinners(Race race) {
        List<Car> winners = race.getWinners();
        System.out.print("\n최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> cars = createCars();
        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = getRounds();

        Race race = new Race(cars, rounds);
        race.run();

        displayWinners(race);
    }
}