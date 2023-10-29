package racingcar;

import java.util.List;

public class PlayerMoveList {
    private final List<PlayerMove> playerMoveList;
    private final MoveFactory moveFactory;

    public PlayerMoveList(List<PlayerMove> playerMoveList, MoveFactory moveFactory) {
        this.playerMoveList = playerMoveList;
        this.moveFactory = moveFactory;
    }

    public static PlayerMoveList from(List<PlayerMove> playerMoveList, MoveFactory moveFactory) {
        return new PlayerMoveList(playerMoveList, moveFactory);
    }

    public void move() {
        for (PlayerMove playerMove : playerMoveList) {
            playerMove.move(moveFactory.isMove());
        }
    }

    public List<PlayerMove> getPlayerMoveList() {
        return playerMoveList;
    }
}
