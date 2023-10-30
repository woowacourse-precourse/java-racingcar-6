package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Application {
    private static int start_num = 1;
    private static int end_num = 9;

    private static void string_length_illegal_check(String input_string) {
        if (input_string.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static List<String> input_to_player_list(String input_line) {
        StringTokenizer st = new StringTokenizer(input_line, ",");

        List<String> player_list = new ArrayList<String>();

        while (st.hasMoreTokens()) {
            String input_string = st.nextToken();

            string_length_illegal_check(input_string);

            player_list.add(input_string);
        }

        return player_list;
    }

    private static int is_num(String input_str) {
        if (input_str == null) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
        int return_num;
        try {
            return_num = Integer.parseInt(input_str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return return_num;
    }

    private static boolean is_move(int random_number) {
        if (random_number >= 4) {
            return true;
        } else {
            return false;
        }
    }

    private static int go_or_stop() {
        int random_number = pickNumberInRange(start_num, end_num);
        if (is_move(random_number)) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int[] calculate_move(int[] players_move) {
        for (int players_move_index = 0; players_move_index < players_move.length; players_move_index++) {
            players_move[players_move_index] += go_or_stop();
        }
        return players_move;
    }

    private static String show_movement(int total_movement) {
        StringBuilder sb = new StringBuilder();

        for (int movement = 0; movement < total_movement; movement++) {
            sb.append("-");
        }
        return sb.toString();
    }

    private static void show_race(List<String> player_list, int[] players_move) {
        int total_players = player_list.size();

        StringBuilder sb;

        for (int player_index = 0; player_index < total_players; player_index++) {
            sb = new StringBuilder();
            sb.append(player_list.get(player_index));
            sb.append(" : ");
            sb.append(show_movement(players_move[player_index]));
            String players_race_movement = sb.toString();
            System.out.println(players_race_movement);
        }
        System.out.println();
    }

    private static void show_winner(List<String> player_list, int[] players_move) {

    }

    private static void do_race(List<String> player_list, int play_time) {

        int players_move[] = new int[player_list.size()];

        for (int try_times = 1; try_times <= play_time; try_times++) {
            players_move = calculate_move(players_move);
            show_race(player_list, players_move);
        }

        show_winner(player_list, players_move);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input_line = readLine();

        List<String> player_list = input_to_player_list(input_line);

        System.out.println("시도할 회수는 몇회인가요?");
        int play_time = is_num(readLine());

        do_race(player_list, play_time);

    }
}
