package racingcar.view;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.Car;

public class InputView {

    static private final Scanner scanner = new Scanner(System.in);

    public static void inputCars(List<Car> carList) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String str = scanner.nextLine();
        String[] split = str.split(",");
        for (String name : split) {
            carList.add(new Car(name));
        }
    }

    public static int inputTimes() {

        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
