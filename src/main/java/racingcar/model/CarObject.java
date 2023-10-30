package racingcar.model;

import java.util.ArrayList;

public class CarObject {
    public static int size = 0;
    public static ArrayList<String> name = new ArrayList<>();
    private ArrayList<CarComponent> cars = new ArrayList<>();

    private CarObject() {}

    private static class SingleInstanceHolder {
        private static final CarObject INSTANCE = new CarObject();
    }

    public static CarObject getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }

    public CarComponent getComponentIndexOf(int index) {
        return cars.get(index);
    }

    public void updateDistance() {
        for(int i = 0; i < size; i++) {
            cars.get(i).addDistance();
        }
    }

    public void addComponent() {
        for(int i = 0; i < size; i++) {
            cars.add(new CarComponent(name.get(i), 0));
        }
    }
}
