package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputName = Console.readLine();
        List<String> names = Arrays.asList(inputName.split(","));

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        int attemptsNumber = Integer.parseInt(inputNumber);

        for (int i = 0; i < attemptsNumber; i++) {
            racing(carList);
            System.out.println();
        }
    }

    private static void racing(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
            System.out.println(car.printCarName());
        }
    }
}
