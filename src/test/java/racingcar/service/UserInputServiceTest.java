package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCarEntity;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserInputServiceTest extends NsTest {
    private final UserInputService userInputService = new UserInputService();

    @Test
    void 정상적_입력_테스트(){
        assertSimpleTest(() ->{
            run("pobi,woni,jun");
            List<RacingCarEntity> cars = userInputService.getRacingCarEntities();
            assertThat(cars.get(0).getName().equals("pobi")).isEqualTo(true);
        });
    }

    @Test
    void 유저_빈_값_입력_테스트(){
        assertThatThrownBy(() -> userInputService.inputNottingTest(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 입력");
    }


    @Test
    void 유저_인풋_길이_테스트(){
        assertThatThrownBy(() -> userInputService.inputCarLengthCheck("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유저 인풋 길이 5 초과");
    }

    @Test
    void 유저_숫자_이외_텍스트_입력_테스트(){
        assertSimpleTest(() ->{
            run("삼");
            assertThatThrownBy(() -> userInputService.getTryCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 입력");
        });
    }

    @Test
    void 유저_숫자_이외_빈_값_입력_테스트(){
        assertSimpleTest(() ->{
            run("");
            assertThatThrownBy(() -> userInputService.getTryCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 입력");
        });
    }



    @Override
    protected void runMain() {

    }
}
