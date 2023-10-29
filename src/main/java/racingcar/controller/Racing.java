package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.service.InputRacingCar;
import racingcar.service.InputTryCount;
import racingcar.view.PrintMessage;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class Racing {

    private RacingCars racingCars;
    private int tryCount;

    public void startRacing() {
        setRacingCar();
        setTryRound();
        setRacing();
    }

    public void setRacingCar() {
        PrintMessage.printStart();
        racingCars = InputRacingCar.setInputRacingCars();
    }

    public void setTryRound() {
        PrintMessage.printTryCount();
        tryCount= InputTryCount.setInputTryCount();
    }

    public void setRacing(){
        for (int i=0;i<tryCount;i++){
            goRacing();
        }
    }

    public void goRacing(){
        List<RacingCar> racingCarList=racingCars.getRacingCars();
        for (RacingCar racingCar:racingCarList){
            int randomNum=makeRandomNumber();
            isPlusDistance(randomNum,racingCar);
        }
    }

    public int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void isPlusDistance(int randomNum, RacingCar racingCar){
        if(randomNum>=4){
            int distance= racingCar.getDistance();
            racingCar.setForwardDistance(distance+1);
        }
    }
}
