package racingcar.dto.output;

import racingcar.model.RacingCar;

public record ResultOfTurnDto(String racingCarName, String advanceMarking) {
    public static ResultOfTurnDto createAdvancecProgress(RacingCar racingCar) {
        String carName = racingCar.getRacingCarName();
        String advanceMarking = racingCar.getAdvanceMarking();
        return new ResultOfTurnDto(carName, advanceMarking);
    }
}
