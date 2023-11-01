package racingcar;

import java.util.Collections;
import java.util.List;

public class CarListView {
    private List<Car> carList;
    public CarListView(List<Car> carList){
        this.carList = carList;
    }
    public void printCurrentStatus(){
        for(Car car: carList){
            car.print();
        }
        System.out.println();
    }
    public void printWinner(){
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        Collections.sort(carList, Collections.reverseOrder());
        sb.append(carList.get(0).getName());
        int maxPos = carList.get(0).getLocation();
        for (int i = 1; i < carList.size(); i++) {
            if(carList.get(i).getLocation() == maxPos){
                sb.append(", ").append(carList.get(i).getName());
            } else {
                break;
            }
        }
        System.out.println(sb);
    }
}
