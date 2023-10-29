package racingcar.ui.output;

import racingcar.ui.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OutputProcessor {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult() {
        System.out.println(Message.RESULT.getMessage());
    }

    public void printResult(HashMap<String, Integer> carList) {
        carList.forEach((carName, forwardNumber) ->
                System.out.println(carName + " : " + "-".repeat(forwardNumber)));
        System.out.println();
    }

    public void printFinalWinner(HashMap<String, Integer> carList) {
        System.out.print(Message.FINAL_WINNER.getMessage());
        Optional<Integer> maxValue = carList.values().stream().max(Integer::compareTo);
        String result = carList.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxValue.orElse(null)))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }

}
