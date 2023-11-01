package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Util.ErrorCollection;
import racingcar.Util.Validation;

public class Input {
    public static List<Car> getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Validation.validationEmpty(Console.readLine());

        input = input.replace(" ", "");
        String[] names = input.split(",");

        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            String verifiedName = Validation.validationCarName(name);

            Car car = new Car(verifiedName);
            cars.add(car);

            Validation.validationDuplication(cars);
        }

        return cars;
    }

    public static int getAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Validation.validationEmpty(Console.readLine());

        return Validation.validationAttempts(input);
    }
}
