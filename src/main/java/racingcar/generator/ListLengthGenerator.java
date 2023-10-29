package racingcar.generator;

import java.util.List;

import static racingcar.entity.Participantes.InputParticipantes;

public class ListLengthGenerator {
    public static int count(List<String> participantes) {
        int cars = participantes.size();
        return cars;
    }
}
