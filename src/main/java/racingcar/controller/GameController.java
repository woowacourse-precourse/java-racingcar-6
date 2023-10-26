package racingcar.controller;

import racingcar.view.InputView;

public class GameController {

    public static void start(){

        int attempts = Integer.parseInt(InputView.attempts());

        while(attempts!=0){
            // 게임 시도

            // 시도 횟수 감소
            attempts--;
        }
    }
}
