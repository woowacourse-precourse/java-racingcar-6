package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Winner {
    public void PrintWinner(Car[] cars){
        String winner = "";
        int maxPosition = 0;
        for(Car car: cars) {
            if (maxPosition == car.ReturnMove()) {
                winner += car.ReturnCarName();
                maxPosition += car.ReturnMove();
            } else if (maxPosition < car.ReturnMove()) {
                winner = car.ReturnCarName();
                maxPosition = car.ReturnMove();
            }
        }
        System.out.println("우승자 : " + winner);
    }
}


