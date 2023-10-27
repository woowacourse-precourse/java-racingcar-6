package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public List<String> getCarNames(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String[] cars = Console.readLine().split(",");
        return Arrays.stream(cars).toList();
    }


}
