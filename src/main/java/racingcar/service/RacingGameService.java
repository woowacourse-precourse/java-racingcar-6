package racingcar.service;

import racingcar.domain.RacingCarGame;

public class RacingGameService {

    public RacingGameService() {

    }

    public void race(String carNames, String tryNum) {
        
        System.out.println();
        System.out.println("실행 결과");

        RacingCarGame racingCarGame = RacingCarGame.create(carNames, tryNum);
        racingCarGame.play();

        System.out.println("최종 우승자 : " + racingCarGame.getResult());
    }

}
