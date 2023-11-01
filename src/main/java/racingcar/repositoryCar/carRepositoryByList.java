package racingcar.repositoryCar;

import racingcar.controller.checkWinner.CheckWinner;
import racingcar.controller.distinguish.Distinguish;
import racingcar.controller.random.RandomMove;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class carRepositoryByList implements CarRepository{
    private List<Car> carRepository;
    private RandomMove randomMove;
    private CheckWinner checkWinner;


    public carRepositoryByList(RandomMove randomMove, CheckWinner checkWinner) {
        this.carRepository = new ArrayList<>();
        this.randomMove = randomMove;
        this.checkWinner = checkWinner;
    }

    @Override
    public List<Car> getCarList() {
        return new ArrayList<>(carRepository);
    }
    @Override
    public String[] getWinnerName() {
        return checkWinner.getWinner(carRepository);
    }

    @Override
    public void save(Car car) {
        carRepository.add(car);
    }

    @Override
    public void updatePosition() {
        for(Car car : carRepository){
            if(randomMove.getMove()){
                car.move();
            }
        }
    }
}
