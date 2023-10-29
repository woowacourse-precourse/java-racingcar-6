package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Judgment {
    private static final int OFFSET = 1;
    private static final int LIMIT = 9;
    private static final HashMap<String, String> RESULT = new HashMap<>();
    private static Judgment judgment;

    private Judgment() {
    }

    //싱글톤 유지
    public static Judgment getInstance() {
        if (judgment == null) {
            return judgment = new Judgment();
        }
        return judgment;
    }

    // 실행 횟수를 파라미터로 받아서 횟수만큼 getExecutionResult 실행 밎 결과 출력
    public void executeForCount(int count, List<String> cars) {
        IntStream.range(0, count).forEach(i -> {
            judgment.getExecutionResult(cars);
            RESULT.keySet().stream()
                    .map(key -> key + " : " + RESULT.get(key))
                    .forEach(System.out::println);
            System.out.println();
        });
    }

    //랜덤수를 받고 전진 결과를 map({차량이름}, {전진 결과})에 저장
    private void getExecutionResult(List<String> cars) {

        for (String car : cars) {
            String spaceMoved = "";

            int randomNum = getRandomNumber();

            RESULT.putIfAbsent(car, spaceMoved);

            if (canMoveForward(randomNum)) {
                spaceMoved = RESULT.get(car);
                spaceMoved += "-";
                RESULT.put(car, spaceMoved);
            }
        }
    }

    //map 에 들어있는 value 중 가장 큰 값(중복허용)을 찾고 그 값을 리스트로 반환
    public List<String> getResultWinner() {
        int max = Collections.max(RESULT.values()).length();

        return RESULT.keySet().stream()
                .filter(key -> RESULT.get(key).length() == max)
                .collect(Collectors.toList());
    }

    private boolean canMoveForward(int randomNum) {
        return randomNum >= 4;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(OFFSET, LIMIT);
    }
}