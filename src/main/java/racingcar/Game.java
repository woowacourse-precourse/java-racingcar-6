package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    List<String> carList ;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = Arrays.asList(readLine().split(","));
        carNameCheck(carNameList);
    }

    public void carNameCheck(List<String> carNameList) {
        carList = new ArrayList<>();
        for (String carName : carNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(carName);
        }
    }

}
