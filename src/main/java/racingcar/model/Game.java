package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Game {
    private final ArrayList<Car> cars;
    private final Integer gameRound;

    public Game(ArrayList<String> carNames, int gameRound) {
        this.cars = createCars(carNames);
        this.gameRound = gameRound;
    }


    private static ArrayList<Car> createCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(String car : carNames) cars.add(new Car(car));
        return cars;
    }

    public ArrayList<String> findWinner(){
        ArrayList<String> winners = new ArrayList<>();
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car2.getDistance() - car1.getDistance();
            }
        });

        int longDistance = cars.get(0).getDistance();
        for(Car car : cars){
            if(car.getDistance() == longDistance) winners.add(car.getName());
            else break;
        }
        return winners;
    }
}
