package racingcar.domain.racinggame;

import racingcar.domain.dto.RoundsDto;
import racingcar.domain.dto.WinnersDto;
import racingcar.domain.dto.car.Cars;
import racingcar.domain.dto.round.Round;
import racingcar.domain.move.MovePicker;

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
        return currentRound.isSameAs(maxRound);
    }

//    private void _play(final Round currentRound) {
//        if (currentRound.isSameAs(maxRound)) {
//            return;
//        }
//        cars.moveAllBy(movePicker);
//        _play(currentRound.increased());
//    }

    public WinnersDto getWinners() {
        // TODO
        return null;
    }

    public RoundsDto getRoundResult() {
        // TODO
        return null;
    }
}
