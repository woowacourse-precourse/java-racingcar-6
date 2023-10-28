package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNamesList = inputCarNamesByUser();
        int attemptNum = getAttemptNumber();

        List<Car> cars = createCarObject(carNamesList);

    }

    private static List<String> inputCarNamesByUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        String[] inputArray = input.split(",");

        List<String> carNameList = new ArrayList<>();
        for (String carName : inputArray) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    private static int getAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int inputNumber = Integer.parseInt(Console.readLine());
        return inputNumber;
    }

    private static List<Car> createCarObject(List<String> carNamesList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNamesList) {
            cars.add(new Car(carName));
        }
        return cars;
    }


}
