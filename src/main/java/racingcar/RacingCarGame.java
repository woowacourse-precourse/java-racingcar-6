package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<RacingCar> racingCars = InputManager.get_input_car_names();
        int play_num = InputManager.get_input_play_num();

        System.out.println("실행 결과");

        for(int i=0;i<play_num;i++){
            move(racingCars);
            printCarsCount(racingCars);
            System.out.println();
        }
    }

    private void printCarsCount(List<RacingCar> racingCars) {
        for(int i=0;i<racingCars.size();i++){
            racingCars.get(i).printNowCount();
        }
    }

    public void move(List<RacingCar> cars){
        for(int i=0;i<cars.size();i++){
            cars.get(i).move();
        }
    }

}
