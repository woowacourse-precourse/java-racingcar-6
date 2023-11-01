package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/* 테스트 케이스
   1. " ,1" : 성공 (공백은 안됩니다.)
   2. "1, " : 성공 (공백은 안됩니다.)
   3. ",,," : 성공 (길이가 작습니다.)
   4. ",!123,#1123" : 성공 (자동차의 이름은 공백이 불가능합니다.)
   5. ",,12" 성공 (자동차의 이름은 공백이 불가능합니다.)
   6. "1,2,3 " 성공 (자동차의 이름은 공백이 불가능합니다.)
   7. "1,2,2" 성공 (중복되는 이름이 있습니다.)
   8. "1,2,3," "성공 (문장의 마지막 문자는 컴마(',') 를 허용하지 않습니다.)"
 */

class InputToCarListTest {

    @DisplayName("주어진 문자열을 ',' 를 기준으로 나누고 그 값을 List 에 담아 반환한다.")
    @Test
    void splitSpecialCharacterAndReturnList() {
        //given
        String input = "이순신,손흥민,포비";
        InputToCarList instance = InputToCarList.getInstance();

        //when
        List<Car> cars = instance.askCarNameToCarList(input);

        StringBuilder sb = new StringBuilder();
        //then
        for (Car car : cars) {
            sb.append(car.getName() + " ");
        }

        Assertions.assertThat(sb.toString()).isEqualTo("이순신 손흥민 포비 ");


    }

    @DisplayName("반환 타입은 List 이므로 isInstanceOf 의 값은 True 가 나올 것이다.")
    @Test
    void returnList() {
        //given
        InputToCarList instance = InputToCarList.getInstance();
        String input = "김민수,손흥민";

        //when
        List<Car> cars = instance.askCarNameToCarList(input);

        //then
        Assertions.assertThat(cars).isInstanceOf(List.class);
    }

    @DisplayName("자동차 이름은 5글자 이하만 가능하다. 6글자 이상은 IllegalArgumentException 예외가 발생한다. ")
    @Test
    void carNameUnderFiveLength() {
        //given
        String input = "우::::가";
        InputToCarList instance = InputToCarList.getInstance();

        //then
        Assertions.assertThatThrownBy(() -> instance.askCarNameToCarList(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자인 ',,,' 를 입력받을 경우 해당 리스트의 사이즈는 0이되어 예외가 발생한다.")
    @Test
    void listSizeOverOne() {
        //given
        InputToCarList instance = InputToCarList.getInstance();
        String input = ",,,";

        //then
        Assertions.assertThatThrownBy(() -> instance.askCarNameToCarList(input)).isInstanceOf(
                IllegalArgumentException.class);

    }

    @DisplayName("문장의 마지막 문자는 컴마(',')를 허용하지 않는다.")
    @Test
    void noPermitEndOfSentenceCharacter() {
        //given
        InputToCarList instance = InputToCarList.getInstance();
        String input = "김민수,홍길동,";

        //then
        Assertions.assertThatThrownBy(() -> instance.askCarNameToCarList(input)).isInstanceOf(
                IllegalArgumentException.class);

    }

}
