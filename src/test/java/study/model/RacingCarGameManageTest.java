package study.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingCarGameManage;

import java.util.ArrayList;
import java.util.HashMap;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class RacingCarGameManageTest {

    ArrayList<Car> playerCarNameList = new ArrayList<>();
    RacingCarGameManage racingCarGameManage = new RacingCarGameManage();

    @DisplayName("사용자 랜덤 숫자 생성")
    @Test
    void getPlayerRandomNumber() {
        playerCarNameList.add(new Car("pobi"));
        playerCarNameList.add(new Car("jk"));
        playerCarNameList.add(new Car("woni"));

        HashMap<String, Integer> playerRandomNumber
                = racingCarGameManage.getPlayerRandomNumber(playerCarNameList);

        assertThat(playerRandomNumber.get("pobi")).isBetween(0, 9);
        assertThat(playerRandomNumber.get("jk")).isBetween(0, 9);
        assertThat(playerRandomNumber.get("woni")).isBetween(0, 9);
    }

    @DisplayName("단독 우승자인 경우")
    @Test
    void getWinner_One() {
        HashMap<String, Integer> playerRandomNumber = new HashMap<>();
        playerRandomNumber.put("pobi", 4);
        playerRandomNumber.put("jk", 5);
        playerRandomNumber.put("woni", 6);

        ArrayList<Car> winnerList = racingCarGameManage.getWinner(playerRandomNumber);

        assertThat(winnerList.get(0).getName()).isEqualTo("woni");
        assertThat(winnerList.size()).isEqualTo(1);
    }

    @DisplayName("공동 우승자인 경우")
    @Test
    void getWinner_Two() {
        HashMap<String, Integer> playerRandomNumber = new HashMap<>();
        playerRandomNumber.put("pobi", 4);
        playerRandomNumber.put("jk", 4);
        playerRandomNumber.put("woni", 3);

        ArrayList<Car> winnerList = racingCarGameManage.getWinner(playerRandomNumber);

        assertThat(winnerList.get(0).getName()).isEqualTo("jk");
        assertThat(winnerList.get(1).getName()).isEqualTo("pobi");
        assertThat(winnerList.size()).isEqualTo(2);
    }
}