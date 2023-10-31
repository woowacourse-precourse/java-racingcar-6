package racingcar.controller.dto;

import java.util.List;

public class ResponseDto {
    private List<String> results;

    private ResponseDto(List<String> results) {
        this.results = results;
    }

    public static ResponseDto toDto(List<String> results) {
        return new ResponseDto(results);
    }

    public List<String> getResults() {
        return results;
    }
}
