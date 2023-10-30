package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();
    private int size;
    public CarList(List<String> names) {
        for (String name: names){
            this.carList.add(new Car(name));
        }
        this.size = names.size();
    }

    // 랜덤으로 받을 수들 업데이트
    // car의 updateDistance 호출
    // 한 칸씩 업그레이드 해야 됨
    public void upgradeDistance(List<Integer> distanceList){
        int index = 0;
        for (Car car: carList){
            car.updateDistance(distanceList.get(index));
            index ++;
        }
    }

    public List<String> getWinner(){
        int maxDistance = getMaxDistance();
        List<String> winner = new ArrayList<>();
        for (Car h : carList) {
            if (h.getDistance() == maxDistance) {
                winner.add(h.getName());
            }
        }
        return winner;
    }

    @Override
    /*
    * pobi : -
      woni :
      jun : -
      \n
    * 공백까지 합쳐서 하나의 세트로 리턴하기
    * */
    public String toString() {
        String addcars = "";
        for (Car car: carList){
            addcars += car.toString();
        }
        return addcars;
    }

    public int getSize() {
        int returnSize = size;
        return returnSize;
    }

    public int getMaxDistance(){
        return carList.stream().max(Comparator.comparingInt(Car::getDistance)).get().getDistance();
    }
}
