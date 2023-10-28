package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.StringTokenizer;

public class Application {
    private static final int INIT_DISTANCE = 0;
    private static final int MOVING_FORWARD = 4;

    public static void main(String[] args) {
        // HashMap의 순서를 보장하기 위해 LinkedHashMap 사용
        Map<String, Integer> memberStates = new LinkedHashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String memberInput = Console.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(memberInput, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken();
            memberStates.put(name, INIT_DISTANCE);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryInput = Console.readLine();
        int tryCount = Integer.parseInt(tryInput);

        System.out.println();
        System.out.println("실행 결과");
        // 게임 시작
        for (int i = 0; i < tryCount; i++) {
            // 한 게임씩 시작
            for (String name : memberStates.keySet()) {

                // 무작위 값 뽑기
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                // 전진할 경우
                if (randomNumber >= MOVING_FORWARD) {
                    memberStates.replace(name, memberStates.get(name) + 1);
                }

                // 각 차수별 실행 결과
                System.out.println(name + " : " + changeDash(memberStates.get(name)));
            }
            System.out.println();
        }

        // 최종 우승자 판별

        // 최대 이동값 구하기
        int maxNumber = 0;
        List<String> winner = new ArrayList<>();
        for (String name : memberStates.keySet()) {
            if (memberStates.get(name) > maxNumber) {
                maxNumber = memberStates.get(name);
                winner.clear();
                winner.add(name);
            }
            if (memberStates.get(name) == maxNumber) {
                if (winner.contains(name)) {
                    continue;
                }
                winner.add(name);
            }
        }
    }

    // 이동거리를 대쉬(-)로 변경
    public static StringBuilder changeDash(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        String dash = "-";
        for (int i = 0; i < distance; i++) {
            stringBuilder.append(dash);
        }

        return stringBuilder;
    }
}