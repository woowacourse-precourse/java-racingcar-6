package racingcar.domain;

import java.util.List;

public class Race {

    private List<Car> cars;
    private int countOfPlays;


    public Race(List<Car> cars, int countOfPlays) {
        this.cars = cars;
        this.countOfPlays = countOfPlays;
    }

    private Race(int countOfPlays){

    }

    private Race(List<Car> cars) {

    }

    private Race() {

    }

    public List<Car> runRace(){
        for(int playCount=0; playCount<countOfPlays;playCount++){
            playOnce();
            System.out.println();
        }

        return cars;

    }

    private void playOnce() {
        for (Car car: cars) {
            car.goForward();
            System.out.println(car.printResult());
        }
    }


}
