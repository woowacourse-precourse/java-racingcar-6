package racingcar.service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.repository.CarRepository;

public class Service {
    CarRepository carRepository;

    public Service() {
        this.carRepository = CarRepository.getInstance();
    }


    public void saveCars(CarsDto carsDto) {
        carRepository.save(carsDto);
    }

    public void runOnce() {
        carRepository.runAllCars();
    }

    public CarsDto getResultOfOneTrack() {
        return carRepository.findAll();
    }

    public CarsDto getWinner() {
        CarsDto carsDto = carRepository.findAll();
        ArrayList<CarDto> carDtoArrayList = carsDto.getCarArrayList();

        int winnerDistance = getWinnerDistance(carDtoArrayList);
        ArrayList<CarDto> winners = findWinner(carDtoArrayList, winnerDistance);
        return new CarsDto(winners);

    }

    private static int getWinnerDistance(ArrayList<CarDto> carDtoArrayList) {
        int winnerDistance = carDtoArrayList.stream()
                .mapToInt(CarDto::getCurrentPosition)
                .max()
                .orElse(0);
        return winnerDistance;
    }

    private static ArrayList<CarDto> findWinner(ArrayList<CarDto> carDtoArrayList, int winnerDistance) {
        ArrayList<CarDto> winners = (ArrayList<CarDto>) carDtoArrayList.stream()
                .filter(car -> car.getCurrentPosition() == winnerDistance)
                .collect(Collectors.toList());
        return winners;
    }


}
