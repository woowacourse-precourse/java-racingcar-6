package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarNameDto;

public class RacingCarService {

    public List<CarNameDto> carNameExtraction(String userInput) {
        CarGenerator carGenerator = new CarGenerator(userInput);
        List<String> carNameList = carGenerator.generateCarNameList();
        return carNameList.stream()
                .map(name -> {
                    CarNameDto dto = new CarNameDto();
                    dto.setCarName(name);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
