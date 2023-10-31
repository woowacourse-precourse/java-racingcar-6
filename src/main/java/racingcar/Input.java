package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private static final InputValidation iv = new InputValidation();
    private static final Util util = new Util();

    private String getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public List<Car> getCars() {

        List<Car> cars = new ArrayList<>();

        String carsName = getCarsName();
        String[] names = util.splitString(carsName);

        for (String name : names) {
            iv.checkNameLength(name);
            cars.add(new Car(name));
        }

        return cars;
    }

    public int getTimesToMove() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        return iv.validNum(input);
    }
}
