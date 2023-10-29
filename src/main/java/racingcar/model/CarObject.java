package racingcar.model;

import java.util.ArrayList;

public class CarObject {
    public static int size = 0;
    public static ArrayList<Integer> distance;
    public static ArrayList<String> name;
    private ArrayList<CarComponent> cars;

    private CarObject() {}

    private static class SingleInstanceHolder {
        private static final CarObject INSTANCE = new CarObject();
    }

    public static CarObject getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public void updateDistance() {
        for(int i = 0; i < size; i++) {
            cars.get(i).addDistance(distance.get(i));
        }
    }

    public void addComponent() {
        for(int i = 0; i < size; i++) {
            cars.add(new CarComponent(name.get(i), distance.get(i)));
        }
    }
}
