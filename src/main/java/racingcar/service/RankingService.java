package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.CarList.CarDto;

public class RankingService {

    public List<String> checkWinner(List<CarDto> carDtoList) {
        List<String> winner = new ArrayList<>();
        List<Integer> positionList = carDtoList.stream()
            .map(CarDto::position)
            .toList();
        int maxPosition = Collections.max(positionList);
        for (CarDto carDto : carDtoList) {
            if (carDto.position() == maxPosition) {
                winner.add(carDto.carName());
            }
        }
        return winner;
    }
}
