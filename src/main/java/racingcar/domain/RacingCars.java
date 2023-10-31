package racingcar.domain;

import racingcar.utils.RandomNumber;
import racingcar.view.OutputView;

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
        System.out.println("실행 결과");
        for(Car car : racingCars){
            car.move(RandomNumber.getRandomNumber());
            OutputView.printCarPositionMessage(car);
        }
    }

    public Winner findWinner(){
        Winner winner = new Winner();
        for(Car car : racingCars){
            if(car.getPosition() > winner.getPosition()){
                winner.getWinners().clear();
                winner.getWinners().add(car);
            }
            if(car.getPosition() == winner.getPosition()){
                winner.getWinners().add(car);
            }
        }
        return winner;
    }

}
