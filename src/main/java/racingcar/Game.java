package racingcar;

import racingcar.utils.Random;
import racingcar.Game;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private final List<String> winnerList = new ArrayList<String>();

    public void setForwordOrStay(User playUser) {
        Car[] carList = playUser.getCarList();
        for (int i = 0; i < carList.length; i++) {
            if (Random.setRandNum() >= Config.FORWARD_RANGE_NUM) {
                carList[i].addForwardCount();
            }
        }
    }

    public void printProgress(User playUser) {
        PrintView.printRaceProgress(playUser.getCarList());
    }

    public void determineRaceWinner(User playUser) {
        Car[] carList = playUser.getCarList();
        int maximumCompareValue = 0;
        for (Car eachCar : carList) {
            if (eachCar.getForwardCount() > maximumCompareValue) {
                winnerList.clear();
                winnerList.add(eachCar.getCarName());
                maximumCompareValue = eachCar.getForwardCount();
            }
            else if(eachCar.getForwardCount() == maximumCompareValue){
                winnerList.add(eachCar.getCarName());
            }
        }
        PrintView.printRaceWinner(winnerList);
    }

    
}