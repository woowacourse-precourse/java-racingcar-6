package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Game;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private final PrintView printView = new PrintView();
    private final List<String> winnerList = new ArrayList<String>();

    public void setForwordOrStay(User playUser) {
        Car[] carList = playUser.getCarList();
        for (int i = 0; i < carList.length; i++) {
            if (setRandNum() >= 4) {
                carList[i].addForwardCount();
            }
        }
    }

    public void printProgress(User playUser) {
        printView.printProgress(playUser.getCarList());
    }

    public void compareWinner(User playUser) {
        Car[] carList = playUser.getCarList();
        int max_num = 0;
        for (Car eachCar : carList) {
            if (eachCar.getForwardCount() > max_num) {
                winnerList.clear();
                winnerList.add(eachCar.getCarName());
                max_num = eachCar.getForwardCount();
            }
            else if(eachCar.getForwardCount() == max_num){
                winnerList.add(eachCar.getCarName());
            }
        }
        printView.printWinner(winnerList);
    }

    public int setRandNum() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}