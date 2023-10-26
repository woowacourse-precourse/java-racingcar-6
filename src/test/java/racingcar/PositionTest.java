package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @DisplayName("4 이상의 값인지 판단한는 기능")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void checkValueIsOverFour_4이상_판단_기능(int value) {
        Position position = new Position();

        assertThat(position.checkValueIsOverFour(value)).isTrue();
    }

    @DisplayName("전진 기능")
    @Test
    void moveForward_전진_기능(){
        Position position=new Position();
        int beforePosition=position.position;
        position.moveForward();
        assertThat(position.position-1).isEqualTo(beforePosition);
    }

    @DisplayName("위치 값을 작대기(-)로 변환해주는 기능")
    @ParameterizedTest
    @CsvSource(value = {"0:''","1:-","2:--"},delimiter = ':')
    void switchPositionToSlash_위치값_작대기_변환(int status,String expected){
        Position position=new Position(status);
        assertThat(position.switchPositionToSlash()).isEqualTo(expected);
    }

    @DisplayName("0에서 9 사이의 랜덤한 값을 만드는 기능.")
    @Test
    void makeRandomValue_랜덤값_생성(){
        Position position=new Position();

        for(int attempt=0;attempt<100;attempt++){
            assertThat(position.makeRandomValue()).isBetween(0,9);
        }
    }
}
