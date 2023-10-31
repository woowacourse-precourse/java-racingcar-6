package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {
    //중간 점수 정보 반환
    //최종 점수 반환

    static HashMap<String, Integer> carScore = new HashMap<>();
    //static List<String> carOrder = new ArrayList<>(); 입력 받는 곳에
    private static List<Car> cars = new ArrayList<>();

    public List<Car> initCar (List<String> carNames) { //객체 생성

        for(String carName : carNames){
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<String> winnerData() { //우승 데이터를 반환
        int topDistance = findTopScore(cars);

        List<String> winnerList = cars.stream()
                .filter(car -> car.getDistance() == topDistance)
                .map(Car :: getCarName)
                .collect(Collectors.toList());

        return winnerList;
    }

    private int findTopScore(List<Car> carNames){

        return carNames.stream()
                .mapToInt(Car :: getDistance) //=(Car car) -> car.getDistance()
                .max()
                .orElse(0);
    }

    public void setCarRandomValue(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        for(Car carName : cars){
            if(randomNumberGenerator.isNumberThanEqualFour()){
                carName.move(carName);
            }
        }
    }



}
