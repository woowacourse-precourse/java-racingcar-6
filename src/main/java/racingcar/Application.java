package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Service service = new Service();
        ArrayList<Car> carList = service.createCarImpl();
        service.resultPrint(carList);
        service.findWinner(carList);
    }
}
