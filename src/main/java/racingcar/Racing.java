package racingcar;

import java.util.ArrayList;

public class Racing {

    ArrayList<Car> cars = new ArrayList<>();
    int max;
    int count;

    public Racing(int max) {
        this.max = max;
    }

    public void registCars(String names) {

        names = names.replaceAll(" ", "");
        String[] name = names.split(",");

        for ( String n : name ) {
            Car c = new Car(n, "");
            cars.add(c);
        }
    }

    public void registCount(String count) {

        this.count = Integer.parseInt(count);
        System.out.println();
    }

    public void start() {

        for ( int i = 0; i < count; i++ ) {

            for( Car car : cars ) {

                int length = car.distance.length();

                if ( max < length ) {
                    max = length;
                }
            }

            System.out.println();
        }
    }

    public void printWinner() {

        ArrayList<String> winner = new ArrayList<>();

        for (Car car : cars) {
            if (car.distance.length() == max) {
                winner.add(car.name);
            }
        }

        System.out.println(String.join(",", winner));
    }
}
