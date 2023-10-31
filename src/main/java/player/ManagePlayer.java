/**
 * @Package_name   : player
 * @Class_name : ManagePlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import display.ConsoleDisplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static utility.Const.DISTANCE_BAR;
import static utility.Const.EXECUTION_COMMENT;
import static utility.Const.BETWEEN_RACING_PLAYER_NAME;
import static utility.Const.CHANGING_LINE;

public class ManagePlayer implements Player {
    // 출력을 위한 display 객체
    ConsoleDisplay display = new ConsoleDisplay();

    // 모든 레이싱플레이어(자동차) 이름, 결과(거리) 해시맵
    Map<String, Integer> racingPlayerDistanceMap;

    // ManagePlayer가 컨택하는 McPlayer,JudgePlayer 객체
    McPlayer mcPlayer;
    JudgePlayer judgePlayer;
    // 전체 레이싱플레이어(자동차)객체 리스트 변수
    ArrayList<RacingPlayer> racingPlayerArr;

    //기본생성자
    public ManagePlayer(){}
    // 매개변수 생성자 (mcPlayer,judgePlayer)
    public ManagePlayer(McPlayer mcPlayer, JudgePlayer judgePlayer){
        this.mcPlayer = mcPlayer;
        this.judgePlayer = judgePlayer;
        this.racingPlayerArr = mcPlayer.getracingPlayerArr();
        racingPlayerDistanceMap = new HashMap<String, Integer>();
    }

    /**
     * Description :  ManagePlayer의 게임 플레이
     *
     * @Method : Play()
     */
    @Override
    public void play() {
        manageRacingPlayerPlay();
        giveRacingPlayerDistanceArrToJudgePlayer();
    }

    /**
     * Description : 시도 횟수만큼 레이싱플레이어(자동차) play 시키기
     *
     * @Method : manageRacingPlayerPlay()
     */
    public void manageRacingPlayerPlay() {
        display.output(EXECUTION_COMMENT);
        int tryingNum = mcPlayer.getTryingNum();
        while(tryingNum > 0) {
            for (RacingPlayer racingPlayer : mcPlayer.getracingPlayerArr()) {
                racingPlayer.play();
                getRacingDistanceArrFromRacingPlayer();
                sayingRacingDistance();
            }
            tryingNum--;
        }
    }

    /**
     * Description : McPlayer의 getracingPlayerArr()를 이용해 거리를 받아 RacingDistanceArr에 저장(갱신)
     *
     * @Method : getRacingDistanceArr()
     */
    public void getRacingDistanceArrFromRacingPlayer() {
        for (RacingPlayer racingPlayer : racingPlayerArr) {
            racingPlayerDistanceMap.put(racingPlayer.racerName, racingPlayer.getRunDistance());
        }
    }

    /**
     * Description :
     *
     * @Method :sayingRacingDistance()
     */
    public void sayingRacingDistance() {
        for (String key : racingPlayerDistanceMap.keySet()) {
            display.output(key + BETWEEN_RACING_PLAYER_NAME);
            display.output(DISTANCE_BAR.repeat(racingPlayerDistanceMap.get(key)));
            display.output(CHANGING_LINE);
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
