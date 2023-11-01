package racingcar.Domain;

import static racingcar.common.GameMessage.INPUT_RACINGCAR_NAME_MESSAGE;
import static racingcar.regex.RegularExpression.CAR_NAME_PATTERN;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarList {

    private List<Car> cars;

    private final static String SEPARATOR = ",";

    public void namesInput() {
        System.out.print(INPUT_RACINGCAR_NAME_MESSAGE);
        String input = Console.readLine().trim();

        List<String> carNames = Arrays.asList(input.split(SEPARATOR));
        validate(carNames);

        namingCars(carNames);
    }

    private void namingCars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> carNames) {
        validateFormat(carNames);
        validateDuplicate(carNames);
    }

    private void validateFormat(List<String> carNames) {
        for (String carName : carNames) {
            if (!carName.matches("^[a-zA-Z0-9가-힣]{1,5}$")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> noDuplicateNames = new HashSet<>(carNames);

        if (noDuplicateNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
