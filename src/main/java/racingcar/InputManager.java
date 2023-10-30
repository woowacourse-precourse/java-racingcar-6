package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    static List<RacingCar> get_input_car_names(){
        String input_str = Console.readLine();
        return makeRacingCars(input_str);
    }

    static int get_input_play_num(){
        String input_num = Console.readLine();
        return string_to_int(input_num);
    }

    private static int string_to_int(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 문자열이 유효한 정수가 아닙니다: " + inputNum);
        }
    }

    static List<RacingCar> makeRacingCars(String inputStr) {
        String[] split_str = inputStr.split(",");
        List<RacingCar> cars = new ArrayList<RacingCar>();
        for(int i=0;i<split_str.length;i++){
            cars.add(new RacingCar(split_str[i]));
        }
        return cars;
    }
}
