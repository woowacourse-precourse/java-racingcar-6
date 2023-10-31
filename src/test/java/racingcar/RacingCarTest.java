package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {

    private static final int PROGRESS_VALUE = 4;

    @Test
    void 사용자_입력을_리스트로_변환후_저장_테스트() {
        //given
        String input = "wowa,java";

        //when
        Cars cars = new Cars(input);

        //then
        assertThat(cars.getCarNames()).contains("wowa", "java");
    }

    @Test
    void 사용자_입력을_맵으로_변환후_저장_테스트() {
        //given
        String input = "wowa,java";

        //when
        Cars cars = new Cars(input);

        //then
        assertThat(cars.getCarScores()).contains(entry("wowa", 0), entry("java", 0));
    }

    @Test
    void 전진_테스트() {
        //given
        String input = "java";
        Cars cars = new Cars(input);
        int num = 5;

        //when 전진시 사용하는 알고리즘
        if(num >= PROGRESS_VALUE)
            cars.moveForward("java");

        //then
        assertThat(cars.getCarScores()).contains(entry("java", 1));
    }

    @Test
    void 정지_테스트() {
        //given
        String input = "java";
        Cars cars = new Cars(input);
        int num = 2;

        //when
        if(num >= PROGRESS_VALUE)
            cars.moveForward("java");

        //then
        assertThat(cars.getCarScores()).contains(entry("java", 0));
    }

    @Test
    void 한명만_우승한_경우_테스트() {
        //given
        Cars cars = new Cars("java,wowa,tech");
        cars.moveForward("java");
        List<String> winners = new ArrayList<>();
        List<String> expectedWinner = Arrays.asList("java");

        //when 우승자를 가려내는 알고리즘
        int bestScore = cars.getBestScore();
        Map<String, Integer> carsScore = cars.getCarScores();
        cars.getCarNames().stream()
                .filter(carName -> carsScore.get(carName).equals(bestScore))
                .forEach(winners::add);

        //then
        assertEquals(winners, expectedWinner);
    }

    @Test
    void 여러명_우승한_경우_테스트() {
        //given
        Cars cars = new Cars("java,wowa,tech");
        cars.moveForward("java");
        cars.moveForward("wowa");
        List<String> winners = new ArrayList<>();
        List<String> expectedWinner = Arrays.asList("java", "wowa");

        //when 우승자를 가려내는 알고리즘
        int bestScore = cars.getBestScore();
        Map<String, Integer> carsScore = cars.getCarScores();
        cars.getCarNames().stream()
                .filter(carName -> carsScore.get(carName).equals(bestScore))
                .forEach(winners::add);

        //then
        assertEquals(winners, expectedWinner);
    }

}
