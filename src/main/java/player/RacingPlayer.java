/**
 * @Package_name   : player
 * @Class_name : RacingPlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import static utility.Const.FORWARD_CONDITION_NUMBER;
import utility.Utility;

public class RacingPlayer implements Player{
    // 레이싱플레이어(자동차) 이름 변수
    public String racerName;
    // 레이싱플레이어(자동차)가 달린 거리 변수
    private int runDistance;

    // 기본생성자
    public RacingPlayer(){}
    // 이름 매개변수 생성자
    public RacingPlayer(String RacingPlayerName){
        runDistance = 0;
    }

    /**
     * Description :  게임 참여자들의 게임 운영
     *
     * @Method : Play()
     */
    @Override
    public void play() {
        runingCarRandom();
    }

    /**
     * Description :  Utility에서 campPickNumberInRange를 이용하여 전진여부를 결정
     *
     * @Method : runingCarRandom()
     */
    private void runingCarRandom(){
        int randomNum = Utility.campPickNumberInRange();
        if(randomNum >= FORWARD_CONDITION_NUMBER){
            runDistance += 1;
        }
    }

    /**
     * Description :  레이싱플레이어(자동차)가 달린 거리 runDistance를 반환
     *
     * @Method : getRunDistance()
     * @return : int
     */
    public int getRunDistance(){
        return runDistance;
    }
}
