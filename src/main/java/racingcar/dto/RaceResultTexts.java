package racingcar.dto;

import java.util.List;

public record RaceResultTexts(List<String> results) {
    public String convertOneLine() {
        return String.join("", results);
    }

    public String convertTotalOneLine() {
        return String.join("\n", results);
    }
}
