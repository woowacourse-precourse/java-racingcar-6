package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.service.InputRacingCar;
import racingcar.service.InputTryCount;
import racingcar.service.RacingLogic;
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
            RacingLogic.goRacing(racingCars);
        }
    }



}
