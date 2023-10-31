/**
 * @Package_name   : player
 * @Class_name : McPlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import display.ConsoleDisplay;
import utility.Const;

import java.util.ArrayList;
import java.util.Arrays;

public class McPlayer implements Player{
    ConsoleDisplay display = new ConsoleDisplay();

    // 전체 경주자 리스트 변수
    public ArrayList<String> racingPlayerArr;

    // 시도 횟수 변수
    public int tryingNum;

    /**
     * Description : McPlayer의 게임 플레이
     *
     * @Method : play()
     */
    @Override
    public void play() {
        sayingRacingPlayerStartCommment();
        gettingRacingPlayerArr();
        sayingTryingNumStartCommment();
        gettingTryingNum();
    }

    /**
     * Description : 레이싱플레이어(자동차) 이름을 입력받기 위한 게임 시작 문구 출력하기
     *
     * @Method : sayingRacingPlayerStartCommment()
     */
    public void sayingRacingPlayerStartCommment() {
        display.output(Const.RACING_PLAYER_NAME_START_COMMENT);
    }

    /**
     * Description :  레이싱플레이어(자동차) 이름을 입력받기
     *
     * @Method : gettingRacingPlayerArr()
     */
    public void gettingRacingPlayerArr() {
        String RacingPlayers = display.input();
        String[] RacingPlayersList = RacingPlayers.split(",");
        racingPlayerArr = new ArrayList<String>(Arrays.asList(RacingPlayersList));
    }

    /**
     * Description : 시도할 횟수를 입력받기 위한 게임 시작 문구 출력하기
     *
     * @Method : sayingTryingNumStartCommment()
     */
    public void sayingTryingNumStartCommment() {
        display.output(Const.TRYING_NUMBER_START_COMMENT);
    }

    /**
     * Description :  시도할 횟수를 입력받기
     *
     * @Method : gettingTryingNum()
     */
    public void gettingTryingNum() {
        tryingNum = Integer.parseInt(display.input());
    }
}
