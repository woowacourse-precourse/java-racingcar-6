package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;

public class RaceController {

    private RacingCar car;
    private static final int round = 0;

    public String[] ready(String input) {
        String[] racingCars = input.split(",");

        // 예외 처리 필요한 부분 정리
        // 1. 입력에 콤마가 없을 경우 (최소 2대의 자동차 입력)
        // 2. 두 개의 콤마 사이에 자동차 이름이 없을 경우
        // 3. 가장 처음(혹은 끝) 콤마 (혹은 뒤)에 자동차 이름이 없을 경우
        // 4. 자동차 이름이 길이 제한(1~5자)을 벗어났을 경우

        return racingCars;
    }
}
