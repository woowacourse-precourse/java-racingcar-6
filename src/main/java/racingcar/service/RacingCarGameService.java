package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class RacingCarGameService {

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void fowardCars(List<Car> cars){
        for (int i=0;i<cars.size();++i){
            int number = generateRandomNumber();
            int originStep = cars.get(i).getStep();
            if(number>=4) cars.get(i).setStep(originStep+1);
        }
    }

}
