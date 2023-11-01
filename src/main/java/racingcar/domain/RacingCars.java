package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> racingCars = new ArrayList<>();

    public RacingCars(List<String> carNames){
        for(String carName : carNames){
            racingCars.add(new Car(carName));
        }
    }

    public void moveCars(){
        for(Car car : racingCars){
            car.move(RandomNumberGenerator.getRandomNumber());
        }
    }


    public List<Car> getRacingCars() {
        return racingCars;
    }

    public Winner findWinner(){
        Winner winner = new Winner();
        for(Car car : racingCars){
            if(car.getPosition() > winner.getPosition()){
                winner.getWinners().clear();
                winner.getWinners().add(car);
                winner.setPosition(car.getPosition());
                continue;
            }
            if(car.getPosition() == winner.getPosition()){
                winner.getWinners().add(car);
            }
        }
        return winner;
    }

}
