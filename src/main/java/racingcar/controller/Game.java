package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.type.TrialCount;
import racingcar.domain.RacingCars;
import racingcar.dto.output.AllRoundDTO;

/**
 * 레이싱 게임의 로직을 담당하는 클래스
 */
public class Game {
    private final RacingCars racingCars;

    // private 생성자
    private Game(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    // Game 객체를 생성하여 반환
    public static Game of(RacingCars racingCars) {
        return new Game(racingCars);
    }

    // 레이싱 게임을 실행하고 그 결과를 반환
    public List<AllRoundDTO> play(TrialCount trialCount) {
        List<AllRoundDTO> allRoundResults = new ArrayList<>();
        int count = trialCount.getCount();

        for (int i = 0; i < count; i++) {
            moveCars();
            allRoundResults.add(fetchRoundResult());
        }

        return allRoundResults;
    }

    // 차량들을 이동시키는 메서드
    private void moveCars() {
        racingCars.move();
    }

    // 현재 라운드의 결과를 가져오는 메서드
    private AllRoundDTO fetchRoundResult() {
        return AllRoundDTO.of(racingCars.cars());
    }
}
