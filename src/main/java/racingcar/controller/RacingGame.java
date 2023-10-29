package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.CarName;
import racingcar.view.Order;
import racingcar.view.RotatingCount;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> carList = new ArrayList<>();
    private List<String> winner = new ArrayList<>();
    Order order = new Order();
    RotatingCount rotatingCount = new RotatingCount();
    CarName carName = new CarName();
    public void play() {
        order.racingStart();
        String[] carNames = carName.input().split(",");
        init(carNames);
        order.rotateCount();
        int racingCount = rotatingCount.input();
        order.gameProcess();
        check(racingCount);
        order.printWinner();
        calculate();
        win();
    }

    private void calculate() {
        int maxPoint = Integer.MIN_VALUE;

        for(int index = 0; index < carList.size(); index++){
            int carPoint = point(carList.get(index));
            if(carPoint > maxPoint){
                maxPoint = carPoint;
                winner.clear();
                winner.add(carList.get(index).getName());
            }

            else if(carPoint == maxPoint){
                winner.add(carList.get(index).getName());
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

    private void check(int racingCount) {
        for(int count = 0; count < racingCount; count++){
            moveOrStop();
            moveState();
        }
    }

    private void moveState() {
        for(int car = 0; car<carList.size(); car++){
            printCarState(carList.get(car));
        }
        order.blank();
    }

    private void printCarState(Car car) {
        System.out.println(car.toString());
    }

    private void moveOrStop() {
        for(int car = 0; car < carList.size(); car++){
            int state = Randoms.pickNumberInRange(0,9);
            if(state > 3){
                move(carList.get(car));
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

    private void init(String[] carNames){
        for(int index=0; index<carNames.length; index++){
            Car car = new Car(carNames[index],"");
            carList.add(car);
        }
    }
}
