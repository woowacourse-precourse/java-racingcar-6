package dto;

public class UserInputCarMoveCountDto {

    private int moveCount;

    public UserInputCarMoveCountDto(int moveCount){
        this.moveCount = moveCount;
    }

    public int getMoveCount(){
        return moveCount;
    }
}
