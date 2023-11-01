package racingprocess;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingProcessTest {

    @DisplayName("입력된 경주 횟수가 양의 정수인지 확인")
    @Test
    void isNumber() {
        String numberString = "-5";

        assertThatThrownBy(() -> {
            int number = checkInt(numberString);
            if (number <= 0) {
                throw new IllegalArgumentException("양의 정수가 아닌 입력값을 넣어 오류발생");
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양의 정수가 아닌 입력값을 넣어 오류발생");
    }

    @DisplayName("입력된 값이 숫자인지 확인")
    @Test
    void testCheckInt() {
        String numberString = "5";
        int number = checkInt(numberString);
        assertThat(number).isEqualTo(5);
    }


    private int checkInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력값을 넣어 오류발생");
        }
    }

    @DisplayName("이중 배열에 이름 넣기, 전진여부 확인")
    @Test
    void makeNameList() {
        String name = "1,qwer,qwds,zgqs";
        String[] nameList = name.split(",");
        String[][] output = new String[nameList.length][2];

        for(int i =0; i< output.length; i++){
            output[i][0] = nameList[i];
            output[i][1] = "0";
        }

        assertThat(output).isEqualTo(new String[][]{
                {"1", "0"},
                {"qwer", "0"},
                {"qwds", "0"},
                {"zgqs", "0"}
        });

        decisionGoFowardNumber(output);

        assertThat(output).isEqualTo(new String[][]{
                {"1","0"},
                {"qwer","0"},
                {"qwds","0"},
                {"zgqs","1"}
        });

    }

    private void decisionGoFowardNumber(String[][] output) {
        for(int i =0; i< output.length; i++){
            int randomNumber = 1 + i; //실제로는 랜덤한 숫자가 생성
            int go = decisionGoFoward(randomNumber);
            output[i][1] = String.valueOf(Integer.parseInt(output[i][1]) + go);
        }
    }

    private int decisionGoFoward(int randomNumber) {
        if(randomNumber >= 4) {
            return 1;
        } else{
            return 0;
        }
    }
}