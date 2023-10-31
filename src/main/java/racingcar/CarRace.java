/**
 * @Package_name   : racingCar
 * @Class_name : CarRace
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package racingcar;

import player.*;

import java.util.ArrayList;

public class CarRace {
    /**
     * Description : 자동차 경주 진행 중심 프로세스 코드
     *
     * @Method : carRacing()
     */
    public void carRacing(){
        McPlayer mcPlayer = new McPlayer();
        JudgePlayer judgePlayer = new JudgePlayer();
        ManagePlayer managePlayer = new ManagePlayer(mcPlayer, judgePlayer);

        mcPlayer.play(); // 자동차이름, 시도 횟수를 요청하고, 입력받기
        managePlayer.play(); // mcPlayer에게 자동차리스트를 받아 자동차들을 이동시키고 최종 거리를 judgePlayer에게 전달
        judgePlayer.play(); // 우승자를 가려내고, 출력함

    }
}
