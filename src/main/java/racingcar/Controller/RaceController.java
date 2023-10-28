package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;
import racingcar.View.ConsolePrint;

public class RaceController {

    private List<Car> carList = new ArrayList<Car>();

    public void start() {
        String[] names = ConsolePrint.readCars().split(",");
        for (String name : names) {
            carList.add(new Car(name));
        }
        System.out.println(carList);
        int tryNum = Integer.parseInt(ConsolePrint.readTryNum());


    }


}
