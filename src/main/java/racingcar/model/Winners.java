package racingcar.model;


import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class Winners {
    public List<String> getWinners(RoundDTO finalRound) {
        List<CarDTO> states = finalRound.getStates();
        List<String> winners = findWinners(states);

        return winners;
    }


    // 이동 거리가 가장 먼 자동차를 모두 찾아 winners 배열로 반환
    private List<String> findWinners(List<CarDTO> states) {
        List<String> winners = new ArrayList<>();
        int farthest = findFarthestPosition(states);

        for (CarDTO car : states) {
            if (car.getPosition() == farthest) {
                String name = car.getName();
                winners.add(name);
            }
        }
        return winners;
    }

    // 가장 멀리 이동한 거리 찾기
    private int findFarthestPosition(List<CarDTO> states) {
        int farthest = 0;
        for (CarDTO car : states) {
            int position = car.getPosition();
            if (position > farthest) {
                farthest = position;
            }
        }
        return farthest;
    }

}
