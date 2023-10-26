package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;

public class Cars {

    private final ArrayList<Car> carList;

    public Cars() {
        carList = new ArrayList<>();
    }

    public void fill(String[] carNameArr,int[] distance) {
        int i = 0;
        for(String name : carNameArr) {
            carList.add(new Car(name,distance[i++]));
        }
    }

    public void fill(String[] carNameArr) {
        for(String name : carNameArr) {
            carList.add(new Car(name));
        }
    }

    public void race() {
        for(Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            car.move(randomNumber);
        }
    }

    public String getWinners() {
        Collections.sort(carList);
        int  winDistance = carList.get(0).getDistance();
        ArrayList<String> winnerList = makeWinnerList( winDistance);
        return String.join(", ",winnerList);
    }

    private ArrayList<String> makeWinnerList(int winDistance) {
        ArrayList<String> winnerList = new ArrayList<>();
        for(Car car : carList) {
            int distance = car.getDistance();
            if(winDistance > distance) { break; }
            winnerList.add(car.getName());
        }
        return winnerList;
    }

}
