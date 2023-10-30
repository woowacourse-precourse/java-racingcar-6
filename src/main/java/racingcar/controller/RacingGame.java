package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.CarName;
import racingcar.view.Order;
import racingcar.view.RotatingCount;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> winner = new ArrayList<>();
    RotatingCount rotatingCount = new RotatingCount();
    CarName carName = new CarName();
    Order order = new Order();
    public void play() {
        splitCars(inputCarName());
        move(rotatingCount.input());
        result();
        win();
    }

    private void splitCars(String carNames) {
        String[] cars = carNames.split(",");

        for (String name : cars) {
            Car car = new Car(name, "");
            carList.add(car);
        }
        order.rotateCount();
    }

    private String inputCarName() {
        order.racingStart();
        return carName.input();
    }

    private void result() {
        order.printWinner();
        int maxPoint = Integer.MIN_VALUE;

        for (Car car : carList) {
            int carPoint = point(car);

            if (carPoint > maxPoint) {
                maxPoint = carPoint;
                winner.clear();
                winner.add(car.getName());
            }

            else if (carPoint == maxPoint) {
                winner.add(car.getName());
            }
        }
    }

    private int point(Car car) {
        return score(car.getMove());
    }

    private int score(String move) {
        return move.length();
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

    private void move(int racingCount) {
        order.gameProcess();

        for(int count = 0; count < racingCount; count++){
            moveOrStop();
            moveState();
        }
    }

    private void moveState() {
        for (Car car : carList) {
            printCarState(car);
        }

        order.blank();
    }

    private void printCarState(Car car) {
        System.out.println(car.toString());
    }

    private void moveOrStop() {
        for (Car car : carList) {
            int state = Randoms.pickNumberInRange(0, 9);
            if (state > 3) {
                move(car);
            }
        }
    }

    private void move(Car car) {
        save(car);
    }

    private void save(Car car) {
        String location = car.getMove();
        car.setMove(location+"-");
    }
}
