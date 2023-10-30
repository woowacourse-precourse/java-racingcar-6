package racingcar.Model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MemberState {
    private static final int INIT_DISTANCE = 0;

    public Map<String, Integer> initMemberState(String memberInput) {
        // HashMap의 순서를 보장하기 위해 LinkedHashMap 사용
        Map<String, Integer> memberStates = new LinkedHashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(memberInput, ",");
        while (stringTokenizer.hasMoreTokens()) {
            String name = stringTokenizer.nextToken();
            nameException(name);
            memberStates.put(name, INIT_DISTANCE);
        }

        return memberStates;
    }

    public void nameException(String name) {
        // * 이름 예외 처리
        // 이름 5자 이하가 아닐 경우
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
