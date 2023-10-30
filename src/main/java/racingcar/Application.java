package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.UserInputData;

public class Application {
    public static void main(String[] args) {
        var gameStartData = inputGameInfo();

        Map<String, StringBuilder> racer = new HashMap<>();
        for(String name: gameStartData.carName){
            racer.put(name, new StringBuilder());
        }

        final int LEAST_POWER = 4;

        for(int i = 0 ; i < gameStartData.loopCount;++i){
            for(StringBuilder sb : racer.values()){
                int forwardPower = Randoms.pickNumberInRange(0, 9);
                if(forwardPower < LEAST_POWER) continue;
                sb.append('-');
            }

            // print result after step

            for(String key: racer.keySet()){
                System.out.println(key + " : " + racer.get(key).toString());
            }
            System.out.println();
        }

        int maxLength = 0;
        for(var sb : racer.values()){
            if(maxLength < sb.length()){
                maxLength = sb.length();
            }
        }

        int finalMaxLength = maxLength;
        var winner = racer.keySet()
                .stream()
                .filter(key -> finalMaxLength == racer.get(key).length())
                .toList();

        var sb = new StringBuilder();

        sb.append("최종 우승자 : ");
        sb.append(String.join(", ", winner));

        System.out.println(sb);
    }

    /**
     * 경주 게임 시작을 위한 입력 받기
     *
     * @return 게임 시작을 위한 기초 데이터
     */
    public static UserInputData inputGameInfo() {
        UserInputData answer = new UserInputData();

        answer.carName = inputCarName();
        answer.loopCount = inputTryCount();

        return answer;
    }

    /**
     * 자동차 이름 입력
     *
     * @return 입력받은 자동차 이름 리스트
     */
    private static List<String> inputCarName() {
        final String SEPARATOR_CHARACTER = ",";
        final int LENGTH_LIMIT = 5;
        List<String> answer;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        answer = Arrays.asList(str.split(SEPARATOR_CHARACTER));

        var count = answer.stream()
                .filter(name -> name.length() > LENGTH_LIMIT)
                .count();

        if (count != 0L) {
            throwArgumentException("자동차 명은 최대 5까지만 허용됩니다.");
        }

        return answer;
    }

    /**
     * 반복 횟수 입력
     *
     * @return 반복 횟수
     */
    private static int inputTryCount() {
        int answer;
        final int MINIMUM_TRY_COUNT = 1;
        final String NUMERIC_PATTERN = "^[\\d]*";
        System.out.println("시도할 횟수는 몇회인가요?");
        String str = Console.readLine();

        if (!str.matches(NUMERIC_PATTERN)) {
            throwArgumentException("시도횟수는 아라비아 숫자 0-9로 이루어진 문자열로 입력해야합니다.");
        }
        answer = Integer.parseInt(str);

        if (answer < MINIMUM_TRY_COUNT) {
            throwArgumentException("시도횟수는 최소 1회부터 시작합니다.");
        }

        return answer;
    }

    private static void throwArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

}
