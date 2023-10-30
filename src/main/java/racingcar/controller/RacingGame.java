package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.CarName;
import racingcar.view.Order;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> winner = new ArrayList<>();
    private CalculatingScore winners = new CalculatingScore();
    private MovingCars movingCars = new MovingCars();
    private CarName carName = new CarName();
    private Order order = new Order();
    public void play() {
        splitCars(inputCarName());
        movingCars.start(carList);
        winners.result(carList, winner);
        win();
    }

    private void splitCars(String carNames) {
        String[] cars = carNames.split(",");

        for (String name : cars) {
            Car car = new Car(name, "");
            carList.add(car);
        }
    }

    private String inputCarName() {
        return carName.input();
    }

    private void win() {
        switch (winner.size()){
            case 0:
                order.noWinner();
                break;
            case 1:
                person();
                break;
            default:
                people();
        }
    }

    private void people() {
        for(int person = 0; person < winner.size(); person++){
            if(person != winner.size()-1){
                System.out.print(winner.get(person)+", ");
            }
            else if(person == winner.size()-1){
                System.out.println(winner.get(person));
            }
        }
    }

    private void person() {
        System.out.print(winner.get(0));
    }
}
