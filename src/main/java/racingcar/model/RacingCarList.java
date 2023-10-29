package racingcar.model;
import java.util.ArrayList;
import java.util.List;

import static racingcar.validator.InputValidation.*;
public class RacingCarList {    // 경주 자동차의 속성을가진 객체
    private static String SEPREATE_CHAR = ",";
    private List<RacingCar> car;
    public RacingCarList(String inputs){
        splitByComma(inputs);
    }
    private void splitByComma(String inputs){
        car = new ArrayList<>();
        String[] names = inputs.split(SEPREATE_CHAR);
        for (String name:names){
            validNameFormat(name);
            validNameLength(name);
            this.car.add(new RacingCar(name));
        }
    }
    public int size(){
        return this.car.size();
    }
    public RacingCar getCar(int index){
        return this.car.get(index);
    }
}
