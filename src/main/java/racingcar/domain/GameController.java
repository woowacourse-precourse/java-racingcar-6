package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameController {

    private Integer TryMoveForwardRandomNumber;
    private List<Car> carList;

    public Integer getTryMoveForwardRandomNumber() {
        return TryMoveForwardRandomNumber;
    }

    public void setTryMoveForwardRandomNumber(Integer tryMoveForwardRandomNumber) {
        TryMoveForwardRandomNumber = tryMoveForwardRandomNumber;
    }

    public String getCarNames() {

        return Console.readLine();
    }

    public void splitCarNameInput(String[] carNamesArray, List<Car> carList) {

        for (int carIndex = 0; carIndex < carNamesArray.length; carIndex++) {
            Car car = carList.get(carIndex);
            car.setName(carNamesArray[carIndex]);
            System.out.println("car.getName() = " + car.getName());
        }
    }

    public void verifyMoveForward() {
    }

    public void setWinnerList(List<Car> winnerList) {


    }
}
