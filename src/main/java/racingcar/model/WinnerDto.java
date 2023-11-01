package racingcar.model;

import java.util.List;

public class WinnerDto {
    private List<String> winner;
    public WinnerDto(List<String> winner){
        this.winner = winner;
    }

    public List<String> getWinner(){
        return winner;
    }
}
