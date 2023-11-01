package service;

import java.util.ArrayList;
import java.util.List;
import model.Car;

public class CarGameService {
    //Game 객체

    Car car = new Car();

    public List<String> runRacingGame(List<Car> carList){
        List<String> runRacingResult = new ArrayList<>();

        return runRacingResult;
    }

    /**
     * 경주 할 자동차 목록 만들기
     *
     * @param carNames 사용자가 입력한 경주한 자동차 이름들
     * @return 각 자동차 이름을 분리하여 List에 담아 리턴한다.
     */
    public List<Car> getCarList(String carNames){
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");
        for(String carName : carNameArray){
            carList.add(new Car(carName));
        }

        return carList;
    }

    public boolean validateCarNameList(String carList){
        String[] carArray = carList.split(",");
        for(String car : carArray){
            Car.validateCarName(car);
        }
        return true;
    }

}
