package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racingcar.RacingGame.*;

class RacingGameTest {
    
    @Test
    @DisplayName("컬렉션의 스트림을 통해 콤바로 이름을 구분하고, 출력")
    void testInputCarName(){
        String input = "pobi, woni, jun";

        List<Car> cars = new RacingGame().inputCarName(input);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");

    }

    @Test
    @DisplayName("시도 횟수 정하는 메소드 테스트")
    void testInputForwardCar(){
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 사용자 입력 시뮬레이션, 콘솔에서 입력받는 것이 아닌 문자를 바이트로 변환하여 입력함.

        int inputForwardCar = new RacingGame().inputForwardCar();

        assertThat(inputForwardCar).isEqualTo(5);

    }

    @Test
    @DisplayName("전진횟수에 따라 '-' 찍기")
    void testPrintRaceState(){
        Car pobi = new Car("pobi");
        pobi.setForwardCount(5);

        List<Car> cars = new ArrayList<>();
        cars.add(pobi);

        String result = printRaceState(cars);

        assertThat(result).isEqualTo("pobi : -----\n");
    }

    @Test
    @DisplayName("제일 전진을 많이 한 자동차 찾기")
    void testMaxForward(){
        // 테스트를 위한 객체(자동차) 생성
        Car pobi = new Car("pobi");
        pobi.setForwardCount(5);

        Car woni = new Car("woni");
        woni.setForwardCount(4);

        Car jun = new Car("jon");
        jun.setForwardCount(3);

        List<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(woni);
        cars.add(jun);

        int maxForward = maxForward(cars);

        assertEquals(5, maxForward);

    }

    @Test
    @DisplayName("우승자가 한명이 아닌 여러명일 경우")
    void testOneOrOtherWinner(){
        // 테스트를 위한 객체(자동차) 생성
        Car pobi = new Car("pobi");
        pobi.setForwardCount(5);

        Car woni = new Car("woni");
        woni.setForwardCount(5);

        Car jun = new Car("jon");
        jun.setForwardCount(3);

        int maxForward = 5;

        String result = oneOrOtherWinner(pobi, maxForward) +
                oneOrOtherWinner(woni, maxForward) +
                oneOrOtherWinner(jun, maxForward);

        assertThat(result).isEqualTo("pobi, woni");

    }

    @Test
    @DisplayName("최종 우승자 메소드 출력 확인")
    void testPrintFinalWinner(){
        // 테스트를 위한 객체(자동차) 생성
        Car pobi = new Car("pobi");
        pobi.setForwardCount(5);

        Car woni = new Car("woni");
        woni.setForwardCount(4);

        Car jun = new Car("jon");
        jun.setForwardCount(3);

        List<Car> cars = new ArrayList<>();
        cars.add(pobi);
        cars.add(woni);
        cars.add(jun);

        String result = printFinalWinner(cars);

        assertThat(result).isEqualTo("최종 우승자 : pobi");

    }

}