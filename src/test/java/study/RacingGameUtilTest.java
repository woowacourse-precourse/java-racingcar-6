package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.RacingGame.RacingGameUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameUtilTest {

    @Test
    void RacingGameUtil_생성자체크(){
        List<String> userList = generateUserList();

        RacingGameUtil racingGameUtil = new RacingGameUtil(userList);
        assertThat(racingGameUtil.getUserStatus().size()).isEqualTo(3); // 3개가 모두 Map에 들어갔나?
        assertThat(racingGameUtil.getUserStatus().get("pobi")).isEqualTo(0); // Key에 해당하는 Value는 0인가?
    }



    @Test
    void RaingGameUtil_최종유저정보_테스트(){
        List<String> userList = generateUserList();
        RacingGameUtil racingGameUtil = new RacingGameUtil(userList);


        List<String> winnerList = new ArrayList<>();
        for(Map.Entry<String, Integer> userRecord: racingGameUtil.getUserStatus().entrySet()){
            if(userRecord.getKey() == "pobi")
                userRecord.setValue(userRecord.getValue() + 5);
        }

        // 해당 셋에서 가장 기록이 높은 인원의 기록을 제대로 가져오는가?
        assertThat(racingGameUtil.getWinnerRecord()).isEqualTo(5);

        for(Map.Entry<String, Integer> userRecord: racingGameUtil.getUserStatus().entrySet()){
            racingGameUtil.addHighScoreUser(winnerList, userRecord, racingGameUtil.getWinnerRecord());
        }

        // winnerList가 제대로 만들어졌는가? 우승자 == pobi
        assertThat(winnerList.size()).isEqualTo(1);
        assertThat(winnerList.get(0)).isEqualTo("pobi");
    }

    public List<String> generateUserList(){

        List<String> userList = new ArrayList<>();
        userList.add("pobi");
        userList.add("poni");
        userList.add("pozi");

        return userList;
    }
}
