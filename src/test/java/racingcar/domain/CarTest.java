package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest{
    @DisplayName("자동차 이름 길이 오류여부 테스트")
    @ParameterizedTest(name = "{0}라는 이름의 자동차 생성")
    @ValueSource(strings={"람보르기니카","슈퍼카","티모","슈퍼슈퍼파워카"})
    void car_name_length_test(String name){
        //Given
        int len = name.length();
        //When
        if(len>5) {
            assertThrows(IllegalArgumentException.class, () -> new Car(name));
            System.out.println(name+" : "+len+"글자, 오류 발생");
        }
        else{
            System.out.println(name+" : "+len+"글자, 테스트 통과");
        }
    }
}
