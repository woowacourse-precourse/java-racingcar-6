package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int trial;
    private List<Car> cars;

    public Game(List <String> carsName, int trial){
        setCars(carsName);
        this.trial = trial;
    }

    public List<Car> getCars(){
        return cars;
    }

    public void playGame(){
        System.out.println("실행 결과");

        for(int round = 0; round < trial; round++){
            playRound();
            System.out.print("\n");
        }
    }

    public void setCars(List<String> carsName){
        this.cars = new ArrayList<Car>();
        for(String name : carsName){
            cars.add(new Car(name));
        }
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void playRound(){
        for(Car car : cars){
            car.move(getRandomNumber());
        }
    }
}
