/**
 * @Package_name : player
 * @Class_name : McPlayer
 * <p>
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import java.util.ArrayList;
import java.util.Arrays;


import display.ConsoleDisplay;

import static utility.Const.RACING_PLAYER_NAME_START_COMMENT;
import static utility.Const.DIVIDE_RACING_PLAYER_NAME;
import static utility.Const.TRYING_NUMBER_START_COMMENT;
import static utility.Const.CHANGING_LINE;

public class McPlayer implements Player {
    // 입출력을 위한 display 객체
    ConsoleDisplay display = new ConsoleDisplay();

    // 전체 레이싱플레이어(자동차)이름 리스트 변수
    private ArrayList<String> racingPlayerNameArr;
    // 전체 레이싱플레이어(자동차)객체 리스트 변수
    private ArrayList<RacingPlayer> racingPlayerArr;

    // 시도 횟수 변수
    public int tryingNum;

    /**
     * Description : McPlayer의 게임 플레이
     *
     * @Method : play()
     */
    @Override
    public void play() {
        outputRacingPlayerStartCommment();
        inputRacingPlayerNameArr();
        setRacingPlayerArr();
        outputTryingNumStartCommment();
        inputTryingNum();
    }

    /**
     * Description : 레이싱플레이어(자동차) 이름을 입력받기 위한 게임 시작 문구 출력
     *
     * @Method : outputRacingPlayerStartCommment()
     */
    public void outputRacingPlayerStartCommment() {
        display.output(RACING_PLAYER_NAME_START_COMMENT);
    }

    /**
     * Description :  레이싱플레이어(자동차) 이름을 입력받음
     *
     * @Method : inputRacingPlayerNameArr()
     */
    public void inputRacingPlayerNameArr() {
        String RacingPlayers = display.input();
        String[] RacingPlayersList = RacingPlayers.split(DIVIDE_RACING_PLAYER_NAME);
        racingPlayerNameArr = new ArrayList<String>(Arrays.asList(RacingPlayersList));
        checkNameCondition();
    }

    /**
     * Description :  레이싱플레이어(자동차) 이름 - "이름은 5자 이하만 가능" 조건 처리
     *
     * @Method : checkNameCondition()
     */
    public void checkNameCondition() throws IllegalArgumentException {
        int NameLengthMax = 5;
        for (String racingPlayerName : racingPlayerNameArr) {
            if (racingPlayerName.length() > NameLengthMax) {
                throw new IllegalArgumentException();
            }
        }
    }


    /**
     * Description :  레이싱플레이어(자동차) 객체를 생성
     *
     * @Method : setRacingPlayerArr()
     */
    public void setRacingPlayerArr() {
        racingPlayerArr = new ArrayList<RacingPlayer>();
        for (String racingPlayerName : racingPlayerNameArr) {
            RacingPlayer newRacingPlayer = new RacingPlayer(racingPlayerName);
            racingPlayerArr.add(newRacingPlayer);
        }
    }

    /**
     * Description : 시도할 횟수를 입력받기 위한 게임 시작 문구 출력
     *
     * @Method : outputTryingNumStartCommment()
     */
    public void outputTryingNumStartCommment() {
        display.output(TRYING_NUMBER_START_COMMENT);
    }

    /**
     * Description :  시도할 횟수를 입력받음
     *
     * @Method : inputTryingNum()
     */
    public void inputTryingNum() {
        tryingNum = Integer.parseInt(display.input());
        display.output(CHANGING_LINE);
        checkTryingNumCondition();
    }

    /**
     * Description :  시도할 횟수 - 1 이상이어야 함 조건 처리
     *
     * @Method : checkTryingNumCondition()
     */
    public void checkTryingNumCondition() throws IllegalArgumentException {
        int NameLengthMin = 1;
        if (tryingNum < NameLengthMin) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Description :  racingPlayerArr( 레이싱플레이어(자동차) 객체 리스트)를 반환
     *
     * @Method : getRacingPlayerArr()
     * @Return : ArrayList<RacingPlayer>
     */
    public ArrayList<RacingPlayer> getRacingPlayerArr() {
        return this.racingPlayerArr;
    }

    /**
     * Description :  TryingNum(시도할 횟수)를 반환
     *
     * @Method : getTryingNum()
     * @Return : int
     */
    public int getTryingNum() {
        return this.tryingNum;
    }
}
