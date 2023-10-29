package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Cars {
    List<String> cars = new ArrayList<>();
    public List<String> inputCars() {
        String carInput = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(carInput, ",");

        while (stringTokenizer.hasMoreTokens()) {
            cars.add(stringTokenizer.nextToken());
        }
        return cars;
    }

}
