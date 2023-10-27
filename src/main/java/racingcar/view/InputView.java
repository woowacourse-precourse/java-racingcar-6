package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class InputView {
    Car car = new Car();

    public List<String> askName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        List<String> carNames = splitName(inputName);
        for (String carName : carNames) {
            car.setCar(carName);
        }
        return carNames;
    }

    public List<String> splitName(String inputName) {
        return Arrays.asList(inputName.split(","));
    }
}
