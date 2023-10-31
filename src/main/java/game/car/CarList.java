package game.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarList {
    private final ArrayList<Car> carList;

    public CarList(String inputString) {
        carList = new ArrayList<>();
        for (String s : inputString.split(",")) {
            this.add(new Car(s));
        }
    }

    private void add(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.carList);
    }

    public int findMaxPosition() {
        int maxPosition=0;
        for (Car car : carList) {
            if(maxPosition<car.getPosition()){
                maxPosition=car.getPosition();
            }
        }
        return maxPosition;
    }
}
