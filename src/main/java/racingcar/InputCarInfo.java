package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputCarInfo {

    public static List<Car> inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        while (true) {
            try {
                String[] carNames = Console.readLine().split(",");
                isValidName(carNames);

                return createCars(carNames);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static void isValidName(String [] carNames){
        for (String carName : carNames) {
            validateBlank(carName);
            validateLength(carName);
        }
        validateDuplication(carNames);
    }

    private static void validateBlank(String carName) {
        if ((carName == null) || (carName.trim().length() == 0)) {
            throw new IllegalArgumentException("공백은 이름이 될 수 없습니다.");
        }
    }

    private static void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름 길이 제한을 넘었습니다.");
        }
    }

    private static void validateDuplication(String[] carNames) {
        long count = Arrays.stream(carNames)
                .distinct()
                .count();
        if (carNames.length != count) {
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }
}
