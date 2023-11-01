package racingcar;

import camp.nextstep.edu.missionutils.*;
import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static java.util.prefs.Preferences.MAX_NAME_LENGTH;

public class InputView {

    public List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분): ");
        String[] carNames = Console.readLine().split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    public int inputTryCount() {
        System.out.println("시도할 회수를 입력하세요: ");
        return Integer.parseInt(Console.readLine());
    }
}
