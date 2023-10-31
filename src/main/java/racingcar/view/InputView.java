package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    public Set<String> getCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        String rawString = Console.readLine();

        return parseString(rawString);
    }

    private static Set<String> parseString(String rawString) {
        String[] carNameArray = rawString.split(",");
        Set<String> carNames = new HashSet<>();

        for (String carName : carNameArray) {
            carName = carName.trim();

            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 입력 가능합니다.");
            }

            if (!carNames.add(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }
        }

        return carNames;
    }
}
