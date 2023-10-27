package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @DisplayName("입력받은 이름이 쉼표를 기준으로 분리되는 기능")
    @Test
    void splitNames_이름_분리_기능(){
        String input="pobi,woni,jun";
        RacingGame racingGame=new RacingGame();
        String[] splitNames=racingGame.splitNames(input);

        assertThat(splitNames).contains("jun","pobi","woni");
        assertThat(splitNames).containsExactly("pobi","woni","jun");
    }

    @DisplayName("입력 문자열이 정수로 이루어져 있는지 확인하는 기능.")
    @ParameterizedTest
    @ValueSource(strings = {"abcs","1aav","a2f","aaaa3"})
    void checkAttemptCountIsInteger_입력값_정수_확인(String input){
        RacingGame racingGame=new RacingGame();

        assertThatThrownBy(()->racingGame.checkAttemptCountIsInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
