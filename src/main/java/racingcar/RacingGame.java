package racingcar;

import racingcar.utils.Message;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int number;
    private List<Car> cars;

    public RacingGame(int number, List<Car> cars) {
        this.number = number;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void setCars(List<String> carsName){
        this.cars = new ArrayList<Car>();
        for(String name : carsName){
            cars.add(new Car(name));
        }
    }
    private void playRacingRound(){
        for(Car car : cars){
            car.move();
        }
        System.out.println();
    }

    private void playRacingGame(){
        System.out.println(Message.racing);
        for (int i=0; i<number; i++){
            playRacingRound();
        }
    }

}
