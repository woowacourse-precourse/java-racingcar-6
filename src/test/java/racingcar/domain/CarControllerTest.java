package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarControllerTest {

    @ParameterizedTest
    @MethodSource("provideTestArguments")
    void gameStartTest(String inputCars, int numberOfRacing) {
        //자동차 목록 리스트화 (예측 키값)
        List<String> expectedKeys = Arrays.stream(inputCars.split(","))
                .map(String::strip)
                .collect(Collectors.toList());

        CarController carControllerTest = new CarController(expectedKeys);
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        // 레이싱의 횟수 numberOfRacing;

        // numberOfRacing번 레이싱 진행;
        for (int eachRacing = 0; eachRacing < numberOfRacing; eachRacing++) {
            result = carControllerTest.gameStart();
        }

        // 키값이 제공된 것과 일치 하는 같은가?
        assertThat(result.keySet()).containsExactlyInAnyOrderElementsOf(expectedKeys);

        //각 키의 결과 값이 0부터 "제공된 이동횟수(numberOfRacing)" 까지 인가?
        for (String expectedKey : expectedKeys) {
            assertThat(result.get(expectedKey)).isBetween(0, numberOfRacing);
        }
    }

    //임의의 제공된 테스트 입력값
    private static Stream<Arguments> provideTestArguments() {
        return Stream.of(
                Arguments.of("jack,podo, gos,ging ", 51),
                Arguments.of(" carA, carB", 3),
                Arguments.of("carA", 313),
                Arguments.of("carA, carB, carD, carE, carF, carG", 3122),
                Arguments.of("carA, carB", 1)
        );
    }

    private final String cars = "pobi,news,neon";
    private final List<String> carsList = new ArrayList<>(Arrays.asList(cars.split(",")));
    private CarController carController;

    @BeforeEach
    void setUp() {
        carController = new CarController(carsList);
    }

    @Test
    void isForwardTest() {
        int result = carController.isForward();
        // 결과 값이 0또는 1인가?
        assertThat(result).isIn(0, 1);
    }

    @Test
    void isBiggerThanFourTest() {
        int result = carController.isBiggerThanFour(3);
        assertThat(result).isEqualTo(0);
        result = carController.isBiggerThanFour(4);
        assertThat(result).isEqualTo(1);
        result = carController.isBiggerThanFour(9);
        assertThat(result).isEqualTo(1);

    }
}







































