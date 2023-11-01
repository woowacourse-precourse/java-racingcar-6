package racingcar.Domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarList {

    private List<Car> cars;

    public void namesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();

        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);

        namingCars(carNames);
    }

    private void namingCars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        validateCarNameFormat(carNames);
        validateNameDuplicate(carNames);
    }

    private void validateCarNameFormat(List<String> carNames) {
        for (String carName : carNames) {
            if (!carName.matches("^[a-zA-Z0-9가-힣]{1,5}$")) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNameDuplicate(List<String> carNames) {
        Set<String> noDuplicateNames = new HashSet<>(carNames);

        if (noDuplicateNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> getCars() {
        return this.cars;
    }
}
