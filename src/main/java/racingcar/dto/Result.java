package racingcar.dto;

import racingcar.constant.message.Message;
import racingcar.model.car.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private final Map<String, Integer> result;

    private Result(Map<String, Integer> result) {
        this.result = result;
    }

    public static Result of(List<Car> cars) {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            result.put(car.getName(), car.getCurrentPosition());
        }
        return new Result(result);
    }

    public String toIntermediateResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : result.keySet()) {
            stringBuilder.append(String.format(Message.RESULT_FORMAT, name, Message.MARK.repeat(result.get(name))));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public String toFinalWinner() {
        return String.format(Message.FINAL_WINNER, String.join(Message.NAME_SEPARATOR + " ", result.keySet()));
    }
}
