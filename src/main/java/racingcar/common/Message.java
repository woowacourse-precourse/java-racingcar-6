package racingcar.common;

import racingcar.entity.Car;

import java.util.List;

public enum Message {
    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    DISTANCE("name : distance"),
    WINNER("최종 우승자 : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getDistance(Car car) {
        return DISTANCE.message.replace("name", car.getName())
                .replace("distance", "-".repeat(car.getDistance()));
    }

}
