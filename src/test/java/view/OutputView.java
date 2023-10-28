package view;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    final static String NUMBER_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public String numberInputMessage() {
        return NUMBER_INPUT_MESSAGE;
    }

    public void carStatus(Map<String, Integer> cars) {
        cars.keySet().forEach(key -> {
            int intValue = cars.get(key);
            String dash = intTodash(intValue);
            System.out.println(key + " : " + dash);
        });
    }

    public String intTodash(int intValue) {
        return IntStream.range(0, intValue)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

}
