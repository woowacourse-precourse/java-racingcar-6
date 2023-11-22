package provider;

import mock.MockNumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.WinnerCar;

public class TestProvider {

    public static Car createTestCar(final String carName) {
        return Car.create(carName);
    }

    public static MockNumberGenerator createMockNumberGenerator(final boolean isIncrease) {
        return new MockNumberGenerator(isIncrease);
    }

    public static Cars createTestCars(final String carNames, final MockNumberGenerator numberGenerator) {
        return Cars.create(carNames, numberGenerator);
    }

    public static Race createTestRace(final String raceCount) {
        return Race.create(raceCount);
    }

    public static WinnerCar createTestWinnerCar(Cars cars) {
        return WinnerCar.create(cars);
    }
}
