package racingcar.Service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.Util.Converter;
import racingcar.View.TextInterface;

public class CarService {
    private TextInterface textInterface = new TextInterface();
    private Converter converter = new Converter();
    private List<Car> car = new ArrayList<>();

    public void set(){
        String userInput = textInterface.enterPlayer();
        List<String> carList = converter.StringToList(userInput);
        for(String carName: carList){
            car.add(new Car(carName));
        }
    }
}
