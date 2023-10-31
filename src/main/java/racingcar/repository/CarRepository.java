package racingcar.repository;

import racingcar.domain.ResultDto;
import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.Car;
import racingcar.domain.SingleRoundResultDto;

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

    public void race(BigInteger round) {
        if (round.compareTo(currentRacingRound) > 0) {
            currentRacingRound = currentRacingRound.add(BigInteger.ONE);
            cars.forEach(Car::raceOneRound);
            SingleRoundResultDto singleRoundResult = new SingleRoundResultDto(generateCarResults());
            result.addSingleRoundResult(round, singleRoundResult);
        }
    }

    private List<Car.CarResultDto> generateCarResults() {
        return cars
                .stream()
                .map(Car::createCarResultDto)
                .toList();
    }

    public ResultDto finishFinalRound() {
        BigInteger maxDistance = calculateMaxDistance();
        cars.stream()
                .map(Car::createCarResultDto)
                .filter(carResult ->
                        carResult.getDistance()
                        .equals(maxDistance))
                .map(Car.CarResultDto::getName)
                .forEach(result::addFinalWinner);
        return result;
    }

    private BigInteger calculateMaxDistance() {
        BigInteger maxDistance = BigInteger.ZERO;
        for (Car car : cars) {
            Car.CarResultDto carResult = car.createCarResultDto();
            BigInteger distance = carResult.getDistance();
            if (distance.compareTo(maxDistance) > 0) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    public boolean isFinalRound() {
        return currentRacingRound.longValue() == result.getFinalRound().longValue();
    }
}