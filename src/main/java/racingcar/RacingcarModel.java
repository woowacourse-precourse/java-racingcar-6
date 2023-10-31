package racingcar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class RacingcarModel {
    static String INPUT_USERS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static String INPUT_TURNS = "시도할 회수는 몇회인가요?";
    static String RUN_RESULT = "실행 결과";
    static String STATUS_COLONE = " : ";
    static String UPPER_DASH = "-";
    static String PRINT_WINNER = "최종 우승자 :";
    static String SPOT = ",";
    static String SPACE_BAR = " ";

    static Map<String, Integer> members = new LinkedHashMap<String, Integer>();
    static int turn = 0;
    static int maxScore = 0;
    static int winnerCnt = 0;
    static List<String> duplicateInspection = new ArrayList<String>();
}
