package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputCarName {
    public List<String> getCarNames(){
        String inputCarNames = Console.readLine().trim();
        String[] carNameArray = inputCarNames.split(",");
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : carNameArray) {
            if (carName.length() > 5 || !carName.matches("^[a-z]+$")) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하의 알파벳 소문자만 가능합니다.");
            }
        }

        for (String carName : carNameArray) {
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
            }
            uniqueCarNames.add(carName);
        }

        return Arrays.asList(carNameArray);
    }
}
