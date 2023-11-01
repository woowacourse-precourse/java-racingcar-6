package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 김표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public List<Car> getCarList(String carNames) {
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5자 이하 이름만 가능");
            }

            if (carNameList.contains(carName)) {
                throw new IllegalArgumentException("중복된 이름 존재");
            }

            if (carName.length() == 0) {
                continue;
            }

            Car car = new Car(carName);
            carList.add(car);
            carNameList.add(carName);
        }
        return carList;
    }

    public int inputRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String racingCountInput = Console.readLine();

        try {
            return Integer.parseInt(racingCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력됨");
        }
    }
}
