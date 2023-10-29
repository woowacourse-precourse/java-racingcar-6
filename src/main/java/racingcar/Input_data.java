package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class Input_data {
    public static void input_cars(ArrayList<String> name) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_str = Console.readLine();
        String[] str_array = input_str.split(",");     
        
        for (String str: str_array) {
            System.out.println(str);
            if(str.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 제대로 입력하세요.");
            }
            name.add(str);
        }
    }
}
