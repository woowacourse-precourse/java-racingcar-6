package racingcar.Service;

import racingcar.Model.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    
    InputCarsNameService InputCarsName = new InputCarsNameService();
    InputTryNumberService InputTryNumber = new InputTryNumberService();
    
    public List<String> inputCarsName(){
        ArrayList<String> carsName = new ArrayList<>();
        Collections.addAll(carsName, InputCarsName.inputStringCarsName());
        return carsName;
    }
    
    public int inputTryNumber(){
        System.out.println(Message.INPUT_TRY_NUMBER);
        return InputTryNumber.input();
    }
}
