package racingcar;

import static racingcar.OutputView.showStatusOfCar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.List;

public class RacingCarGame {
    public RacingCarGame() {
    }

    public String getCarsName() {
        return Console.readLine();
    }

    public String[] extractCarName(String carsName) {
        return carsName.split(",");
    }

    public void generateCarList(String[] carName, CustomArrayList<Car> carList) {
        int repeatNumber = carName.length;
        int nameOrder = 0;
        addCarsToCarList(carName, carList, repeatNumber, nameOrder);
    }

    private void addCarsToCarList(String[] carName,
                                  CustomArrayList<Car> carList,
                                  int repeatNumber,
                                  int nameOrder) {
        while (repeatNumber != 0) {
            carList.add(new Car(carName[nameOrder]));
            repeatNumber--;
            nameOrder++;
        }
    }

    public int getNumberOfRace() {
        return Integer.parseInt(Console.readLine());
    }

    public void repeatCarRace(List<Car> carList, int numberOfRace) {
        while (numberOfRace != 0) {
            carRace(carList);
            showStatusOfCar(carList);
            numberOfRace--;
        }
    }

    private void carRace(List<Car> carList) {
        for (Car car : carList) {
            car.race();
        }
    }

    public void initializeWinnerList(List<Car> carList, List<Car> winnerList) {
        winnerList.add(carList.get(0));
    }

    public void decideWinner(List<Car> carList, List<Car> winnerList) {
        int countOfRepeat = 0;
        while (countOfRepeat < carList.size() - 1) {
            replaceOrAddWinner(countOfRepeat, carList, winnerList);
            countOfRepeat++;
        }
    }

    private void replaceOrAddWinner(int countOfRepeat, List<Car> carList, List<Car> winnerList) {
        int baseDistance = winnerList.get(0).getDistance().length();
        replaceWinner(countOfRepeat, carList, winnerList, baseDistance);
        addWinner(countOfRepeat, carList, winnerList, baseDistance);
    }

    private void replaceWinner(int countOfRepeat, List<Car> carList, List<Car> winnerList, int baseDistance) {
        if (baseDistance < carList.get(countOfRepeat + 1).getDistance().length()) {
            winnerList.clear();
            winnerList.add(carList.get(countOfRepeat + 1));
        }
    }

    private void addWinner(int index, List<Car> carList, List<Car> winnerList, int distance) {
        if (distance == carList.get(index + 1).getDistance().length()) {
            winnerList.add(carList.get(index + 1));
        }
    }

    public StringBuilder printOutWinner(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        Iterator<Car> it = winner.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getName());
            hasNext(sb, it);
        }
        return sb;
    }

    private void hasNext(StringBuilder sb, Iterator<Car> it) {
        if (it.hasNext()) {
            sb.append(", ");
        }
    }
}
