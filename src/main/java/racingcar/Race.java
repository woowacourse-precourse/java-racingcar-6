package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.validation.ParticipatingCarsValidation;

public class Race {
    private List<Car> participatingCars;
    private int moveCounts;
    public ParticipatingCarsValidation participatingCarsValidation;

    public Race() {
        participatingCars = new ArrayList<>();
        participatingCarsValidation = new ParticipatingCarsValidation();
    }

    public void registerCar(List<String> participatingCars) {
        participatingCarsValidation.validateParticipatingCars(participatingCars);
        for (String carName : participatingCars) {
            this.participatingCars.add(new Car(carName));
        }
    }

    public void registerMoveCounts(int moveCounts) {
        this.moveCounts = moveCounts;
    }

    private int injectFuel() {
        int fuel;
        do {
            fuel = Randoms.pickNumberInRange(0, 9);
        } while (fuel < 1 || fuel > 9);
        return fuel;
    }

    public void startCarRacing() {
        validateRaceNotOver();
        conductRace();
        decreaseMoveCounts();
    }

    private void validateRaceNotOver() {
        if (isRaceOver()) {
            throw new IllegalStateException("경기가 종료되었습니다.");
        }
    }

    public boolean isRaceOver() {
        return moveCounts <= 0;
    }

    private void conductRace() {
        for (Car car : participatingCars) {
            car.tryMove(injectFuel());
        }
    }

    private void decreaseMoveCounts() {
        moveCounts--;
    }

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }

    public List<String> calculateWinners() {
        int furthestLocation = findFurthestLocation();
        return getWinnersNames(furthestLocation);
    }

    public int findFurthestLocation() {
        int furthestLocation = 0;
        for (Car car : participatingCars) {
            if (car.getLocation() > furthestLocation) {
                furthestLocation = car.getLocation();
            }
        }
        return furthestLocation;
    }

    public List<String> getWinnersNames(int furthestLocation) {
        List<String> winnersNames = new ArrayList<>();
        for (Car car : participatingCars) {
            if (car.getLocation() == furthestLocation) {
                winnersNames.add(car.getName());
            }
        }
        return winnersNames;
    }
}