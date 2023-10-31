package racingcar.model;

import java.util.List;

public record RacingCars(List<RacingCar> racingCarList) {

    public static RacingCars init(List<String> carNameList) {
        List<RacingCar> initRacingCarList = carNameList.stream()
                .map(RacingCar::init)
                .toList();
        return new RacingCars(initRacingCarList);
    }

    public RacingCars move() {
        List<RacingCar> movedRacingCarList = racingCarList.stream()
                .map(RacingCar::move)
                .toList();
        return new RacingCars(movedRacingCarList);
    }

    public RacingCars findWinners() {
        int maxLocation = getMaxLocation();
        List<RacingCar> winners = racingCarList.stream()
                .filter(car -> isWinner(car, maxLocation))
                .toList();

        return new RacingCars(winners);
    }


    private int getMaxLocation() {
        return racingCarList.stream()
                .mapToInt(RacingCar::getCurrentLocation)
                .max()
                .orElse(0);
    }

    private boolean isWinner(RacingCar car, int maxLocation) {
        return car.getCurrentLocation() == maxLocation;
    }
}
