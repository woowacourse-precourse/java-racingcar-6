package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.utils.Constants;
import racingcar.utils.ErrorMessage;
import racingcar.validation.ParticipatingCarsValidation;

public class Race {
    private ParticipatingCars participatingCars;
    private MoveCounts moveCounts;
    public ParticipatingCarsValidation participatingCarsValidation;

    public Race() {
        participatingCars = new ParticipatingCars();
        participatingCarsValidation = new ParticipatingCarsValidation();
    }

    public void registerCar(List<String> carNames) {
        participatingCarsValidation.validateParticipatingCars(carNames);
        participatingCars.registerEachCar(carNames);
    }

    public void registerMoveCounts(int moveCounts) {
        this.moveCounts = new MoveCounts(moveCounts);
    }

    public void startCarRacing() {
        validateRaceNotOver();
        conductRace();
        moveCounts.decreaseMoveCounts();
    }

    private void validateRaceNotOver() {
        if (moveCounts.isOver()) {
            throw new IllegalArgumentException(ErrorMessage.RACE_ALREADY_FINISHED_ERROR_MESSAGE);
        }
    }

    private void conductRace() {
        participatingCars.moveEachCar(this::injectFuel);
    }

    public ParticipatingCars getParticipatingCars() {
        return participatingCars;
    }

    public List<String> calculateWinners() {
        return participatingCars.getWinnersNames();
    }

    public boolean isRaceOver() {
        return moveCounts.isOver();
    }

    private int injectFuel() {
        int fuel;
        do {
            fuel = Randoms.pickNumberInRange(Constants.MINIMUM_GENERATE_FUEL_LEVEL,
                    Constants.MAXIMUM_GENERATE_FUEL_LEVEL);
        } while (!isFuelInRange(fuel));
        return fuel;
    }

    private boolean isFuelInRange(int fuel) {
        return fuel >= Constants.MINIMUM_GENERATE_FUEL_LEVEL && fuel <= Constants.MAXIMUM_GENERATE_FUEL_LEVEL;
    }
}