package study;

import racingcar.constant.UserRequestMessage;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.dto.CarNameRequst;
import racingcar.model.Car;
import racingcar.util.NumberUtil;
import racingcar.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void constant_적절한_메시지_출력(){
        String message = UserRequestMessage.CAR_NAME_REQUEST_MESSAGE.toString();
        assertThat(message).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    void split_쉼표로_주어진_값을_구분(){
        StringUtil sp = new StringUtil();

        // 모의 사용자 입력 설정
        String [] result = sp.seperate("pobi,woni,jun", ",");
        String [] expected = new String[] {"pobi", "woni", "jun"};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 자동차_생성(){
        CarController carController = new CarController();
        List<CarNameRequst> carNames = new ArrayList<>();
        carNames.add(new CarNameRequst("pobi"));
        carNames.add(new CarNameRequst("woni"));
        carNames.add(new CarNameRequst("jun"));
        ArrayList<Car> result =  carController.createCars(carNames);

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(new Car("pobi"));
        expected.add(new Car("woni"));
        expected.add(new Car("jun"));

        // 객체 비교
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    @RepeatedTest(100)
    void 무작위_수_생성(){
        NumberUtil numberUtil = new NumberUtil();
        int actual = numberUtil.createRandomNumber();

        assertThat(actual).isBetween(0,9);
    }


    @Test
    void 최대값_찾기(String input){
        ArrayList<Integer> inputList = (ArrayList<Integer>) Arrays.asList(10,20,30,40,50);

        int actual = NumberUtil.getMaximumNum(inputList);
        assertThat(actual).isEqualTo(50);
    }

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

}
