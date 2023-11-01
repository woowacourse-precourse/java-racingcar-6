package racingcar.dto;

import java.util.List;

public record NamesRequestDto(List<String> names) {

    public static NamesRequestDto createNamesRequestDto(List<String> names) {
        return new NamesRequestDto(names);
    }
}
