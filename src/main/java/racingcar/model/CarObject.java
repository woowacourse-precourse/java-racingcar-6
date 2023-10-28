package racingcar.model;

import java.util.ArrayList;

public class CarObject {
    public static final int MOVE_CONDITION = 4;
    public static final int CAR_NAME_LIMIT_SIZE = 5;
    public static int carOnceMove;
    public static int carsSize = 0;
    public static int epoch;
    private static ArrayList<CarComponent> cars;

    private CarObject(CarComponent component) {
        cars.add(component);
    }

    public static CarObject nameOf(String name, int distance) {
        return new CarObject(new CarComponent(name, distance));
    }

    public static void updateCarDistance(ArrayList<Integer> distance) {
        for(int i = 0; i < carsSize; i++) {
            cars.get(i).addDistance(distance.get(i));
        }
    }
}
