package study.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCarGameManage;

import java.util.ArrayList;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class RacingCarGameManageTest {

    ArrayList<String> playerCarNameList = new ArrayList<>();
    RacingCarGameManage racingCarGameManage = new RacingCarGameManage();

    @DisplayName("사용자 랜덤 숫자 생성")
    @Test
    void getPlayerRandomNumber() {
        playerCarNameList.add("pobi");
        playerCarNameList.add("jk");
        playerCarNameList.add("woni");

        HashMap<String, Integer> playerRandomNumber
                = racingCarGameManage.getPlayerRandomNumber(playerCarNameList);

        assertThat(playerRandomNumber.get("pobi")).isBetween(0, 9);
        assertThat(playerRandomNumber.get("jk")).isBetween(0, 9);
        assertThat(playerRandomNumber.get("woni")).isBetween(0, 9);
    }
}