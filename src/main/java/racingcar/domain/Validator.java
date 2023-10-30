package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Validator {

    private final int MIN_CAR_LEN = 1;
    private final int MAX_CAR_LEN = 5;
    private final int MIN_CAR_NUMBER = 2;
    private final String SEPARATOR = ",";
    private final String SPACE = " ";

    public Validator() {
    }

    public void validateCarNamesInput(String userInput) throws IllegalArgumentException {
        List<String> carNames = separateAndRemoveSpace(userInput);
        Validator validator = new Validator();
        if (validator.existsDuplicateName(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
        if (validator.ensureLengthInRange(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상, 5자 이하여야 합니다.");
        }
        if (validator.ensureNumberOfCars(carNames)) {
            throw new IllegalArgumentException("[ERROR] 자동차 개수는 2개 이상여야 합니다.");
        }
    }

    public boolean existsDuplicateName(List<String> carNames) {
        Set<String> deduplication = new HashSet<>(carNames);
        if (carNames.size() == deduplication.size()) {
            return false;
        }
        return true;
    }

    public boolean ensureLengthInRange(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() < MIN_CAR_LEN || carName.length() > MAX_CAR_LEN) {
                return false;
            }
        }
        return true;
    }

    public boolean ensureNumberOfCars(List<String> carNames) {
        if (carNames.size() < MIN_CAR_NUMBER) {
            return false;
        }
        return true;
    }

    public List<String> separateAndRemoveSpace(String carNames) {
        List<String> carNamesSeperated = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(carNames, SEPARATOR);
        while (stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();
            carNamesSeperated.add(removeSpace(carName));
        }

        return carNamesSeperated;
    }

    public String removeSpace(String carName) {
        return carName.replaceAll(SPACE, "");
    }

}
