package racingcar.dto;

import java.util.List;
import racingcar.domain.RacingCar;

public class RacingGameRs {

    private List<RacingCarDto> racingCarDtoList;
    private long leftNumberOfAttempts;

    private RacingGameRs(List<RacingCarDto> racingCarDtoList, long leftNumberOfAttempts) {
        this.racingCarDtoList = racingCarDtoList;
        this.leftNumberOfAttempts = leftNumberOfAttempts;
    }

    public static RacingGameRs valueOf(List<RacingCarDto> racingCarDtoList, long leftNumberOfAttempts) {
        return new RacingGameRs(racingCarDtoList, leftNumberOfAttempts);
    }

    public static RacingGameRs toRacingGameRs(List<RacingCar> racingCars, long leftNumberOfAttempts) {
        List<RacingCarDto> racingCarDtos = racingCars.stream().map(RacingCarDto::valueOf).toList();
        return RacingGameRs.valueOf(racingCarDtos, leftNumberOfAttempts);
    }

    public List<RacingCarDto> getRacingCarDtoList() {
        return racingCarDtoList;
    }

    public long getLeftNumberOfAttempts() {
        return leftNumberOfAttempts;
    }
}
