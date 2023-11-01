package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarFactory {
    RacingCar createCart(String name){
        return new RacingCar(name);
    }
}
