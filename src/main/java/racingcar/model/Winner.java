package racingcar.model;


import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class Winner {
    private List<String> winners = new ArrayList<>();


    public List<String> getWinners(List<RoundDTO> rounds) {
        List<CarDTO> finalRoundState = parseFinalRound(rounds);
        findWinners(finalRoundState);

        return winners;
    }


    // 마지막 RoundDTO를 찾아 CarDTO 배열로 반환
    private List<CarDTO> parseFinalRound(List<RoundDTO> rounds) {
        int finalRoundIndex = rounds.size() - 1;
        RoundDTO finalRound = rounds.get(finalRoundIndex);
        List<CarDTO> finalRoundState = finalRound.getStates();

        return finalRoundState;
    }

    // 이동 거리가 가장 먼 자동차를 모두 찾아 winners 배열로 반환
    private void findWinners(List<CarDTO> states) {
        int farthest = findFarthestPosition(states);

        for (CarDTO car : states) {
            if (car.getPosition() == farthest) {
                String name = car.getName();

                winners.add(name);
            }
        }
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
