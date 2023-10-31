/**
 * @Package_name   : player
 * @Class_name : JudgePlayer
 *
 * Create Date : 2023-10-31
 * Create User : 정은채
 */
package player;

import java.util.ArrayList;

public class JudgePlayer {
    // 정적 JudgePlayer innstance 변수
    private static JudgePlayer innstance;
    // private 생성자
    private JudgePlayer() {}
    // 단독 JudgePlayer(싱글톤)
    public static JudgePlayer getInstance() {
        if (innstance == null) {
            synchronized(JudgePlayer.class) {
                innstance = new JudgePlayer();
            }
        }
        return innstance;
    }
}
