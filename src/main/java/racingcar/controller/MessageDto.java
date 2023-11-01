package racingcar.controller;

public class MessageDto {
    private String message;

    public MessageDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String setMessage(String message) {
        return this.message = message;
    }
}
