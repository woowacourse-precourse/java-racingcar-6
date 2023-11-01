package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Cars {
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void addCars(String carListString) {
        List<Car> carList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(carListString,",");
        while (st.hasMoreTokens()) {
            carList.add(new Car(st.nextToken()));
        }

        cars = carList;
        validateInput();
    }


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int size() {
        return cars.size();
    }

    public Car get(int index) {
        return cars.get(index);
    }

    //carDtoList로 변환하는 로직
    private void validateInput() {
        if (cars.size() == 1) {
            throw new IllegalArgumentException();
        }

        Set<String> carNameSet = new HashSet<>();

        //넣어진 인스턴스 값을 바탕으로 하면 되겠네!
        for (int i = 0; i < cars.size(); i++) {
            Car carInList = cars.get(i);
            String carNameInList = carInList.getCarName();

            if (carNameInList.length() > 5) {
                throw new IllegalArgumentException();
            }

            carNameSet.add(carNameInList);
        }

        if (carNameSet.size() != cars.size()) {
            throw new IllegalArgumentException();
        }

    }
}
