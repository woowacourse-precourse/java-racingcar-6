package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.Validate;

public class Cars{
    private List<Car> cars;
    public Cars(List<Car> cars) {
        Validate.carNamesDuplicate(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size(){
        return cars.size();
    }

    public String getWinner(List<Car> cars) {
        List<String> winner = new ArrayList<>();
        int max = getMaxPosition(cars);

        for(Car carItem : cars) {
            if(carItem.getPosition() == max) {
                winner.add(carItem.getMember());
            }
        }

        return String.join(", ", winner);
    }

    // 모든 자동차들 중 가장 높은 position 값 반환
    private int getMaxPosition(List<Car> cars) {
        int maxPosition = Integer.MIN_VALUE;

        for(Car car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }
}
