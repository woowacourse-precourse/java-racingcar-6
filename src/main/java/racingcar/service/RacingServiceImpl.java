package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class RacingServiceImpl implements RacingService {
    private final CarRepository carRepository;

    public RacingServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    List<String> record = new ArrayList<>();

    @Override
    public void race(List<String> carList, String count) {
        int tryCount = Integer.parseInt(count);
        registerCars(carList);

        for (int i = 0; i < tryCount; i++) {
            driveAllCars(carRepository.getCarList());
            writeRecord(carRepository.getCarList());
        }
    }

    @Override
    public void registerCars(List<String> carList) {
        for (String car : carList) {
            carRepository.save(car);
        }
    }

    @Override
    public void driveAllCars(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).drive();
        }
    }

    @Override
    public void writeRecord(List<Car> carList) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            sb.append(car.getName() + " : " + car.showCarPosition() + "\n");
        }

        record.add(sb.toString());
    }

    @Override
    public List<String> getRecord() {
        return this.record;
    }
}
