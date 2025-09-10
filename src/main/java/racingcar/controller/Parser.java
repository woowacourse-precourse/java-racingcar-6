package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.view.CarListRequest;

public class Parser {

    public CarListRequest parseCarListRequest(String line) {
        String[] carNames = line.split(",");
        List<String> list = Arrays.stream(carNames).toList();

        return new CarListRequest(list);
    }

    public Integer parseNumberOfAttempts(String clientMessage) {
        return Integer.valueOf(clientMessage);
    }
}
