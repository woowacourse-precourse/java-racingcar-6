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
            input_repeat_count();
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
            check_name_validation(trimmed_name);
            car_name_list.add(trimmed_name);
        }
        return car_name_list.toArray(new String[0]);
    }

    public static void check_name_validation(String name){
        if (name.isEmpty() || name.length() >=6) {
            throw new IllegalArgumentException();
        }
    }

    public static int input_repeat_count(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input_count = Console.readLine();

        try {
            int counts = Integer.parseInt(input_count);
            check_count(counts);
            return counts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void check_count(int counts) {
        if (counts <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
