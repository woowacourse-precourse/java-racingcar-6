package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        play_racing_game();
    }

    public static void play_racing_game() {
        String[] car_name_list = input_car_name();
        int repeat_count = input_repeat_count();
        go_or_stop(car_name_list, repeat_count);
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
            int repeat_count = Integer.parseInt(input_count);
            check_count(repeat_count);
            return repeat_count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void check_count(int counts) {
        if (counts <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void go_or_stop(String[] car_name_list, int repeat_count) {
        System.out.println();
        System.out.println("실행 결과");

        String[] results = new String[car_name_list.length];
        for (int i = 0; i < car_name_list.length; i++) {
            results[i] = "";
        }

        for (int i = 0; i < repeat_count; i++) {
            String[] racing_results = racing(car_name_list, results);
            print_result(car_name_list, racing_results);
            System.out.println();
        }

        List<String> winners = racing_winner(car_name_list, results);
        print_winner(winners);
    }

    public static String[] racing(String[] car_name_list, String[] results) {
        for (int j = 0; j < car_name_list.length; j++) {
            int random_number = Randoms.pickNumberInRange(0, 9);
            if (random_number < 4) {
                results[j] += "";
            } else {
                results[j] += "-";
            }
        }
        return results;
    }

    public static void print_result(String[] car_name_list, String[] results) {
        for (int k = 0; k < car_name_list.length; k++) {
            String car_name = car_name_list[k];
            String result = results[k];
            System.out.println(car_name + " : " + result);
        }
    }

    public static List<String> racing_winner(String[] car_name_list, String[] results) {
        int amount_of_line = 0;
        List<String> winners = new ArrayList<>();

        for (int l = 0; l < car_name_list.length; l++) {
            int line = results[l].length();

            if (line > amount_of_line) {
                amount_of_line = line;
                winners.clear();
                winners.add(car_name_list[l]);
            } else if (line == amount_of_line) {
                winners.add(car_name_list[l]);
            }
        }
        return winners;
    }

    public static void print_winner(List<String> winners){
        System.out.print("최종 우승자 : ");

        if (winners.size() == 1) {
            System.out.print(winners.get(0));
        } else {
            if_multiple_winners(winners);
        }
    }

    public static void if_multiple_winners(List<String> winners) {
        for (int m = 0; m < winners.size(); m++) {
            System.out.print(winners.get(m));
            if (m < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

}
