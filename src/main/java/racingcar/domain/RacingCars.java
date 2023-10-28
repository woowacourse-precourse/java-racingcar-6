package racingcar.domain;
import java.util.List;
import racingcar.domain.RacingCar;
import java.util.ArrayList;
public class RacingCars {
    List<RacingCar> racingcars;
    RacingCars(){
        racingcars  = new ArrayList<>();
    }

    public void add(RacingCar racingcar){
        racingcars.add(racingcar);
    }


}
