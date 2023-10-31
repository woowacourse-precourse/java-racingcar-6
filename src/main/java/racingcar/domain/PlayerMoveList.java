package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class PlayerMoveList {
    private final List<PlayerMove> playerMoveList;
    private final MoveFactory moveFactory;

    public PlayerMoveList(final List<PlayerMove> playerMoveList, final MoveFactory moveFactory) {
        this.playerMoveList = playerMoveList;
        this.moveFactory = moveFactory;
    }

    public static PlayerMoveList of(List<PlayerMove> playerMoveList, MoveFactory moveFactory) {
        return new PlayerMoveList(playerMoveList, moveFactory);
    }

    public void move() {
        for (PlayerMove playerMove : playerMoveList) {
            playerMove.move(moveFactory.isMove());
        }
    }

    public int getMaxDistance() {
        int max = 0;
        for (PlayerMove playerMove : playerMoveList) {
            max = playerMove.getMaxDistance(max);
        }
        return max;
    }

    public void checkWinner() {
        int maxDistacne = getMaxDistance();
        for (PlayerMove playerMove : playerMoveList) {
            playerMove.checkWinner(maxDistacne);
        }
    }

    public List<PlayerMove> getPlayerMoveList() {
        return Collections.unmodifiableList(playerMoveList);
    }
}
