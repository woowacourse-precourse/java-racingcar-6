package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarList.CarDto;

public class rankingService {

    public List<String> checkWinner(List<CarDto> carDtoList) {
        List<String> winner = new ArrayList<>();
        int position = 0;
        for (CarDto carDto : carDtoList) {
            if (carDto.getPosition() > position) {
                position = carDto.getPosition();
            }
        }

    }

}
