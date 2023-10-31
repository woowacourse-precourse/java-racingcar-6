package study.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.PlayerInputManage;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerInputManageTest {

    ArrayList<Car> playerCarNameList = new ArrayList<>();

    @DisplayName("자동차 이름 길이 체크")
    @Test
    void checkCarNameLength() {
        playerCarNameList.add(new Car("pobi"));
        playerCarNameList.add(new Car("j"));
        playerCarNameList.add(new Car("honuxy"));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerInputManage.CheckCarNameLength(playerCarNameList))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @DisplayName("자동차 이름 중복 체크")
    @Test
    void checkCarNameDuplication() {
        playerCarNameList.add(new Car("pobi"));
        playerCarNameList.add(new Car("j"));
        playerCarNameList.add(new Car("pobi"));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerInputManage.CheckCarNameDuplication(playerCarNameList))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도 횟수 체크")
    @Test
    void checkCountInput() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerInputManage.CheckCountInput("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }



    @DisplayName("자동차 이름 문자 체크")
    @Test
    void checkCheckCarName() {
        playerCarNameList.clear();
        playerCarNameList.add(new Car("pobi"));
        playerCarNameList.add(new Car("j"));
        playerCarNameList.add(new Car("te123"));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerInputManage.CheckCarName(playerCarNameList))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}