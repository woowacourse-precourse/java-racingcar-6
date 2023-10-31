package racingcar.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static BigInteger idProvider = BigInteger.ZERO;
    private final List<Car> cars;
    private int currentRacingRound;

    public RacingCars(CarsDto carsDto) {
        cars = new ArrayList<>(carsDto.getNumberOfCars());

        for (int i = 0; i < carsDto.getNumberOfCars(); i++) {
            String singleCarName = carsDto.getSingleCarName(i);
            idGenerate();
            cars.add(Car.createCar(idProvider, singleCarName));
        }
    }

    private static void idGenerate() {
        idProvider = idProvider.add(BigInteger.ONE);
    }
}
