package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputCarName {
    public List<String> getCarNames() {
        String inputCarNames = Console.readLine().trim();
        String[] carNameArray = inputCarNames.split(",");
        InputCarValidator inputCarValidator = new InputCarValidator();

        for (String carName : carNameArray) {
            if (inputCarValidator.invalidateCarName(carName)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하의 알파벳 소문자만 가능합니다.");
            }
        }

        if (inputCarValidator.duplicateCarNames(carNameArray)) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }

        return Arrays.asList(carNameArray);
    }

    public List<Car> createCarsFromCarNames(List<String> carNames) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        return carNames.stream()
                .map(carName -> new Car(carName, randomNumberGenerator, 0))
                .collect(Collectors.toList());
    }
}
