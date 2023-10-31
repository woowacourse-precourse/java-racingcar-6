/**
 * @Package_name   : player
 * @Class_name : ManagePlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagePlayer implements Player {

    // 모든 레이싱플레이어(자동차) 이름, 최종 결과(거리) 해시맵
    Map<String, Integer> racingPlayerDistanceMap;

    // ManagePlayer가 컨택하는 McPlayer,JudgePlayer 객체
    McPlayer mcPlayer;
    JudgePlayer judgePlayer;

    //기본생성자
    public ManagePlayer(){}
    // 매개변수 생성자 (mcPlayer,judgePlayer)
    public ManagePlayer(McPlayer mcPlayer, JudgePlayer judgePlayer){
        this.mcPlayer = mcPlayer;
        this.judgePlayer = judgePlayer;
    }

    /**
     * Description :  ManagePlayer의 게임 플레이
     *
     * @Method : Play()
     */
    @Override
    public void play() {
        getRacingDistanceArrFromRacingPlayer();
        giveRacingPlayerDistanceArrToJudgePlayer();
    }

    /**
     * Description : McPlayer의 getracingPlayerArr()를 이용해 거리를 받아 RacingDistanceArr에 저장함
     *
     * @Method : getRacingDistanceArr()
     */
    public void getRacingDistanceArrFromRacingPlayer() {
        for ( RacingPlayer racingPlayer : mcPlayer.getracingPlayerArr()){
            racingPlayerDistanceMap.put(racingPlayer.racerName, racingPlayer.runDistance);
        }
    }

    /**
     * Description : RacingDistanceArr에 저장된 전체 레이싱플레이어(자동차) 최종 결과(거리)를 JudgePlayer에게 전송
     *
     * @Method : giveRacingPlayerDistanceArrToJudgePlayer()
     */
    public void giveRacingPlayerDistanceArrToJudgePlayer() {
        judgePlayer.setRacingPlayerDistanceMap(this.racingPlayerDistanceMap);
    }

}
