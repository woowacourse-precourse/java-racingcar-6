package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public List<Car> cars = new ArrayList<>();

    public CarList(List<String> names) {
        for (String name: names){
            cars.add(new Car(name));
        }
    }

    // 랜덤으로 받을 수들 업데이트
    // car의 updateDistance 호출
    public void upgradeDistance(List<Integer> distanceList){
        int index = 0;
        for (Car car: cars){
            car.updateDistance(distanceList.get(index));
            index ++;
        }
    }

    public List<String> getWinner(){
        List<String> winner = new ArrayList<>();
        return winner;
    }

    @Override
    /*
    * pobi : -
      woni :
      jun : -
      \n
    * 이렇게 공백까지 합쳐서 하나의 세트로 리턴하세요
    * */
    public String toString() {
        String addcars = "";
        for (Car car: cars){
            addcars += car.toString();
        }
        return addcars;
    }
}
