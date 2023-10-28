package racingcar.model.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.repository.CarRepository;
import racingcar.view.InputView;

public class GameService {
    CarRepository carRepository;

    public GameService(){
        carRepository = new CarRepository();
    }

    public void createCars(){
        List<String> names = InputView.inputName();
        names.forEach(name -> carRepository.save(name));
    }
}
