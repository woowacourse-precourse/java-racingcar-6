package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateStatusOfRacingTest {

    //테스트를 위해 만든 변수
    static boolean decide;
    @Test
    public void testWhenDecideToForwardIsTrueUpdateStatusOfRacing() {
        // 테스트할 메서드의 로직과 연관된 데이터를 준비합니다.
        Map<String, StringBuilder> statusOfRacing = new HashMap<>();
        statusOfRacing.put("Car1", new StringBuilder("-"));
        decide = decideToForward();
        System.out.println(decide);

        String[] arrayCarNames = {"Car1"};

        // 메서드를 호출합니다.
        updateStatusOfRacing(statusOfRacing, arrayCarNames);
        System.out.println(statusOfRacing.get("Car1"));

        // 특정 조건에 따라 어떤 값이 변경되었는지 테스트합니다.
            StringBuilder status = statusOfRacing.get("Car1");
            if (status.toString().equals("--")) {
                // '-'가 추가되었다면 전진했음을 의미하고, decide가 true여야 합니다.
                assertTrue(decide);
            } else {
                // 아무런 변화가 없다면 전진하지 않았음을 의미하고, decide가 false여야 합니다.
                assertFalse(decide);
            }

    }
    public static void updateStatusOfRacing(Map<String, StringBuilder> statusOfRacing, String[] arrayCarNames) {
        for(int i=0;i< statusOfRacing.size();i++){
            //테스트를위해 decideToForward()=>decide로 변경
            if(decide){
                statusOfRacing.put(arrayCarNames[i],statusOfRacing.get(arrayCarNames[i]).append("-"));
            }
        }
    }
    public static boolean decideToForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber>=4) return true;
        else return false;
    }
}
