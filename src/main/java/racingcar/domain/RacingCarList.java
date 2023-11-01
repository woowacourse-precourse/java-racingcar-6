package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.global.utils.console.ConsoleUtil;
import racingcar.global.utils.constant.OutputType;
import racingcar.global.utils.generator.RandomNumberGenerator;

public record RacingCarList(List<RacingCar> racingCars) {

	private static final int MAX_LENGTH_OF_CAR_NAME = 5;
	private static final int MIN_LENGTH_OF_CAR_NAME = 0;
	private static final int MIN_COUNT_OF_ADVANCE = 0;
	private static final int MOVING_FORWARD = 4;

	public RacingCarList {
		validateCarName(racingCars);
	}

	public int getMaxAdvanceCount() {
		return racingCars.stream()
				.mapToInt(RacingCar::getAdvanceCount)
				.max()
				.orElse(MIN_COUNT_OF_ADVANCE);
	}

	public void outputResult() {
		racingCars.forEach(racingCar -> ConsoleUtil.commonOutputLine(racingCar.toString()));
		ConsoleUtil.commonOutputLine(OutputType.EMPTY.getComment());
	}

	public void moveOrStop() {
		racingCars.forEach(racingCar -> {
			int randomNumber = RandomNumberGenerator.generateRandomNumber();
			updateIncreaseCount(racingCar, randomNumber);
		});
	}

	@Override
	public List<RacingCar> racingCars() {
		return Collections.unmodifiableList(racingCars);
	}

	private void updateIncreaseCount(RacingCar racingCar, int randomNumber) {
		if (randomNumber >= MOVING_FORWARD) {
			racingCar.increaseCount();
		}
	}

	private void validateCarName(List<RacingCar> racingCars) {
		racingCars.stream()
				.map(RacingCar::getName)
				.filter(this::isInValidCarNameLength)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(OutputType.EXCEPTION.getComment()));
	}

	private boolean isInValidCarNameLength(String carName) {
		return carName.length() > MAX_LENGTH_OF_CAR_NAME || carName.length() == MIN_LENGTH_OF_CAR_NAME;
	}
}
