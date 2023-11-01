package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carList = new ArrayList<>();
        carList = GameStart.start();
        System.out.println(carList);
    }
}
