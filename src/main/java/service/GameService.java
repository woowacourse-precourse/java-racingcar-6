package service;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class GameService {
    //Game 객체

    Car car = new Car();

    public void runRacingGame(){

    }

    /**
     * 경주 할 자동차 목록 만들기
     *
     * @param carNames 사용자가 입력한 경주한 자동차 이름들
     * @return 각 자동차 이름을 분리하여 List에 담아 리턴한다.
     */
    private List<Car> getCarList(String carNames){
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");
        for(String carName : carNameArray){
            carList.add(car.setCarName(carName));
        }

        return carList;
    }

}
