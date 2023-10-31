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
    // 입출력을 위한 display 객체
    ConsoleDisplay display = new ConsoleDisplay();

    // 전체 레이싱플레이어(자동차)이름 리스트 변수
    private ArrayList<String> racingPlayerNameArr;
    // 전체 레이싱플레이어(자동차)객체 리스트 변수
    public static ArrayList<RacingPlayer> racingPlayerArr;

    // 시도 횟수 변수
    public int tryingNum;

    // 정적 McPlayer innstance 변수
    private static McPlayer innstance;
    // private 생성자
    private McPlayer() {}
    // 단독 McPlayer(싱글톤)
    public static McPlayer getInstance() {
        if (innstance == null) {
            synchronized(McPlayer.class) {
                innstance = new McPlayer();
            }
        }
        return innstance;
    }

    /**
     * Description : McPlayer의 게임 플레이
     *
     * @Method : play()
     */
    @Override
    public void play() {
        sayingRacingPlayerStartCommment();
        gettingRacingPlayerNameArr();
        settingRacingPlayerArr();
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
     * @Method : gettingRacingPlayerNameArr()
     */
    public void gettingRacingPlayerNameArr() {
        String RacingPlayers = display.input();
        String[] RacingPlayersList = RacingPlayers.split(",");
        racingPlayerNameArr = new ArrayList<String>(Arrays.asList(RacingPlayersList));
    }

    /**
     * Description :  레이싱플레이어(자동차) 객체를 생성하기
     *
     * @Method : gettingRacingPlayerArr()
     */
    public void settingRacingPlayerArr() {
        racingPlayerArr = new ArrayList<RacingPlayer>();
        for (String racingPlayerName : racingPlayerNameArr ){
            RacingPlayer newRacingPlayer = new RacingPlayer(racingPlayerName);
            racingPlayerArr.add(newRacingPlayer);
        }
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
