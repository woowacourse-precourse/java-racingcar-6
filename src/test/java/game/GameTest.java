package game;

import org.junit.jupiter.api.Test;
import racingcar.GameManager;
import racingcar.GameManagerUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    GameManager gameManager = new GameManager();
    GameManagerUtils gameManagerUtils = new GameManagerUtils();
    @Test
    void 랜덤값_반환() {
        int randomNumber = gameManagerUtils.randomNumber();
        assertThat(randomNumber).isBetween(0,9);
    }
    @Test
    void 전진_조건_충족(){
        List<Integer> forwardCount = new ArrayList<>();
        forwardCount.add(1);
        forwardCount.add(1);
        forwardCount.add(1);
        List<Integer> forwardCountTest = new ArrayList<>();
        forwardCountTest = gameManagerUtils.plusForwardCount(forwardCount);
        //예시로 1,2,2 체크
        assertThat(forwardCountTest).containsExactly(1,2,2);
    }

    @Test
    void 우승자_반환(){
        Method method = null;
        List<String> cars = new ArrayList<>();
        cars.add("aaa");
        cars.add("bbb");
        cars.add("ccc");

        GameManagerUtils gameManagerUtilsTest = new GameManagerUtils(cars);
        try {
            method = gameManagerUtilsTest.getClass().getDeclaredMethod("winnerCarName", int.class, List.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("메서드를 찾을 수 없습니다.", e);
        }
        //winnerCarName 메서드 테스트 하기 위해 private 메서드 접근 허용
        method.setAccessible(true);

        int winnerCount = 3;
        List<String> testWinners = new ArrayList<>();
        testWinners.add("bbb");
        testWinners.add("ccc");

        List<String> winners = new ArrayList<>();
        List<Integer> forwardCount = new ArrayList<>();
        forwardCount.add(1);
        forwardCount.add(3);
        forwardCount.add(3);
        try {
            winners = (List<String>) method.invoke(gameManagerUtilsTest, winnerCount, forwardCount);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }

        assertEquals(testWinners, winners);
    }

    @Test
    void 우승자_2명_이상일_경우_출력_표시(){
        List<String> winnerCarName = new ArrayList<>();
        winnerCarName.add("bbb");
        winnerCarName.add("ccc");

        String winners = gameManagerUtils.joinWithCommas(winnerCarName);
        String winnersTest = "bbb, ccc";
        assertEquals(winners, winnersTest);
    }

}
