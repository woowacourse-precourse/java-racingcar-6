package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.GameManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    GameManager gameManager = new GameManager();
    @BeforeEach
    public void setUp() {
        GameManager.cars = new ArrayList<>();
        GameManager.forwardCount = new ArrayList<>();
        GameManager.cars.add("aaa");
        GameManager.cars.add("bbb");
        GameManager.cars.add("ccc");
        GameManager.forwardCount.add(2);
        GameManager.forwardCount.add(3);
        GameManager.forwardCount.add(3);
    }
    @Test
    void 랜덤값_반환() {
        Method method = null;
        try {
            method = gameManager.getClass().getDeclaredMethod("randomNumber");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("메서드를 찾을 수 없습니다.", e);
        }
        //randomNumber 메서드 테스트 하기 위해 private 메서드 접근 허용
        method.setAccessible(true);
        int test = 100;
        try {
            test = (int) method.invoke(gameManager);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }
        assertThat(test).isBetween(0, 9);
    }
    @Test
    void 전진_조건_충족(){
        Method method = null;
        try {
            method = gameManager.getClass().getDeclaredMethod("plusForwardCount", List.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("메서드를 찾을 수 없습니다.", e);
        }
        //plusForwardCount 메서드 테스트 하기 위해 private 메서드 접근 허용
        method.setAccessible(true);
        List<Integer> forwardCount = new ArrayList<>();
        forwardCount.add(1);
        forwardCount.add(2);
        forwardCount.add(3);
        List<Integer> test = new ArrayList<>();
        try {
            test = (List<Integer>) method.invoke(gameManager, forwardCount);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }

        //예시로 2,3,4 체크
        assertThat(test).containsExactly(2,2,4);
    }

    @Test
    void 우승자_반환(){
        Method method = null;
        try {
            method = gameManager.getClass().getDeclaredMethod("winnerCarName", int.class);
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
        try {
            winners = (List<String>) method.invoke(gameManager, winnerCount);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }

        assertEquals(testWinners, winners);
    }

    @Test
    void 우승자_2명_이상일_경우_출력_표시(){
        Method method = null;
        try {
            method = gameManager.getClass().getDeclaredMethod("findWinners");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("메서드를 찾을 수 없습니다.", e);
        }
        //findWinners 메서드 테스트 하기 위해 private 메서드 접근 허용
        method.setAccessible(true);

        String winners = "";
        try {
            winners = (String) method.invoke(gameManager);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("메서드 호출 실패", e);
        }
        String test = "bbb, ccc";
        assertEquals(winners, test);
    }

}
