package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarStateDto;

public class Referee {
    public List<String> getWinner(List<CarStateDto> carStateDtoList) {
        List<String> winnerName = new ArrayList<>();
        int maxPath = 0;

        for (CarStateDto carState : carStateDtoList) {
            if (carState.getPath() > maxPath) {
                maxPath = carState.getPath();
                winnerName.clear();
                winnerName.add(carState.getName());
            } else if (carState.getPath() == maxPath) {
                winnerName.add(carState.getName());
            }
        }

        return winnerName;
    }
}
