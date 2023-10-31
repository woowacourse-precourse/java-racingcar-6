/**
 * @Package_name   : player
 * @Class_name : RacingPlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

public class RacingPlayer implements Player{
    //
    public String racerName;
    public int runDistance;

    // 기본생성자
    public RacingPlayer(){}
    // 이름 생성자
    public RacingPlayer(String RacingPlayerName){}

    /**
     * Description :  게임 참여자들의 게임 운영
     *
     * @Method : Play()
     */
    @Override
    public void play() {

    }

    public int getRunDistance(){

        return 0;
    }
}
