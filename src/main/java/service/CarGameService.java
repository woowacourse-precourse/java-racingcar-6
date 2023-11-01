package service;

import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Game;

public class CarGameService {
    //Game 객체

    Car car = new Car();

    public List<String> runRacingGame(List<Car> carList){
        List<String> racingGameBoard = new ArrayList<>();
        Game.tryCount--;

        List<Car> racingGameResult = getRacingGameResult(carList);


        return racingGameBoard;
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

    /**
     * 자동차 경주 한판의 전진 결과
     *
     * 각 자동차들은 임의의 값을 기준으로 전진하거나 멈춘다.
     * @return List<Car>
     */
    public List<Car> getRacingGameResult(List<Car> carList){
        for(Car car : carList){
            int randomNumber = car.getRandomNumber();
            if(car.isStepForward(randomNumber)){
                car.MoveForward();
            }
        }

        return carList;
    }

    /**
     * 자동차 경주 우승자 결과
     *
     */


}
