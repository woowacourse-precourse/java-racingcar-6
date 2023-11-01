package racingcar;

import racingcar.utils.Message;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int number;


    public RacingGame(List<String> cars, int number) {
        setCars(cars);
        this.number = number;
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

    public void playRacingGame(){
        System.out.println(Message.racing);
        for (int i=0; i<number; i++){
            playRacingRound();
        }
    }

}
