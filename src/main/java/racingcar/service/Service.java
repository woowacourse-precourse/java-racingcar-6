package racingcar.service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;
import racingcar.repository.CarRepository;

public class Service {

    private static final Service instance = new Service();
    CarRepository carRepository;

    private Service() {
        this.carRepository = new CarRepository();
    }

    public static Service getInstance() {
        return instance;
    }

    public void saveCarsToRepository(CarsDto carsDto) {
        carRepository.save(carsDto);
    }

    public ArrayList<CarsDto> racingGivenTrialNumber(int inputTrialNumber) {
        int trialNumber = inputTrialNumber;
        ArrayList<CarsDto> resultEachTryList = new ArrayList<>();
        while (trialNumber-- > 0) {
            carRepository.racingAllCars();
            resultEachTryList.add(carRepository.findAllCars());
        }
        return resultEachTryList;
    }

    public CarsDto getWinner() {
        CarsDto carsDto = carRepository.findAllCars();
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

    public void initRepository() {
        carRepository.initRepository();
    }

}
