package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public void play() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_str = Console.readLine();
        makeRacingCars(input_str);
    }

    private List<RacingCar> makeRacingCars(String inputStr) {
        String[] split_str = inputStr.split(",");
        List<RacingCar> cars = new ArrayList<RacingCar>();
        for(int i=0;i<split_str.length;i++){
            cars.add(new RacingCar(split_str[i]));
        }
        return cars;
    }
}
