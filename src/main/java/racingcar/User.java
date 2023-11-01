package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class User {
    public List<Car> createCar() {
        List<String> carNameList = inputCarName();
        Validator.isValidateCarName(carNameList);
        List<Car> carList = createCarFromCarName(carNameList);
        return carList;
    }

    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = Arrays.stream(Console.readLine().split(","))
                .map(carName -> carName.strip())
                .toList();
        return carNameList;
    }

    public List<Car> createCarFromCarName(List<String> carNameList) {
        List<Car> carList = carNameList.stream()
                .map(carName -> new Car(carName))
                .toList();
        return carList;
    }

    public int setRoundTime() {
        String stringRoundTime = inputRoundTime();
        Validator.isValidateRoundTimeNumber(stringRoundTime);
        int roundTime = Integer.valueOf(stringRoundTime);
        return roundTime;
    }

    public String inputRoundTime() {
        System.out.println("시도할 회수를 몇회인가요?");
        String stringRoundTime = Console.readLine().strip();
        return stringRoundTime;
    }
}
