package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
            input_car_name();
        } catch (IllegalArgumentException e){
            throw e;
        }
    }
    public static String[] input_car_name(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_name = Console.readLine();
        String[] names = input_name.split(",");

        List<String> car_name_list = new ArrayList<>();
        for (String name : names) {
            String trimmed_name = name.trim();
            if (trimmed_name.isEmpty() || trimmed_name.length() >=6) {
                throw new IllegalArgumentException();
            }
            car_name_list.add(trimmed_name);
        }
        return car_name_list.toArray(new String[0]);
    }



}
