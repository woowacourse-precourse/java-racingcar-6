package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) cars.add(new Car(name));

        System.out.println("시도할 횟수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println("실행결과");
        for(int i = 0; i < tryCount ; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getStatus());
            }
            System.out.println();
        }
    }
}
