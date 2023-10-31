package racingcar.controller;

import racingcar.domain.RacingCar;

public class RaceController {

    private RacingCar car;
    private static final int round = 0;

    public String[] ready(String input) {

        // 입력에 콤마가 없을 경우 (최소 2대의 자동차 입력)
        if(!input.contains(","))
            throw new IllegalArgumentException("최소 2대의 자동차가 필요합니다.");

        // 콤마 앞이나 뒤에 자동차 이름이 없는 경우 (문자열이 콤마로 시작하거나 끝나는 경우)
        if(input.startsWith(",") || input.endsWith(","))
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");

        String[] racingCarList = input.split(",");

        for(String car : racingCarList) {
            // 콤마 사이에 자동차 이름이 없을 경우
            if(car.isEmpty())
                throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");

            // 자동차 이름이 길이 제한(1~5자)을 벗어났을 경우
        }

        return racingCarList;
    }
}
