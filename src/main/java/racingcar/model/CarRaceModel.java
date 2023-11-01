package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;

public class CarRaceModel {

    public List<String> generateCarName(String carNames) {

        List<String> carNameList = Arrays.asList(carNames.split(","));
        HashMap<String, String> carHashMap = new HashMap<>();

        return carNameList;
    }

    public List<Car> generateCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for(int i = 0; i < carNameList.size(); i++) {
            carList.add(new Car(carNameList.get(i)));
        }

        return carList;
    }

    public List<String> findWinner(List<Car> carList) {
        List<String> winner = new ArrayList<>();
        int topMovement = 0;

        for(int i = 0; i < carList.size(); i++) {
            String carName = carList.get(i).getName();
            int carMovement = carList.get(i).getDistance();

            winner.add(carName);

            if(carMovement > topMovement) {
                winner.clear();
                topMovement = carMovement;
                winner.add(carName);
            }
        }
        return winner;
    }

}
