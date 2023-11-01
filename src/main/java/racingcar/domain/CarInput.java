package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class CarInput {
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        // 입력 받은 문자열을 쉽표로 나누어 리스트로 반환
        List<String> carNames = Arrays.asList(input.split(","));
        
        return carNames;
    }
}
