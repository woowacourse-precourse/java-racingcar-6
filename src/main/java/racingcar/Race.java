package racingcar;

import java.util.*;

/*
 * 자동차 이동
 */
public class Race {
    private static MoveCar mc = new MoveCar();
    private List<String> cars;

    private List<Integer> distance;

    private int round;

    public void go() {
        for (int i=0; i<cars.size(); i++){
            distance.set(i, distance.get(i) + mc.goOrStop());
        }
    }

    public void printRound() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i)+" : ");
            for (int j = 0; j < distance.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setCars(String carsStr){
        this.cars = Arrays.asList(carsStr.split(","));

        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        distance = new ArrayList<>(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            distance.add(0);
        }
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<String> getCars() {
        return cars;
    }

    public String getCar(int i) {
        return cars.get(i);
    }

    public int getRound() {
        return round;
    }

    public List<Integer> getDistance() {
        return distance;
    }

}
