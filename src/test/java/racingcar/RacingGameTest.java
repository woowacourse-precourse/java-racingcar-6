package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class RacingGameTest {
    @DisplayName("콘솔에서 이름 입력부터 Name 생성까지 통합 기능.")
    @Test
    void inputCarNames_이름입력_통합(){
        RacingGame racingGame=new RacingGame();
        String names="pobi,woni,jun,james,timmy,ski";
        String[] splitName=names.split(",");

        List<Car> cars=racingGame.inputCarNames(names);

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

    @DisplayName("입력 문자열이 정수로 이루어져 있는지 확인하는 기능.")
    @Test
    void inputAttemptCount_예외처리(){
        RacingGame racingGame=new RacingGame();
        String input="1234a5";

        assertThatThrownBy(()->racingGame.inputAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차들의 이름을 출력하는 기능.")
    @Test
    void printCarName(){
        RacingGame racingGame=new RacingGame();
        List<Car> cars=Arrays.asList(new Car(new Name("pobi"),new Position()),new Car(new Name("jun"),new Position()));
        String expected="pobi, jun";

        String result=racingGame.printCarName(cars);

        assertThat(result).isEqualTo(expected);

    }
}
