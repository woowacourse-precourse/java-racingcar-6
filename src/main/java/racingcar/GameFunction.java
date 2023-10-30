package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameFunction {
    UserInput userInput = new UserInput();

    List<Car> makingCar() {
        List<String> carNameList = userInput.getCarNames();
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    List<Boolean> randomGo(List<Car> carList) {
        int numberOfCar = carList.size();
        List<Boolean> carCanGo = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            carCanGo.add(number >= 4);
        }
        return carCanGo;
    }

    void applyScore(List<Car> carList, List<Boolean> carCanGo) {
        for (int j = 0; j < carList.size(); j++) {
            Boolean go = carCanGo.get(j);
            Car car = carList.get(j);
            if (go) {
                car.gainScore();
            }
        }
    }


    void repeatGame(List<Car> carList) {
        int turn = userInput.getTurn();
        Print print = new Print();
        List<Boolean> carCanGo = randomGo(carList);

        for (int i = 0; i < turn; i++) {
            applyScore(carList, carCanGo);
            print.Score(carList);
        }
    }

    List<String> getWinner(List<Car> carList){
        List<String> winnerName = new ArrayList<>();
        int max = 0;
        for (Car car : carList) {
            if (max < car.score) {
                max = car.score;
            }
        }

        for (Car car : carList) {
            if (car.score == max) {
                winnerName.add(car.name);
            }
        }
        return winnerName;
    }
}
