package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionTest {
    @DisplayName("위치 값을 작대기(-)로 변환해주는 기능")
    @ParameterizedTest
    @CsvSource(value = {"0:''","1:-","2:--"},delimiter = ':')
    void switchPositionToSlash_위치값_작대기_변환(int status,String expected){
        Position position=new Position(status);
        assertThat(position.switchPositionToSlash()).isEqualTo(expected);
    }
}
