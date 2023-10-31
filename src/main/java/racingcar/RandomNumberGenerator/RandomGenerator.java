package racingcar.RandomNumberGenerator;

import camp.nextstep.edu.missionutils.*;


public class RandomGenerator implements GetRandomNumber{
    @Override
    public int GeneratorRandomNumber(){
        return Randoms.pickNumberInRange(1,9);

    }

}
