package racingcar.repository;

import static racingcar.utils.CarMapper.mappingDomainToDto;
import static racingcar.utils.CarMapper.mappingDtoToDomain;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class CarRepository {

    private ArrayList<Car> garage = new ArrayList<>();

    public void save(CarsDto carsDto) {
        ArrayList<CarDto> carArrayList = carsDto.getCarArrayList();
        saveAsDomain(carArrayList);
    }

    private void saveAsDomain(ArrayList<CarDto> carArrayList) {
        carArrayList.stream()
                .forEach(carDto -> {
                    garage.add(mappingDtoToDomain(carDto));
                });
    }

    public void racingAllCars() {
        garage.stream()
                .forEach(car -> car.runTrack());
    }

    public CarsDto findAllCars() {
        ArrayList<CarDto> carDtoArrayList = convertGarageToDtoArrayList();
        CarsDto carsDto = new CarsDto(carDtoArrayList);

        return carsDto;
    }

    private ArrayList<CarDto> convertGarageToDtoArrayList() {
        ArrayList<CarDto> carDtoArrayList = new ArrayList<>();
        garage.stream()
                .forEach(car -> {
                    carDtoArrayList.add(mappingDomainToDto(car));
                });
        return carDtoArrayList;
    }

    public void initRepository() {
        garage = new ArrayList<>();
    }

}
