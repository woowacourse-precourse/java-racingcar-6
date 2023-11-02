package study;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static java.lang.Compiler.command;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;

import java.util.Scanner;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    public void testMultipleWinners() {
        // Given
        Car car1 = new Car("Car1", "------");
        Car car2 = new Car("Car2", "-------");
        Car car3 = new Car("Car3", "-------"); // 동일한 Displacement를 가진 차

        CarRepository.getInstance().save(car1);
        CarRepository.getInstance().save(car2);
        CarRepository.getInstance().save(car3);

        RacingGameService winnerDecider = new RacingGameService();

        // When
        String winners = winnerDecider.decideWinner();

        // Then
        // 여러 우승자가 있는지 확인
        assertEquals("Car2, Car3", winners); // 예상 우승자 목록을 확인합니다.
    }

    @Test
    public void testUniWinners() {
        // Given
        RacingGameService winnerDecider = new RacingGameService();
        Car car1 = new Car("Car1", "------");
        Car car2 = new Car("Car2", "------");
        Car car3 = new Car("Car3", "-------"); // 동일한 Displacement를 가진 차

        CarRepository.getInstance().save(car1);
        CarRepository.getInstance().save(car2);
        CarRepository.getInstance().save(car3);

        // When
        String winners = winnerDecider.decideWinner();

        // Then
        // 여러 우승자가 있는지 확인
        assertEquals("Car3", winners); // 예상 우승자 목록을 확인합니다.
    }

}
