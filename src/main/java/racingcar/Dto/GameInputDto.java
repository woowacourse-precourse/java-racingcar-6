package racingcar.Dto;

import java.util.List;

public class GameInputDto {
    private List<String> carNames;
    private int numberRound;

    public GameInputDto(List<String> carNames, int numberRound) {
        this.carNames = carNames;
        this.numberRound = numberRound;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberRound() {
        return numberRound;
    }

}
