package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RaceRound {
    private static final int DEFAULT_MAX_DISTANCE = 0;
    private final List<PlayerMove> playerMoveList;
    private final MoveFactory moveFactory;

    private RaceRound(final List<PlayerMove> playerMoveList, final MoveFactory moveFactory) {
        this.playerMoveList = playerMoveList;
        this.moveFactory = moveFactory;
    }

    public static RaceRound of(final List<PlayerMove> playerMoveList, final MoveFactory moveFactory) {
        return new RaceRound(playerMoveList, moveFactory);
    }

    public void move() {
        for (PlayerMove playerMove : playerMoveList) {
            boolean isMove = moveFactory.isMove();
            playerMove.move(isMove);
        }
    }

    private int getMaxDistance() {
        int presentMax = DEFAULT_MAX_DISTANCE;
        for (PlayerMove playerMove : playerMoveList) {
            presentMax = playerMove.getMaxDistance(presentMax);
        }
        return presentMax;
    }

    public void checkWinner() {
        int maxDistance = getMaxDistance();
        for (PlayerMove playerMove : playerMoveList) {
            playerMove.checkWinner(maxDistance);
        }
    }

    public List<PlayerMove> getPlayerMoveList() {
        return Collections.unmodifiableList(playerMoveList);
    }
}
