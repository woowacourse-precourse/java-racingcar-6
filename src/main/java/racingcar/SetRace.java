package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class SetRace {
    public List<String> createCar() {
        List<String> carsList = new ArrayList<>();
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] cars = input.split(",");
        for (String car : cars){
            carsList.add(car);
        }
        return carsList;
    }
}
