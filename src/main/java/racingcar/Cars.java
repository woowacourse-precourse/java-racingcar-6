package racingcar;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<String> getFinalWinners() {
        int max = getMaxCarDistance();

        ArrayList<String> winners = new ArrayList<>();

        for(int i=0;i<cars.size();i++) {
            Car car = cars.get(i);

            if(max == car.getDistance()) {
                winners.add(car.name);
            }
        }

        return winners;
    }

    private int getMaxCarDistance() {
        int max = 0;

        for(int i=0;i<cars.size();i++) {
            max = Math.max(max, cars.get(i).getDistance());
        }

        return max;
    }
}
