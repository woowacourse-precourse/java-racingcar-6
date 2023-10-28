package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String nameInput = Console.readLine();
        String[] carNames = nameInput.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        Car[] cars = new Car[carNames.length];
        for (int index = 0; index < carNames.length; index++) {
            cars[index] = new Car(carNames[index]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int terms = Integer.parseInt(Console.readLine());
        System.out.println("terms = " + terms);

        int count = 0;
        while (terms != count) {
            for (Car carObj : cars) {
//                System.out.println(carObj);
                carObj.run();
                System.out.println(carObj.getName() + " : " + carObj.getLocation());
            }
            System.out.println();
            count++;
        }

        result(cars, terms);
    }

    private void result(Car[] cars, int terms) {
        System.out.println("실행 결과");
        List<String > winners = new ArrayList<>();
        for (Car carObj : cars) {
            if (carObj.getLocation().length() == terms) {
                winners.add(carObj.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        for (String winner : winners) {
            System.out.print(winner);
        }

    }
}
