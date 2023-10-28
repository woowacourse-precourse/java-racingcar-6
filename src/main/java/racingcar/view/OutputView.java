package racingcar.view;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    final static String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static String NUMBER_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    final static String RESULT_INFO_MESSAGE = "실행 결과";
    final static String RESULT_MESSAGE = "최종 우승자 : %s, %s";

    public void carNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void numberInputMessage() {
        System.out.println(NUMBER_INPUT_MESSAGE);
    }


    //매개 변수 없애고 DTO 클래스 만드는 것이 더 좋음 수정필요
    public void carsStatus(Map<String, Integer> cars) {
        cars.keySet().forEach(key -> {
            int intValue = cars.get(key);
            String dash = intToDash(intValue);
            System.out.println(key + " : " + dash);
        });
    }

    public String intToDash(int intValue) {
        return IntStream.range(0, intValue)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

}
