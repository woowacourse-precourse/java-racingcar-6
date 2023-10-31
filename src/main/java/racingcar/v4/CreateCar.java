package racingcar.v4;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

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
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름을 쉼표로 구분해주세요.");
        }
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }


    public List<String> trimCarNames(List<String> carNames) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            trimmedCarNames.add(carName.trim());
        }
        return trimmedCarNames;
    }

    public void validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void validateCarNameDuplicate(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public void validateCarCount(List<String> carNames) {
        if (carNames.size() > 10 || carNames.size() < 2) {
            throw new IllegalArgumentException("자동차의 수는 2대 이상 10대 이하만 가능합니다.");
        }
    }

    public Map<String, Integer> racingStateMap(List<String> carNames) {
        Map<String, Integer> stateMap = new HashMap<>();
        for (String carName : carNames) {
            stateMap.put(carName, 0);
        }
        return stateMap;
    }

    @Test
    void 상태_맵이_정상적으로_생성된다() {
        CreateCar createCar = new CreateCar();
        List<String> carNames = Arrays.asList("페라리", "벤츠", "레드불");
        Map<String, Integer> stateMap = createCar.racingStateMap(carNames);
        assertThat(stateMap)
                .isNotNull()
                .hasSize(3)
                .containsKeys("페라리", "벤츠", "레드불")
                .containsValues(0);
    }


}
