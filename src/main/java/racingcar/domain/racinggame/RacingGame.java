package racingcar.domain.racinggame;

import racingcar.controller.dto.RoundDto;
import racingcar.controller.dto.WinnersDto;
import racingcar.domain.car.Cars;
import racingcar.domain.move.MovePicker;
import racingcar.domain.round.Round;

public final class RacingGame {

    private final Cars cars;

    private final Round maxRound;
    private final MovePicker movePicker;
    private Round currentRound;

    public RacingGame(
            final Cars cars,
            final Round maxRound,
            final MovePicker movePicker
    ) {
        this.currentRound = Round.first();
        this.cars = cars;
        this.maxRound = maxRound;
        this.movePicker = movePicker;
    }

    public static RacingGame of(
            final Cars cars,
            final Round maxRound,
            final MovePicker movePicker
    ) {
        return new RacingGame(
                cars,
                maxRound,
                movePicker
        );
    }

    public void play() {
        cars.moveAllBy(movePicker);
        currentRound = currentRound.increased();
    }

    public boolean isPlaying() {
        return currentRound.isNotAfter(maxRound);
    }


    public WinnersDto getWinnersDto() {
        return cars.toWinnersDto();
    }

    public RoundDto getRoundDto() {
        return cars.toRoundDto();
    }
}
