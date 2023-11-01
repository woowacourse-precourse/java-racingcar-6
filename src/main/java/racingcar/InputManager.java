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
        System.out.println("시도할 회수는 몇회인가요?");
        String input_num = Console.readLine();
        int result = string_to_int(input_num);
        if(result==-1)
            throw new IllegalArgumentException("입력된 문자열이 유효한 정수가 아닙니다: " + input_num);
        return result;
    }

    static int string_to_int(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static List<RacingCar> makeRacingCars(String inputStr) {
        String[] split_str = inputStr.split(",");
        System.out.println(split_str[0]);
        List<RacingCar> cars = new ArrayList<>();
        for(int i=0;i<split_str.length;i++){
            cars.add(new RacingCar(split_str[i]));
        }
        return cars;
    }
}
