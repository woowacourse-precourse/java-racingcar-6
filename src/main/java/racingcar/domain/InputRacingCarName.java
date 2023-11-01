package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputRacingCarName {
    public void inputRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarNames = Console.readLine();
        RacingValue.racingCarName = Arrays.asList(CarNames.split(","));
    }
}