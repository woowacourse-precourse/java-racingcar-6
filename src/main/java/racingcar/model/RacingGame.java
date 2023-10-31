package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Round;
import racingcar.dto.CarDTO;
import racingcar.dto.RoundDTO;

public class RacingGame {
    private final CarManager manager = new CarManager();
    private final List<Round> rounds = new ArrayList<>();
    private int ROUND_MAX;

    public RacingGame(String[] cars, int round) {
        manager.createAndAddCars(cars);
        this.ROUND_MAX = round;
    }


    public List<RoundDTO> getRoundDTO() {
        List<RoundDTO> roundDTO = new ArrayList<>();

        for (Round round : rounds) {
            roundDTO.add(round.toDTO());
        }
        return roundDTO;
    }

    public void proceedGame() {
        for (int round = 1; round <= ROUND_MAX; round++) {
            playRound(round);
        }
    }


    // 라운드 진행 - car에게 각자 순서대로 이동 지시, 라운드 정보 저장
    private void playRound(int round) {
        manager.tryToMoveCar();
        saveRoundStatus(round);
    }

    // 라운드 정보를 저장
    private void saveRoundStatus(int round) {
        List<CarDTO> result = manager.getRoundResult();
        rounds.add(new Round(round, result));
    }

}
