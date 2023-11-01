package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.utils.Validator;

import java.util.List;

public class InputView {

    public void setCarName(List<Car> cars) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> car_name = List.of(Console.readLine().split(","));

        // 자동차 이름 갯수가 1개 이하인지 확인
        Validator.carNameNumber(car_name);
        // 자동차 이름이 중복되었는지 확인
        Validator.carNameDuplicateCheck(car_name);

        car_name.stream().forEach(name -> cars.add(new Car(name)));
    }

    public int setPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String num = Console.readLine();
        Validator.attemptCount(num);
        int attempt_count = Integer.parseInt(num);

        return attempt_count;
    }
}
