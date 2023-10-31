package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<>();
    private int size;

    public CarList(List<String> names) {
        for (String name : names) {
            this.carList.add(new Car(name));
        }
        this.size = names.size();
    }

    // CarList 사이즈만큼 Integer 리스트를 받아와서 차례대로 하나씩 적용
    public void updateDistance(List<Integer> distanceList) {
        int index = 0;
        for (Car car : carList) {
            car.updateDistance(distanceList.get(index));
            index++;
        }
    }

    public List<String> getWinner(int maxDistance) {
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
    * */
    public String toString() {
        String addcars = "";
        for (Car car : carList) {
            addcars += car.toString();
        }
        return addcars;
    }

    public int getSize() {
        int returnSize = size;
        return returnSize;
    }

    public int getMaxDistance() {
        return carList.stream().max(Comparator.comparingInt(Car::getDistance)).get().getDistance();
    }
}
