package racingcar.domain.dto;

import racingcar.domain.Name;
import racingcar.domain.Position;

import java.util.List;
import java.util.stream.Collectors;

public record RoundResult(
        List<CarResult> carResultList
) {
    public static RoundResult of(List<CarResult> carResultList) {
        return new RoundResult(carResultList);
    }

    public List<Name> getWinner() {
        Position highestPosition = getHighestPosition();

        return carResultList.stream()
                .filter(carResult -> carResult.isSamePosition(highestPosition))
                .map(CarResult::name)
                .toList();
    }

    private Position getHighestPosition(){
        return carResultList.stream()
                .map(CarResult::position)
                .max(Position::compareTo)
                .get();
    }

    @Override
    public String toString() {
        return carResultList.stream()
                .map(CarResult::toString)
                .collect(Collectors.joining("\n")) +
                "\n";
    }
}

