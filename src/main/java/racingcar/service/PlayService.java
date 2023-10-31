package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.ValidUtil;


public class PlayService {
    private ValidUtil util = new ValidUtil();

    public int transFromTryNumForInt(String tryNumSTR){
        int tryNum = 0;
        if(util.checkTryNumber(tryNumSTR)){
            tryNum = Integer.parseInt(tryNumSTR);
        }
        return tryNum;
    }

    public void playTurn(Race race) {
        for(Car car: race.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (isFourOrMore(randomNumber)) {
                car.upPoint();
            }
        }
    }

    public boolean isFourOrMore(int number){
        if(number >= 4){
            return true;
        }
        return false;
    }



}
