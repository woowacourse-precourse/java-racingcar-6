package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Application {

    private static void string_length_illegal_check(String input_string) {
        if (input_string.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    private static List<String> input_to_namelist(String input_line) {
        StringTokenizer st = new StringTokenizer(input_line, ",");

        List<String> name_list = new ArrayList<String>();

        while (st.hasMoreTokens()) {
            String input_string = st.nextToken();

            string_length_illegal_check(input_string);

            name_list.add(input_string);
        }

        return name_list;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input_line = readLine();

        List<String> name_list = input_to_namelist(input_line);

    }
}
