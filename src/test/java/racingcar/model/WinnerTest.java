package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class WinnerTest {

    List<Car> cars;
    Winner winner;

    @BeforeEach
    public void before() {
        winner = new Winner();
        cars = new ArrayList<>();

        cars.add(new Car("aaa"));
        cars.add(new Car("bbb"));
        cars.add(new Car("ccc"));

        cars.get(0).moveForward(3);
        cars.get(1).moveForward(4);
        cars.get(1).moveForward(5);
        cars.get(2).moveForward(6);
        cars.get(2).moveForward(7);
    }

    @Test
    public void 최대_이동거리_구하기() throws Exception {
        //given (주어진 값)
        Method method = winner.getClass().getDeclaredMethod("maxDistance", List.class);
        method.setAccessible(true);

        //when (기능 작동)
        int result = (int) method.invoke(winner, cars);

        //then (기능 작동 후 결과)
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void 단일_우승자_자동차_이름() throws Exception {
        //given (주어진 값)
        cars.get(1).moveForward(9);
        List<String> equals = new ArrayList<>(List.of("bbb"));

        //when (기능 작동)
        winner.findWinnerName(cars);
        List<String> result = winner.getWinnerName();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result).isEqualTo(equals);
    }

    @Test
    public void 동일_우승자_자동차_이름() throws Exception {
        //given (주어진 값)
        List<String> equals = new ArrayList<>(List.of("bbb", "ccc"));

        //when (기능 작동)
        winner.findWinnerName(cars);
        List<String> result = winner.getWinnerName();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).isEqualTo(equals);
    }

    @Test
    public void 모두_우승자() throws Exception {
        //given (주어진 값)
        cars.get(0).moveForward(8);
        cars.get(0).moveForward(7);
        List<String> equals = new ArrayList<>(List.of("aaa", "bbb", "ccc"));

        //when (기능 작동)
        winner.findWinnerName(cars);
        List<String> result = winner.getWinnerName();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result).isEqualTo(equals);
    }

    @Test
    public void 플레이횟수가_없을경우() throws Exception {
        //given (주어진 값)
        cars = new ArrayList<>();
        cars.add(new Car("aaa"));
        cars.add(new Car("bbb"));
        cars.add(new Car("ccc"));
        cars.add(new Car("ddd"));

        List<String> equals = new ArrayList<>(List.of("aaa", "bbb", "ccc", "ddd"));
        //when (기능 작동)
        winner.findWinnerName(cars);
        List<String> result = winner.getWinnerName();

        //then (기능 작동 후 결과)
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result).isEqualTo(equals);
    }
}