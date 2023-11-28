package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(Message.GAME_RESULT);
        for (int i=0; i<number; i++){
            playRacingRound();
        }
        System.out.print(Message.OUTPUT_WINNER);
        System.out.println(winnerMaxDistance());
    }
    
    public String winnerMaxDistance(){
        int maxDistance = getMaxDistance();
        return this.cars
                .stream()
                .filter(car-> car.getPosition() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
    
    public int getMaxDistance(){
        return this.cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElse(0);
    }

}
