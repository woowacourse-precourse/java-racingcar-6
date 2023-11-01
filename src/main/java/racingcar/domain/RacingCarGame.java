package racingcar.domain;

import static racingcar.util.OutputView.showNameOfWinner;
import static racingcar.util.OutputView.showStatusOfCar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Iterator;
import java.util.List;
import racingcar.customCollection.CustomArrayList;
import racingcar.exception.ExceptionManager;

public class RacingCarGame {

    ExceptionManager exceptionManager = new ExceptionManager();

    public RacingCarGame() {
    }

    public String readNamesOfCars() {
        String namesOfCars = Console.readLine();
        exceptionManager.checkCarsNameException(namesOfCars);
        return namesOfCars;
    }

    public String[] splitNamesOfCars(String namesOfCars) {
        String[] arrayOfCarName = namesOfCars.split("\\s*,\\s*");
        exceptionManager.checkCarNameException(arrayOfCarName);
        return arrayOfCarName;
    }

    public void generateCarList(String[] arrayOfCarName, CustomArrayList<Car> carList) {
        int countOfRepeat = arrayOfCarName.length;
        int indexOfArrayOfCarName = 0;
        while (countOfRepeat != 0) {
            carList.add(new Car(arrayOfCarName[indexOfArrayOfCarName]));
            countOfRepeat--;
            indexOfArrayOfCarName++;
        }
    }

    public int readNumberOfRace() {
        String numberOfRace = Console.readLine();
        exceptionManager.checkNumberOfRace(numberOfRace);
        return Integer.parseInt(numberOfRace);
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

    public void judgeWinner(List<Car> carList, List<Car> winnerList) {
        int baseDistance = winnerList.get(0).getDistance().length();
        int countOfComparison = 0;
        while (countOfComparison < carList.size() - 1) {
            replaceWinnerList(baseDistance, countOfComparison, carList, winnerList);
            addWinnerList(baseDistance, countOfComparison, carList, winnerList);
            countOfComparison++;
        }
    }

    private void replaceWinnerList(int baseDistance, int indexOfCarList, List<Car> carList, List<Car> winnerList) {
        if (baseDistance < carList.get(indexOfCarList + 1).getDistance().length()) {
            winnerList.clear();
            winnerList.add(carList.get(indexOfCarList + 1));
        }
    }

    private void addWinnerList(int baseDistance, int indexOfCarList, List<Car> carList, List<Car> winnerList) {
        if (baseDistance == carList.get(indexOfCarList + 1).getDistance().length()) {
            winnerList.add(carList.get(indexOfCarList + 1));
        }
    }

    public void printOutWinner(List<Car> winnerList) {
        StringBuilder stringOfWinners = new StringBuilder();
        Iterator<Car> it = winnerList.iterator();
        appendNameOfWinner(stringOfWinners, it);
        showNameOfWinner(stringOfWinners);
    }

    private void appendNameOfWinner(StringBuilder stringOfWinners, Iterator<Car> it) {
        while (it.hasNext()) {
            stringOfWinners.append(it.next().getName());
            appendCommaBeforeNextName(stringOfWinners, it);
        }
    }

    private void appendCommaBeforeNextName(StringBuilder sb, Iterator<Car> it) {
        if (it.hasNext()) {
            sb.append(", ");
        }
    }
}
