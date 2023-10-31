/**
 * @Package_name   : player
 * @Class_name : JudgePlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import display.ConsoleDisplay;
import utility.Const;

import java.util.*;

public class JudgePlayer implements Player{
    // 출력을 위한 display 객체
    ConsoleDisplay display = new ConsoleDisplay();

    // 모든 레이싱플레이어(자동차) 이름, 최종 결과(거리) 해시맵
    private Map<String, Integer> racingPlayerDistanceMap;
    // 모든 레이싱플레이어(자동차) 최종 결과(거리) 리스트
    private ArrayList<String> racingWinnerArr;

    /**
     * Description :  JudgePlayer의 게임 운영
     *
     * @Method : Play()
     */
    @Override
    public void play() {
        judgingWinner();
        sayingWinner();
    }

    /**
     * Description : racingPlayerDistanceMap 값 세팅하기
     *
     * @Method : settingRacingPlayerDistanceMap()
     */
    public void setRacingPlayerDistanceMap(Map<String, Integer> racingPlayerDistanceMap) {
        this.racingPlayerDistanceMap = racingPlayerDistanceMap;
    }

    /**
     * Description : racingPlayerDistanceMap에서 우승자를 가려내 racingWinnerArr에 넣기
     *
     * @Method : judgingWinner()
     */
    public void judgingWinner() {
        racingWinnerArr = new ArrayList<String>();
        Integer maxValue = Collections.max(racingPlayerDistanceMap.values());

        Iterator<String> keys = racingPlayerDistanceMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (racingPlayerDistanceMap.get(key) == maxValue){
                racingWinnerArr.add(key);
            }
        }
    }

    /**
     * Description : racingWinnerArr에 들어 있는 우승자 출력함
     *
     * @Method : sayingWinner()
     */
    public void sayingWinner() {
        display.output(Const.FINAL_WINNER_COMMENT);
        for ( String winner : racingWinnerArr ){
            display.output(winner);
        }
    }
}
