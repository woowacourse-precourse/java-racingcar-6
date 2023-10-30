package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MakeCars {
    public List<Racingcar> makeCars(){
        List<Racingcar> cars = new ArrayList<>();
        MakeNames makeNames = new MakeNames();
        IntegrityCheck integrityCheck = new IntegrityCheck();
        List<String> names;

        names = makeNames.makeNames();
        for (int i = 0; i < 3; i++){
            if (!integrityCheck.nameIntegrityCheck(names.get(i))){
                throw new IllegalArgumentException();
            }
            cars.add(new Racingcar(names.get(i)));
        }
        return cars;
    }
}
