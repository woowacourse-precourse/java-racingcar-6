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
//        List<Integer> winnerNumber = new ArrayList<>(); getMaxPosition -> stream으로 변경
//        int maxPosition = getMaxPosition(carDtoList, winnerNumber);
        for (CarDto carDto : carDtoList) {
            if (carDto.position() == maxPosition) {
                winner.add(carDto.carName());
            }
        }
        return winner;
    }
//    private static int getMaxPosition(List<CarDto> carDtoList, List<Integer> winnerNumber) {
//        for (CarDto carDto : carDtoList) {
//            winnerNumber.add(carDto.getPosition());
//        }
//        return Collections.max(winnerNumber);
//    }
}
