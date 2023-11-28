package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Message;
import racingcar.Util.CheckNameException;

public class InputCarsNameService {
    
    public String[] inputStringCarsName() {
        System.out.println(Message.INPUT_CARS_NAME);
        return InputString();
    }
    
    private String[] InputString() {
        String CarsName = Console.readLine();
        CheckNameException.carsNameExceptionCheck(CarsName);
        return splitCarsNameByDelimiter(CarsName);
    }
    
    private String[] splitCarsNameByDelimiter(String CarsName){
        return CarsName.split(",");
    }
}
