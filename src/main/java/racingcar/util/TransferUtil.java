package racingcar.util;

import racingcar.model.Car;
import racingcar.model.dto.CarStatusDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransferUtil {

    public List<String> transferStringToListString(String targetString) {
        if (targetString.isEmpty()){
            return new ArrayList<>(Collections.emptyList());
        }
        String[] targetStringList = targetString.split(",");
        return new ArrayList<>(Arrays.asList(targetStringList));
    }

    public String transferCarStatusDtoToNameAndPosition(CarStatusDto carStatusDto) {
        String result = carStatusDto.getName() + " : ";
        for(int i = 0; i < carStatusDto.getTryCount(); i++) {
            result += "-";
        }
        return result;
    }

    public String transferCarStatusDtoToNameJoining(List<CarStatusDto> carStatusDtos) {
        return carStatusDtos.stream().map(CarStatusDto::getName).collect(Collectors.joining(", "));
    }
}
