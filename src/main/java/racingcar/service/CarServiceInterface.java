package racingcar.service;

import racingcar.model.Car;

import java.util.List;

public interface CarServiceInterface {

    public void createCar(String[] cars);
    public void movieCar();
    public List<Car> getCars();
    public List<Car> finalResult();
}
