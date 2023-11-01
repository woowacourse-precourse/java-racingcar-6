package racingcar.repository;

import racingcar.domain.ResultDto;
import racingcar.domain.CarsDto;
import racingcar.domain.Client;
import racingcar.domain.Car;
import racingcar.domain.SingleRoundResultDto;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final ResultDto result;
    private final List<Car> cars;
    private int currentRacingRound;

    public CarRepository(CarsDto carsDto, Client client) {

        result = new ResultDto(client.getTotalRounds());

        int numberOfCars = carsDto.getNumberOfCars();
        cars = new ArrayList<>(numberOfCars);
        for (int i = 0; i < numberOfCars; i++) {
            String singleCarName = carsDto.getSingleCarName(i);
            cars.add(Car.createCar(singleCarName));
        }

        currentRacingRound = 0;
    }

    public void race() {
        currentRacingRound++;
        cars.forEach(Car::raceOneRound);
        SingleRoundResultDto singleRoundResult = new SingleRoundResultDto(generateCarResults());
        result.addSingleRoundResult(currentRacingRound, singleRoundResult);
    }

    private List<Car.CarResultDto> generateCarResults() {
        return cars.stream()
                .map(Car::createCarResultDto)
                .toList();
    }

    public ResultDto finishFinalRound() {
        long maxDistance = calculateMaxDistance();
        generateFinalWinners(maxDistance);
        return result;
    }

    private int calculateMaxDistance() {
        int maxDistance = 1;
        // 아무도 한 칸도 전진하지 않았으면 우승자가 없는 것으로 간주하기 위해서 maxDistance를 1부터 시작한다.
        for (Car car : cars) {
            Car.CarResultDto carResult = car.createCarResultDto();
            int distance = carResult.distance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    private void generateFinalWinners(long maxDistance) {
        cars.stream()
                .map(Car::createCarResultDto)
                .filter(carResult -> carResult.distance() == maxDistance)
                .map(Car.CarResultDto::name)
                .forEach(result::addFinalWinner);
    }

    public boolean isFinalRound() {
        return currentRacingRound == result.getFinalRound();
    }
}