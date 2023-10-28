package service;

import camp.nextstep.edu.missionutils.Randoms;

import domain.Car;

import message.GameMessage;

import java.util.ArrayList;
import java.util.Collections;

public class CarService {

    private final ArrayList<Car> carList;
    private final StringBuilder sb;
    private static CarService defaultCarService;

    private CarService() {
        carList = new ArrayList<>();
        sb = new StringBuilder();
    }

    public static CarService getInstance() {
        if(defaultCarService == null) {
            defaultCarService = new CarService();
        }
        return defaultCarService;
    }

    public void close() {
        defaultCarService = null;
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

    public String getResult(int count) {
        while(count-- > 0) {
            race();
            if(count != 0) {
                sb.append(GameMessage.newLine.getMessage());
            }
        }
        return sb.toString();
    }

    private void race() {
        for(Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            car.move(randomNumber);
            raceRecord(car);
        }
    }

    private void raceRecord(Car car) {
        sb.append(car.getName()).append(GameMessage.equal.getMessage());
        buildBar(car.getDistance());
    }

    private void buildBar(int distance) {
        while(distance-- > 0) {
            sb.append(GameMessage.bar.getMessage());
        }
        sb.append(GameMessage.newLine.getMessage());
    }

    public String getWinners() {
        Collections.sort(carList);
        int  winDistance = carList.get(0).getDistance();
        ArrayList<String> winnerList = makeWinnerList(winDistance);
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
