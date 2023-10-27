package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
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

    @DisplayName("콘솔에서 이름 입력부터 Name 생성까지 통합 기능.")
    @Test
    void inputCarNames_이름입력_통합(){
        RacingGame racingGame=new RacingGame();
        String names="pobi,woni,jun,james,timmy,ski";
        String[] splitName=names.split(",");
        InputStream in=new ByteArrayInputStream(names.getBytes());
        System.setIn(in);

        List<Car> cars=racingGame.inputCarNames();

        for(int index=0;index<cars.size();index++){
            assertThat(cars.get(index).getNameValue()).isEqualTo(splitName[index]);
        }
    }

    @DisplayName("콘솔로 입력된 시도횟수의 validate 판단 및 정수로 변환해서 반환해주는 기능")
    @Test
    void inputAttemptCount_횟수_입력(){
        RacingGame racingGame=new RacingGame();
        String input="12345";

        assertThat(racingGame.inputAttemptCount(input)).isEqualTo(12345);

    }

    @DisplayName("문자열 배열에 중복이 있는지 확인하고 있다면 Exception을 발생시키는 기능")
    @Test
    void checkHasDuplicates_중복_확인(){
        RacingGame racingGame=new RacingGame();
        String[] names={"pobi","woni","jun","ski","james","pobi"};

        assertThatThrownBy(()->racingGame.checkHasDuplicates(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
