package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class InputView {

    private static final String COMMA = ",";

    public List<Car> receiveCarList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(COMMA);
        boolean isValidateName = Arrays.stream(carNames)
                .anyMatch(name -> name.length() > 5);

        if (isValidateName) {
            throw new IllegalArgumentException();
        }
        ArrayList<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int receiveTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
