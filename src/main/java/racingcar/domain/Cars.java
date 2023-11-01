package racingcar.domain;
import java.util.ArrayList;
import java.util.List;
public class Cars {
    private final List<Car> carList;
    public Cars(){
        this.carList = new ArrayList();
    }
    public void saveCars(Car car){
        carList.add(car);
    }
    public List<Car> getCars(){
        return carList;
    }

}
