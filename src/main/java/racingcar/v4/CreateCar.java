package racingcar.v4;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCar {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return inputCarNames;
    }

    public void validateCarNameNotEmpty(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }
    public List<String> splitCarNames(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    public List<String> trimCarNames(List<String> carNames) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            trimmedCarNames.add(carName.trim());
        }
        return trimmedCarNames;
    }





}
