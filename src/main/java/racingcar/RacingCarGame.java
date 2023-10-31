package racingcar;

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
            System.out.println(carList);
            numberOfRace--;
        }
    }

    private void carRace(List<Car> carList) {
        for (Car car : carList) {
            car.race();
        }
    }

    public void decideWinner(List<Car> carList, List<Car> winnerList) {
        int countRepeat = 0;
        while (countRepeat < carList.size() - 1) {
            countRepeat = compareDistance(carList, winnerList, countRepeat);
        }
    }

    private int compareDistance(List<Car> carList, List<Car> winner, int i) {
        if (winner.get(0).getDistance().length() < carList.get(i + 1).getDistance().length()) {
            winner.clear();
            winner.add(carList.get(i + 1));
        } else if (winner.get(0).getDistance().length() == carList.get(i + 1).getDistance().length()) {
            winner.add(carList.get(i + 1));
        }
        i++;
        return i;
    }

    public void printOutWinner(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        Iterator<Car> it = winner.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getName());
            hasNext(sb, it);
        }
        System.out.print(sb);
    }

    private void hasNext(StringBuilder sb, Iterator<Car> it) {
        if (it.hasNext()) {
            sb.append(", ");
        }
    }
}
