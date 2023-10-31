package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.controller.GenerateRandomNum;
import racingcar.model.GameMember;
import racingcar.validator.InputValidator;

import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private InputValidator inputValidator = new InputValidator();
    private GameMember gameMember = new GameMember();
    private GenerateRandomNum generateRandomNum = new GenerateRandomNum();


    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }
    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void insertTestData(){
        String input = "김동휘,김동동, 김김김";
        List<String> result = inputValidator.toValidateData(input);
        assertThat(result).contains("김동휘", "김동동","김김김");

        input = "김동휘, 김 동 동, 김 김    김";
        result = inputValidator.toValidateData(input);
        assertThat(result).contains("김동휘", "김동동","김김김");

        input = " 김 동휘 , 김 동 동, 김 김    김";
        result = inputValidator.toValidateData(input);
        assertThat(result).contains("김동휘", "김동동","김김김");
    }

    @Test
    void initialInsertPlayerKeyAndValue(){
        String input = "김동휘";
        gameMember.setHs(inputValidator.toValidateData(input));

        assertThat(gameMember.getHs().get(input)).isEqualTo("");
        assertThat(gameMember.getHs().size()).isEqualTo(1);
    }

    @Test
    void wrongNameTest(){
        String input = "김김덩동휘휘";
        assertThatThrownBy(() -> gameMember.setHs(inputValidator.toValidateData(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void movingForwardTest(){
        String input = "김동휘";
        gameMember.setHs(inputValidator.toValidateData(input));
        assertThat(gameMember.getHs().get(input)).isEqualTo("");
        if(generateRandomNum.pickNum(5)){
            gameMember.setDuringGame(input);
            assertThat(gameMember.getHs().get(input)).isEqualTo("-");
        }
        if(generateRandomNum.pickNum(5)){
            gameMember.setDuringGame(input);
            assertThat(gameMember.getHs().get(input)).isEqualTo("--");
        }
        if(generateRandomNum.pickNum(3)){
            gameMember.setDuringGame(input);
            assertThat(gameMember.getHs().get(input)).isEqualTo("--");
        }
        assertThat(gameMember.getHs().get(input)).isEqualTo("--");

    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
