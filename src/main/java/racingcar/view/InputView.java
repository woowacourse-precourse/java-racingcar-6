package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final static String GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public List<String> getCarName() {
        System.out.println(GET_CAR_NAME);
        String carNames = Console.readLine();
        List<String> carNameList = stringToList(carNames);

        return carNameList;
    }

    public List<String> stringToList(String str) {
        String[] strList = str.split(",");
        return List.of(strList);
    }
}
