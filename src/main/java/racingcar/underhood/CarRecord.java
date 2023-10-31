package racingcar.underhood;

import java.util.ArrayList;
import java.util.List;
import racingcar.factories.CarRecordFactory;

public class CarRecord extends RacingGameComponent {

    private List<Car> cars;

    public CarRecord(GameRule rule) {
        super(rule);
        this.cars = new ArrayList<>();
    }

    public CarRecord getLeadingCarRecord() {
        int maxDistance = 0;
        CarRecord result = CarRecordFactory.createEmptyCarRecord(rule);
        for (Car car : cars) {
            if (maxDistance < car.getDistance())
                maxDistance = car.getDistance();
        }
        for (Car car : cars) {
            if (maxDistance == car.getDistance())
                result.register(car);
        }
        return result;
    }

    public void register(Car car) {
        this.cars.add(car);
    }

    public void moveForwardAllCars() {
        for (Car car: cars) {
            car.moveForward();
        }
    }

    public void printCurrentPositions() {
        for (Car car: cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        List<String> names = new ArrayList<>();
        for (Car car: cars) {
            names.add(car.getName());
        }
        return String.join(", ", names);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != CarRecord.class) {
            return false;
        }
        int hit = 0;
        CarRecord that = (CarRecord) obj;
        for (Car car: this.cars) {
            if (that.cars.contains(car)) {
                hit++;
            } else {
                return false;
            }
        }
        return hit == that.cars.size();
    }
}
