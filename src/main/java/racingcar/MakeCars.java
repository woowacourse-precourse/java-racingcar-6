package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MakeCars {
    public List<Racingcar> makeCars(){
        List<Racingcar> cars = new ArrayList<>();
        MakeNames makeNames = new MakeNames();
        IntegrityCheck integrityCheck = new IntegrityCheck();
        List<String> names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        names = makeNames.makeNames();
        for (int i = 0; i < names.size(); i++){
            if (integrityCheck.nameIntegrityCheck(names.get(i))){
                throw new IllegalArgumentException();
            }
            cars.add(new Racingcar(names.get(i)));
        }
        return cars;
    }
}
