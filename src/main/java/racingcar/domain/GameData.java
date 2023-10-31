package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameData {

    private Integer repetitionNumber;
    private List<String> winnerList;
    private List<Car> carList;



    public List<String> getWinnerList() {
        return winnerList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void createCarList(int carNumber) {
        this.carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }
    }

    public void setCarsName(String[] carNamesArray, List<Car> carListTemp) {

        for (int i = 0; i < carNamesArray.length; i++) {
            Car car = carListTemp.get(i);
            car.setName(carNamesArray[i]);
        }
    }

    public Integer getRepetitionNumber() {
        return repetitionNumber;
    }

    public String getRepetitionNumberInput() {
        String repetitionNumberInput = Console.readLine();
        System.out.println();
        return repetitionNumberInput;
    }

    public void changeRepetitionNumberType(String repetitionNumberInput) {
        this.repetitionNumber = Integer.parseInt(repetitionNumberInput);
    }

    public void sortCarListByRank(List<Car> carList) {
        Comparator<Car> comparator = new Comparator<>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getSuccessMoveForwardCount() - o1.getSuccessMoveForwardCount();
            }
        };

        carList.sort(comparator);
    }

    public void pickWinners(List<String> winnerList, List<Car> carList) {

        Car car1st = carList.get(0);
        Integer moveForwardCount1st = car1st.getSuccessMoveForwardCount();

        for (Car car : carList) {
            Integer successMoveForwardCount = car.getSuccessMoveForwardCount();
            if (successMoveForwardCount.equals(moveForwardCount1st)) {

                winnerList.add(car.getName());
            }
        }
    }

    public void createWinnerList() {
        this.winnerList = new ArrayList<>();
    }
}
