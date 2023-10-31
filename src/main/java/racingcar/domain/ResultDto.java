package racingcar.domain;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ResultDto {
    private final Map<BigInteger, SingleRoundResultDto> resultDtoByRound = new HashMap<>();
    private final BigInteger finalRound;

    public ResultDto(BigInteger finalRound) {
        this.finalRound = finalRound;
    }

    public void addSingleRoundResult(BigInteger round, SingleRoundResultDto singleRoundResultDto) {
        resultDtoByRound.put(round, singleRoundResultDto);
    }

    public BigInteger getFinalRound() {
        return finalRound;
    }

    public SingleRoundResultDto getSingleRoundResultDto(BigInteger round) {
        return resultDtoByRound.get(round);
    }
}
