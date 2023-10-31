package racingcar.model;

import static racingcar.constant.AllPunctuationMarks.COMMA;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.controller.Validation;

public class Car { // 자동차 관련 클래스

    private static final int INITIAL_MOVE_COUNT = 0;
    private final Validation validation;

    public Car() {
        this.validation = new Validation();
    }

    // 경주 참가 자동차 명단을 Map 형식으로 생성(key: 자동차 이름, value: 전진 거리)
    // 입력된 순서 그대로 Map에 저장되어야 하므로 저장된 순서를 유지하는 LinkedHashMap 사용
    public Map<String, Integer> createCarNameList(String input) {
        Map<String, Integer> carNameList = new LinkedHashMap<>();
        validation.checkNameInputCommaOrSpace(input);
        for (String carName : input.split(COMMA)) {
            validation.checkNameTokenLengthOver(carName);
            validation.checkNameTokenDuplicated(carName, carNameList);
            carNameList.put(carName, INITIAL_MOVE_COUNT);
        }
        return carNameList;
    }
}
