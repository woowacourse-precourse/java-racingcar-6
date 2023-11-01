package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingWinners;
import racingcar.dto.output.WinnerDTO;

/**
 * 레이싱 게임의 결과를 관리하는 클래스
 */
public class Result {
    private final RacingWinners racingWinners;

    // private 생성자
    private Result(RacingWinners racingWinners) {
        this.racingWinners = racingWinners;
    }

     //Result 객체를 생성하여 반환
    public static Result of(RacingWinners racingWinners) {
        return new Result(racingWinners);
    }

    // 레이싱 게임의 최종 우승자를 발표
    public WinnerDTO announce() {
        List<String> winnerNames = racingWinners.getWinnerNames();
        return createWinnerDTO(winnerNames);
    }

    // WinnerDTO 객체를 생성하는 메서드
    private WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return WinnerDTO.of(winnerNames);
    }
}
