package racingcar.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.validator.Validator;

public class Cars {

    private final Map<String, Integer> maps;

    public Cars(String carsInput) {
        List<String> carsList = convertToList(carsInput);
        Validator.validateSize(carsList);
        Validator.validateName(carsList);
        Validator.validateDuplicate(carsList);
        this.maps = generateCarsMap(carsList);
    }


    private List<String> convertToList(String carsInput) {
        return Arrays.stream(carsInput.split(",")).collect(Collectors.toList());
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
