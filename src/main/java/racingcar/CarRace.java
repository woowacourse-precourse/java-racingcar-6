/**
 * @Package_name   : racingCar
 * @Class_name : CarRace
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package racingcar;

import player.McPlayer;

public class CarRace {
    /**
     * Description : 자동차 경주 진행 중심 프로세스 코드
     *
     * @Method : carRacing()
     */
    public void carRacing(){
        McPlayer McPlayer = new McPlayer();
        McPlayer.play(); // 자동차이름, 시도 횟수 받기
    }
}
