package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("이름의 길이를 확인하는 기능.")
    @ParameterizedTest
    @ValueSource(strings={"eleven","abcdef","qwerdf","111234","1q2w3e4r"})
    void checkNameCorrectRange_이름_길이_적합성_판단(String name){
        RacingGame racingGame=new RacingGame();
        assertThatThrownBy(()->racingGame.checkNameCorrectRange(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름의 공백을 제거하는 기능.")
    @ParameterizedTest
    @CsvSource(value={" na me :name","n a m e:name"," wh i t e:white"},delimiter = ':')
    void removeWhiteSpace(String input,String expected){
        RacingGame racingGame=new RacingGame();

        assertThat(racingGame.removeWhiteSpace(input)).isEqualTo(expected);
    }

    @DisplayName("이름이 비었는지 확인하는 기능.")
    @Test
    void checkNameIsEmpty_이름_사이즈_0인경우(){
        RacingGame racingGame=new RacingGame();
        String emptyName="";
        assertThatThrownBy(()-> racingGame.checkNameIsEmpty(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0에서 9 사이의 랜덤한 값을 만드는 기능.")
    @Test
    void makeRandomValue_랜덤값_생성(){
        RacingGame racingGame=new RacingGame();

        for(int attempt=0;attempt<100;attempt++){
            assertThat(racingGame.makeRandomValue()).isBetween(0,9);
        }

    }
}
