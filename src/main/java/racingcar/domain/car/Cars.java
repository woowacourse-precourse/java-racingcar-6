package racingcar.domain.car;

import racingcar.TryNumber;
import racingcar.domain.car.CarList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private CarList carList = new CarList();
    private TryNumber tryNumber = new TryNumber();

    // 유효한 자동차 값 저장하기
    public void addCar(String carNames){
        for (String carName : carNames.split(",")){
            carList.add(carName);
        }
    }

    public void setTryNumber(String tryNum) {
        tryNumber.setTryNumber(tryNum);
    }

    public List<Car> getCarList(){
        return carList.getCarList();
    }

    public int getTryNumber(){
        return Integer.parseInt(tryNumber.getTryNumber());
    }

    public int getCarsPosition() {
        List<Integer> carPositionList = new ArrayList<>();
        for (Car car: carList.getCarList()){
            carPositionList.add(car.getPosition());
        }
        return Collections.max(carPositionList);
    }

    public String getWinner(int maxPosition){
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList.getCarList()){
            if (maxPosition == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        return String.join(", ",winnerList);
    }
}
