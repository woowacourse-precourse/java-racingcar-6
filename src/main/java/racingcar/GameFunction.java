package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameFunction {

    UserInput userInput = new UserInput();

    List<String> SplitCarName(String input){

        List<String> carNameList = List.of(input.split(","));
        List<String> trimmedCarNames = trimCarName(carNameList);

        return trimmedCarNames;
    }

    List<String> trimCarName(List<String> carNameList) {
        ValueCheck valueCheck = new ValueCheck();
        List<String> trimmedCarNames = new ArrayList<>();

        for (String car : carNameList) {
            String trimmedCar = car.trim();
            valueCheck.sizeUnderFive(carNameList);
            trimmedCarNames.add(trimmedCar);
        }
        return trimmedCarNames;
    }


    List<Car> makingCar() {
        String Input = userInput.getCarNames();
        List<String> carNameList = SplitCarName(Input);

        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    List<Integer> generateRandomNumber(Integer numberOfCar){
        List<Integer> NumberList = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            NumberList.add(number);
        }
        return NumberList;

    }

    List<Boolean> randomGo(List<Car> carList) {
        int numberOfCar = carList.size();
        List<Integer> randomNumber = generateRandomNumber(numberOfCar);
        List<Boolean> carCanGo = new ArrayList<>();

        for (int number : randomNumber) {
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
        Print print = new Print();
        int turn = userInput.getTurn();

        System.out.println();
        System.out.println(print.resultComment);

        for (int i = 0; i < turn; i++) {
            List<Boolean> carCanGo = randomGo(carList);
            applyScore(carList, carCanGo);
            print.Score(carList);
        }
    }

    List<String> getWinner(List<Car> carList) {
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
