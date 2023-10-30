package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


// console ouput should be:
// 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
// pobi,woni,jun
// 시도할 회수는 몇회인가요?
// 5

//짧은 객체 지향 프로그래밍
//1. 기능을 가지고 있는 클래스를 인스턴스화(=객체한다.)
//2. 필요 기능을 (역할에 맞는) 인스턴스가 수행하게 한다. (의인화?)
//3. 각 결과를 종합한다.


public class PlayerTest {

    // TODO: 자동차를 , 구분자로 구분하고 리스트 반환하는 기능

    // TODO: CHANGE CLASS NAME

    @Test
    @DisplayName("입력 값을 , 구분자로 구분하고 다른 구분자가 주어진 경우 예외 처리하는지 확인")
    void testSplitCarNames () {
        Player cars = new Player(); // 이름 문자열 리스트 반환
        String testInput = "Tom, tyla, Judy";
        String[] testInputCarList = testInput.split(",");

        // TODO: correct delimiter 검사

        String[]  userInputCarList = cars.splitName(testInput); // arrayList로 반환할지 아직 안정함
        assertThat(userInputCarList).containsExactly(testInputCarList); // 순서 안지켜도 되는지 아직 정하지 않음

    }
    // TODO: 자동차 리스트 원소의 문자열이 5자 이하인지 검사하는 기능
    @Test
    @DisplayName("배열 입력 값이 5자 이하인지 확인")
    void testEachLengthOfCarNameIsUnder5 () {
        Player cars = new Player();
        ArrayList<String> carsList = cars.splitName("Tom, July1234, Tyler");

        Boolean result = cars.nameSizeValidator(carsList);

        assertThat(result).isFalse(); // 하나라도 틀리면 false 반환


    }


}
