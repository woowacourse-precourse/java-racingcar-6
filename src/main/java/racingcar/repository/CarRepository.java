package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.ResultDto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final ResultDto result;
    private final List<Car> cars;
    private BigInteger currentRacingRound;
    private static BigInteger idProvider = BigInteger.ZERO;

    public CarRepository(CarsDto carsDto, Client client) {

        result = new ResultDto(client.getTotalRounds());

        cars = new ArrayList<>(carsDto.getNumberOfCars());

        for (int i = 0; i < carsDto.getNumberOfCars(); i++) {
            String singleCarName = carsDto.getSingleCarName(i);
            cars.add(Car.createCar(idProvider, singleCarName));
            idGenerate(); // id는 0부터 1씩 증가한다.
        }

        currentRacingRound = BigInteger.ZERO;
    }

    private static void idGenerate() {
        idProvider = idProvider.add(BigInteger.ONE);
    }

}
