package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarNameDto;

public class RacingCarService {

    public List<CarNameDto> carNameExtraction(String userInputCarNames) {
        CarGenerator carGenerator = new CarGenerator(userInputCarNames);
        List<String> carNameList = carGenerator.generateCarNameList();
        return carNameList.stream()
                .map(name -> {
                    CarNameDto dto = new CarNameDto();
                    dto.setCarName(name);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void moveCar(List<CarNameDto> carNameDtoList, String userInputTryNumber) {
        List<String> carNameList = carNameDtoList.stream()
                .map(CarNameDto::getCarName)
                .toList();

        MoveCar moveCar = new MoveCar(carNameList, userInputTryNumber);
    }
}
