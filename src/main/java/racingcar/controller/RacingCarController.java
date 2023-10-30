package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.service.RacingCarService;
import racingcar.util.GlobalExceptionHandler;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.max;

public class RacingCarController {

    private final static GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
    private final static RacingCarView racingCarView = new RacingCarView();
    private final static RacingCarService racingCarService = new RacingCarService();

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean goFront() {
        int randomNumber = getRandomNumber();
        if (randomNumber>=4) {
            return true;
        }
        return false;
    }

    public void startRacingCar(){

        String cars = racingCarView.inputStartRacingCar();
        List<Car> racingCarList = racingCarService.getRacingCarsList(cars);

        String racingCarCount = racingCarView.inputRacingCarTryCount();
        final Racing racingGame = racingCarService.startRace(racingCarCount, racingCarList);

        // 전진 횟수 카운트
        for (int i=0; i<racingGame.getRacingCount(); i++){
            for (Car car:racingGame.getRacingCarList()){
                if (goFront()) {
                    car.updateAheadCount();
                }
                // 경주 각 차수별 실행 결과 출력
                System.out.println(car.getName()+" : "+"-".repeat(car.getAheadCount()));
            }
            System.out.println("");
        }

        // 경기가 끝나면 최종 우승자 저장 및 출력
        final HashMap<String, Integer> goAheadCountList = new HashMap<>();

        for (Car car:racingGame.getRacingCarList()){
            goAheadCountList.put(car.getName(), car.getAheadCount());
        }

        goAheadCountList.forEach((key, value) -> {
            if (value == max(goAheadCountList.values())) {
                racingGame.updateWinnerList(key);
            }
        });

        String winners = String.join(", ", racingGame.getWinnerList());

        System.out.println("최종 우승자 : "+winners);
    }
}
