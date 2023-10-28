package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        List<String> names = Arrays.asList(inputName.split(","));

        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }

        for (Car car : carList) {
            String printCarName = car.printCarName();
            System.out.println(printCarName);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumber = Console.readLine();
        int attemptsNumber = Integer.parseInt(inputNumber);

    }
}
