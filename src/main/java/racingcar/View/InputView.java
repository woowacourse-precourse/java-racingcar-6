package racingcar.View;

import racingcar.Car.Car;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class InputView {
    public static List<Car> promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<Car> carsList = new ArrayList<>();
        for (String name : input.split(",")) {
            carsList.add(new Car(name.trim()));
        }

        return carsList;
    }
}
