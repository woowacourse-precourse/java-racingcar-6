package racingcar;

import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void add(String name) {
        cars.add(new Car(name));
    }

    public void racing() {
        for(int i=0;i<cars.size();i++) {
            int randomNum = NumberGenerator.createRandomNumber();

            if(randomNum >= Constants.CAR_FORWARD_MIN_VALUE) {
                cars.get(i).forward();
            }
        }
    }

    public void printRoundRacingResult() {
        for(int i=0;i<cars.size();i++) {
            cars.get(i).printForwardDistance();
        }
        System.out.println();
    }

    public void printRacingResult() {

    }
}
