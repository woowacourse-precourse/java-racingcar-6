package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class RacingLogic {

    public static void goRacing(RacingCars racingCars){
        List<RacingCar> racingCarList=racingCars.getRacingCars();
        for (RacingCar racingCar:racingCarList){
            int randomNum=makeRandomNumber();
            isPlusDistance(randomNum,racingCar);
        }
    }

    public static int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static void isPlusDistance(int randomNum, RacingCar racingCar){
        if(randomNum>=4){
            int distance= racingCar.getDistance();
            racingCar.setForwardDistance(distance+1);
        }
    }
}
