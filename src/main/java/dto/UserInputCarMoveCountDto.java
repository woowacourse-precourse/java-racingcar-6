package dto;

public class UserInputCarMoveCountDto {

    private long moveCount;

    public UserInputCarMoveCountDto(long moveCount){
        this.moveCount = moveCount;
    }

    public long getMoveCount(){
        return moveCount;
    }
}
