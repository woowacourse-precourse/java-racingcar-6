package racingcar.v4;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;


public class CreateCar {
    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return inputCarNames;
    }

    public void validateCarNameNotEmpty(String inputCarNames) {
        if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
    }

    public List<String> splitCarNames(String inputCarNames) {
        if (!inputCarNames.contains(",")) {
            throw new IllegalArgumentException("자동차 이름을 쉼표로 구분해주세요.");
        }
        return new ArrayList<>(Arrays.asList(inputCarNames.split(",")));
    }

    public List<String> trimCarNames(List<String> carNames) {
        List<String> trimmedCarNames = new ArrayList<>();
        for (String carName : carNames) {
            trimmedCarNames.add(carName.trim());
        }
        return trimmedCarNames;
    }

    public void validateCarNameLength(List<String> carNames){
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

    public List<String> validateCarNames(String inputCarNames) {
        validateCarNameNotEmpty(inputCarNames);
        List<String> splitCarNames = splitCarNames(inputCarNames);
        List<String> validatedCarNames = trimCarNames(splitCarNames);
        validateCarNameLength(validatedCarNames);
        validateCarNameDuplicate(validatedCarNames);
        validateCarCount(validatedCarNames);
        return validatedCarNames;
    }
    public Map<String, Integer> racingStateMap(List<String> validatedCarNames) {
        Map<String, Integer> racingStateMap = new HashMap<>();
        for (String carName : validatedCarNames) {

            racingStateMap.put(carName, 0);
        }
        return racingStateMap;
    }

}
