package racingcar;

import java.util.ArrayList;
import java.util.List;

public class StopAndGo {

    InputRacingCar racingCar = new InputRacingCar();
    InputRacingNumber racingNumber = new InputRacingNumber();

    void stopAndGo(){
        List<String> racingCarList = racingCar.inputRacingCar();
        int racingCarSize = racingCarList.size();
        List<Integer> racingCarScore = new ArrayList<>();

        for(int i = 0; i<racingCarSize; i++){
            racingCarScore.add(0);
        }

    }
}