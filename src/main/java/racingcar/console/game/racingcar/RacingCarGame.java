package racingcar.console.game.racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.console.game.Game;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements Game {

    @Override
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int turn = Integer.parseInt(Console.readLine());
        List<String> nameList = List.of(names.split(","));

        List<Car> carList = new ArrayList<>();

        for (String name : nameList) {
            if (name.length() > 5)
                throw new IllegalArgumentException();
            carList.add(new Car(name));
        }

        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            for (Car car : carList) {
                car.moveLocation();
            }

            for (Car car : carList) {
                car.indicateLocation();
            }

            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }

        System.out.print("최종 우승자 : ");
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocation() == max) {
                winners.add(car);
            }
        }

        String[] winnerNames = winners.stream()
                .map(Car::getName) // 또는 .map(car -> car.toString())
                .toArray(String[]::new);
        String result = String.join(", ", winnerNames);
        System.out.println(result);

    }

    public class Car {
        private String name;

        public String getName() {
            return name;
        }

        private int location;

        public Car(String name) {
            this.name = name;
            this.location = location;
        }

        public void moveLocation() {
            if (Randoms.pickNumberInRange(0,9) > 3) {
                location += 1;
            }
        }

        public void indicateLocation() {
            System.out.print(name + " : ");
            System.out.println("-".repeat(location));
        }

        public int getLocation() {
            return location;
        }
    }
}
