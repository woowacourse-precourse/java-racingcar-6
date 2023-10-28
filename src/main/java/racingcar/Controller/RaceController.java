package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
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

    void move() {
        for (Car car : carList) {
            if (3 < Randoms.pickNumberInRange(0, 9)) {
                car.incrementDistance();
            }
        }


}
