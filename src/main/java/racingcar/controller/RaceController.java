package racingcar.controller;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    private int round = 0;

    public void setRound(int round) {
        if(round < 1)
            throw new IllegalArgumentException("올바르지 않은 시도 회수입니다.");
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public List<RacingCar> ready(String input) {

        List<RacingCar> racingCarList = new ArrayList<>();

        // 입력에 콤마가 없을 경우 (최소 2대의 자동차 입력)
        if(!input.contains(","))
            throw new IllegalArgumentException("최소 2대의 자동차가 필요합니다.");

        // 콤마 앞이나 뒤에 자동차 이름이 없는 경우 (문자열이 콤마로 시작하거나 끝나는 경우)
        if(input.startsWith(",") || input.endsWith(","))
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");

        String[] carNameList = input.split(",");

        for(String carName : carNameList) {
            if(carName.isEmpty())  // 콤마 사이에 자동차 이름이 없을 경우
                throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");

            if(carName.length() > 5)  // 자동차 이름이 길이 제한(1~5자)을 벗어났을 경우
                throw new IllegalArgumentException("자동차 이름 길이 제한(1~5자)을 벗어났습니다.");

            racingCarList.add(new RacingCar(carName));
        }

        return racingCarList;
    }

    public void start(List<RacingCar> racingCarList) {
        for(int i = 1; i <= round; i++)
          playRace(racingCarList);
    }

    public void playRace(List<RacingCar> racingCarList) {
        for(RacingCar car : racingCarList)
          car.move();
    }
}
