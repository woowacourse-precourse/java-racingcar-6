package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static String NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    final static String RESULT_INFO_MESSAGE = "실행 결과";
    final static String RESULT_MESSAGE = "최종 우승자 : ";

    public void carNameMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void resultInfoMessage() {
        System.out.println(RESULT_INFO_MESSAGE);
    }

    public void numberMessage() {
        System.out.println(NUMBER_INPUT_MESSAGE);
    }

    public void carsStatus(Map<String, Integer> cars) {
        cars.keySet().forEach(key -> {
            int intValue = cars.get(key);
            String dash = intToDash(intValue);
            System.out.println(key + " : " + dash);
        });
        System.out.println("");
    }

    public String intToDash(int intValue) {
        return IntStream.range(0, intValue)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public void winnerMessage(List<String> a) {
        String result = a.stream()
                .collect(Collectors.joining(", "));
        System.out.println(RESULT_MESSAGE+result);
    }
}
