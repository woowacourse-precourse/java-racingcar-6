package racingcar;

import java.util.ArrayList;;
import java.util.Collections;
import java.util.HashMap;


public class Car {
    private final int STARTING_POINT = 0;
    private final int FOWARD = 1;
    private HashMap<String, Integer> car = new HashMap<>();

    InputData inputData = new InputData();

    public void initializeCar() {
        inputData.inputCarName();
        ArrayList<String> carName = inputData.returnCarName();

        for (String eachCarName : carName) {
            car.put(eachCarName, STARTING_POINT);
        }
    }

    public void updateCarPosition(String carName, boolean move) {
        if (move) {
            car.replace(carName, car.get(carName) + FOWARD);
        }
    }

    public ArrayList<String> getWinner() {
        ArrayList<String> winner = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (String carName : car.keySet()) {
          if (isMaxPosition(maxPosition, car.get(carName))) {
              winner.add(carName);
            }
        }
        return winner;
    }

    private int getMaxPosition() {
        return Collections.max(car.values());
    }

    private boolean isMaxPosition(int maxPosition, int position) {
        return maxPosition == position;
    }

    public int getCarCount() {
        return car.size();
    }

    public ArrayList<String> getCarName() {
        return new ArrayList<>(car.keySet());
    }

    public ArrayList<Integer> getCarPosition() {
        return new ArrayList<>(car.values());
    }


}
