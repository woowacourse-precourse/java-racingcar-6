package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Set<String> carNames = getCarNames();

        System.out.println(carNames);

    }

    static Set<String> getCarNames() {
        Set<String> carNames = new HashSet<>();

        String inputNames = readLine();

        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] splitNames = inputNames.split(",");

        for (String carName : splitNames) {
            if ( 1 > carName.length() || carName.length() > 5) {
                throw new IllegalArgumentException("이름 길이는 1 ~ 5자 이내 입니다.");
            }

            if (carNames.contains(carName)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }

            carNames.add(carName);
        }

        if (carNames.size() == 0 || carNames.size() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return carNames;
    }
}
