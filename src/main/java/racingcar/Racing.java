package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Racing {

    private final String inputAnnouncement = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String tryNumberAnnouncement = "시도할 회수는 몇회인가요?";
    private Map<String, Integer> carMap;

    public void start() {
        System.out.println(inputAnnouncement);
        String inputCarName = Console.readLine();

        if (inputCarName.equals("") || inputCarName.equals(null)) {
            new ThrowException().throwEmpty();
        }

        makeCarMap(inputCarName);
    }

    public void makeCarMap(String inputCarName) {
        carMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(inputCarName, ",");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (carMap.containsKey(token)) {
                new ThrowException().throwNameOverlap();
            }
            if (token.length() > 5) {
                new ThrowException().throwNameLength();
            }
            carMap.put(token, 0);
        }

        inputTryNumber();
    }

    public void inputTryNumber() {
        System.out.println(tryNumberAnnouncement);
        int tryNumber = Integer.parseInt(Console.readLine());

        if (tryNumber <= 0) {
            new ThrowException().throwTryNumber();
        }

        new ExecuteResult().execute(carMap, tryNumber);
    }


}
