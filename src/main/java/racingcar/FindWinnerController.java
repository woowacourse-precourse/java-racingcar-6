package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.Comparator;

import static racingcar.InputController.carNamesArray;
import static racingcar.InputController.carArrList;
import static racingcar.InputController.cycleNum;

public class FindWinnerController {
    public static int winnerDistance;

    public FindWinnerController() {
        winnerDistance= 0;
    }
    public void stopOrGo(int index) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            changeDistance(index);
        }
    }

    public void changeDistance(int index) {
        int presentDistance =carArrList.get(index).getDistance();
        for (String carName :carNamesArray) {
            carArrList.get(index).setDistance(presentDistance + 1);
        }
    }

    public void oneCycle() {
        int index = 0;
        PrintController printController = new PrintController();
        for (String name :carNamesArray) {
            stopOrGo(index);
            printController.printResult(index);
            index++;
        }
        System.out.println("");
    }
    public void totalCycle() {
        for (int i = 0; i <cycleNum; i++) {
            oneCycle();
        }
    }

    void findWinner() {
        Collections.sort(carArrList, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car2.getDistance() - car1.getDistance();
            }
        });
        winnerDistance=carArrList.get(0).getDistance();
    }
}
