package racingcar;
import java.util.List;
import java.util.ArrayList;
import racingcar.Car;

public class Cars {
    private List<Car> cars;

    public Cars(String[] carNameList) {
        this.cars = new ArrayList<>();

        for(String carName : carNameList)
            cars.add(new Car(carName));

    }

    public final List<Car> getCars(){
        return this.cars;
    }

    public final Integer getCarsSize(){
        return this.cars.size();
    }

    // 자동차들 중에서 가장 많이 이동한 거리를 찾기.
    public final Integer maximumDistance() {
        Integer maxDistance = 0;
        for(int i = 0; i < getCarsSize(); i++){
            Car car = cars.get(i);
            String carDistance = car.getDistance();
            maxDistance = Math.max(maxDistance, carDistance.length());
        }

        return maxDistance;
    }

}
