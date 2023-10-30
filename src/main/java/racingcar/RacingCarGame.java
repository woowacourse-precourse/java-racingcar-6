package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<RacingCar> racingCars = InputManager.get_input_car_names();
        int play_num = InputManager.get_input_play_num();

        for(int i=0;i<play_num;i++){
            move(racingCars);
        }
    }

    public void move(List<RacingCar> cars){

    }

}
