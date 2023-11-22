package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static racingcar.View.RequestMessage.requestInputCarsName;

public class CarsService {

    List<String> CarsName = new ArrayList<String>();

    public void setCarsName(){
        getCarsName();
    }
    private void getCarsName(){
        inputCarsName();
    }
    private void inputCarsName(){
        requestInputCarsName();
        String CarsName = Console.readLine();
        checkCarsName(CarsName);
    }

}
