/**
 * @Package_name   : player
 * @Class_name : ManagePlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import java.util.ArrayList;

public class ManagePlayer implements Player {

    // 모든 레이싱플레이어(자동차) 최종 결과(거리) 리스트
    ArrayList<Integer> racingPlayerDistanceArr;

    // 정적 ManagePlayer innstance 변수
    private static ManagePlayer innstance;
    // private 생성자
    private ManagePlayer() {
        racingPlayerDistanceArr = new ArrayList<Integer>();
    }
    // 단독 ManagePlayer(싱글톤)
    public static ManagePlayer getInstance() {
        if (innstance == null) {
            synchronized(ManagePlayer.class) {
                innstance = new ManagePlayer();
            }
        }
        return innstance;
    }

    /**
     * Description :  ManagePlayer의 게임 플레이
     *
     * @Method : Play()
     */
    @Override
    public void play() {
        getRacingDistanceArrFromRacingPlayer();
    }

    /**
     * Description : McPlayer의 RacingPlayer객체리스트를 이용해 거리를 받아 RacingDistanceArr에 저장함
     *
     * @Method : getRacingDistanceArr()
     */
    public void getRacingDistanceArrFromRacingPlayer() {
        for ( RacingPlayer racingPlayer : McPlayer.racingPlayerArr){
            racingPlayerDistanceArr.add(racingPlayer.getRunDistance());
        }
    }

    /**
     * Description : RacingDistanceArr에 저장된 전체 레이싱플레이어(자동차) 최종 결과(거리)를 JudgePlayer에게 전송
     *
     * @Method : giveRacingPlayerDistanceArrToJudgePlayer()
     * @return : ArrayList<Integer>
     */
    public ArrayList<Integer> giveRacingPlayerDistanceArrToJudgePlayer() {
        return racingPlayerDistanceArr;
    }

}
