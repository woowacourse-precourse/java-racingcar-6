package racingcar.view;

import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Validator;
import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static List<Car> setName() {
        List<Car> cars = new ArrayList<>();
        out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        if (Validator.validate(names)) {
            for (String name : names) {
                cars.add(new Car(name));
            }
        }
        return cars;
    }

    public static int setNumOfTime() {
        out.println("시도할 회수는 몇회인가요?");
        try {
            IllegalArgumentException e = new IllegalArgumentException();
            int number = Integer.parseInt(Console.readLine());
            if (number < 1) {
                throw e;
            }
            return number;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
