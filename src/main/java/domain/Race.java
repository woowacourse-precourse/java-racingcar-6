package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private ArrayList<Car> carList;
    private CarActionGenerator carActionGenerator;

    public Race(ArrayList<Car> carList) {
        this.carList = carList;
        this.carActionGenerator = new CarActionGenerator();
    }

    public void startRound() {
        for (Car car: carList) {
            carMoveJudge(car);
            System.out.println(car);
        }
    }

    public void repeatRound(int attempt) {
        for (int i = 0; i < attempt; i++) {
            startRound();
        }
    }

    public ArrayList<Car> getWinnerList() {
        ArrayList<Car> result = new ArrayList<Car>();
        Car maxDistanceCar = getMaxDistanceCar(carList);

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i) == maxDistanceCar)
                result.add(carList.get(i));
        }

        return result;
    }

    private void carMoveJudge(Car car) {
        boolean isMove = carActionGenerator.getDriveOrHalt();

        if (isMove) {
            car.forward();
        }
    }

    private Car getMaxDistanceCar(ArrayList<Car> carList) {
        List<Car> sortedCarList = new ArrayList<>(carList);
        Collections.sort(sortedCarList);

        return sortedCarList.get(sortedCarList.size() - 1);
    }

}
