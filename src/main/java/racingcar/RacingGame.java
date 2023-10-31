package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars = new ArrayList<>();
    private int tryNum;

    public void inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String[] carsName = Console.readLine().split(",");
        for (String s : carsName) {
            cars.add(new Car(s));
        }
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        tryNum = Integer.parseInt(Console.readLine());
        System.out.println(tryNum);
    }

    public void printCarsName() {
        for (Car c : cars) {
            System.out.println(c.getName());
        }
    }


}
