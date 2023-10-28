package view;

import java.util.Map;

public class OutputView {

    final static String NUMBER_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public String numberInputMessage() {
        return NUMBER_INPUT_MESSAGE;
    }

    public void carStatus(Map<String, Integer> cars) {
        cars.keySet().forEach(key -> {
            int intValue = cars.get(key);
            System.out.println(key + " : " + intValue);
        });
    }

}
