package racingcar.domain;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private final Map<String, Integer> maps;

    public Cars(String carsInput) {
        List<String> carsList = convertToList(carsInput);
        validateSize(carsList);
        validateName(carsList);
        validateDuplicate(carsList);
        this.maps = generateCarsMap(carsList);
    }

    private void validateDuplicate(List<String> carsList) {
        if (carsList.stream().distinct().count() != carsList.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 중복이 되면 안됩니다.");
        }
    }

    private List<String> convertToList(String carsInput) {
        return Arrays.stream(carsInput.split(",")).collect(Collectors.toList());
    }

    private void validateName(List<String> carsList) {
        if (carsList.stream().anyMatch(car -> car.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5글자 이하여야합니다.");
        }
    }

    private void validateSize(List<String> carsList) {
        if (carsList.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 자동차의 대수는 2대 이상이여야 합니다.");
        }
    }

    private Map<String, Integer> generateCarsMap(List<String> carsList) {
        Map<String, Integer> carsMap = new LinkedHashMap<>();
        carsList.stream().forEach(car -> carsMap.put(car, 0));
        return carsMap;
    }

    public Map<String, Integer> getMaps() {
        return maps;
    }
}
