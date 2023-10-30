package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            Race.againRacingByRandomNumber();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
