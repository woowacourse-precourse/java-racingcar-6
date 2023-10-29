package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carArray = input.split(",");

        List<String> cars = new ArrayList<>();

        for (String car : carArray) {
            cars.add(car.trim());   // 앞 뒤 공백 제거
        }

        return cars;
    }
}
