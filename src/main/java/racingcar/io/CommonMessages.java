package racingcar.io;



import racingcar.game.Car;

import java.util.List;

public enum CommonMessages {
    READ_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    READ_TRIAL("시도할 회수는 몇회인가요?"),
    GAME_RESULT("실행 결과");

    private String message;

    CommonMessages(String message) {
        this.message = message;
    }

    public static String roundResult(List<Car> carList) {
        StringBuilder sb = new StringBuilder();

        carList.stream().forEach(car -> {
            sb.append(car.getName() + " : " + car.getDistance() + "\n");
        });

        return sb.toString();
    }

    public static String printWinner(List<String> winnerList) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");

        int size = winnerList.size();
        for(int idx = 0; idx < size; idx++) {
            if(idx == size - 1) {
                sb.append(winnerList.get(idx));
            }else {
                sb.append(winnerList.get(idx)).append(", ");
            }
        }

        return sb.toString();
    }

    public String getMessage() {
        return this.message;
    }

}


