package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printEachForwardResult(List<Car> cars) {
        for(Car car: cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    private String getCarStatus(Car car) {
        return car.getName() + " : " + getCarPositionInDash(car);
    }

    private String getCarPositionInDash(Car car) {
        return new String(new char[car.getPosition()]).replace("\0", "-");
    }
}
