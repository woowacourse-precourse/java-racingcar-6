package racingcar.domain;

import java.util.List;

public class RoundManager {

    public boolean shouldCarMove(){
        int randomValue = RandomNumberGenerator.randomNumGenerate();
        return randomValue >=4;
    }
}
