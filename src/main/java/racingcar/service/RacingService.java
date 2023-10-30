package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.request.CarNamesDto;
import racingcar.dto.response.WinnersDto;
import racingcar.utility.MovementComparator;

public class RacingService {

    private static final int MOVEMENT_CONDITION = 4;

    private final CarRepository carRepository;

    public RacingService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(final CarNamesDto carNames) {
        for(String name: carNames.getNames()) {
            carRepository.save(name);
        }
    }

    public void action() {
        List<Car> carList = carRepository.findAll();
        int condition;
        for(Car car: carList) {
            condition = Randoms.pickNumberInRange(0, 9);
            if(condition >= MOVEMENT_CONDITION) {
                car.updateForwardCount();
                carRepository.update(car);
            }
        }
    }

    public WinnersDto findWinners() {
        List<Car> carList = carRepository.findAll();
        Collections.sort(carList, new MovementComparator());

        List<Car> winners = new ArrayList<>();
        Integer score = carList.get(0).getForwardCount();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getForwardCount() == score) {
                winners.add(carList.get(i));
            }
        }

        return new WinnersDto(winners);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
