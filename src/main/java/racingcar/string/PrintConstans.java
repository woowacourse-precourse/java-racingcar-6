package racingcar.string;

public class PrintConstans {
    public static String MSG_SITUATION_PROCESS_ONE_CAR(String nameOfRaceCar, String moveStateStrOfRaceCar) {
        return nameOfRaceCar + " : " + moveStateStrOfRaceCar;
    }

    public static String MSG_NAME_WINNER_CAR_RACE(String carOfWinnerFinal) {
        return "최종 우승자 : " + carOfWinnerFinal;
    }

    public static String MSG_INPUT_NAME_RACE_CARS() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public static String MSG_INPUT_COUNT_TRY_GAME() {
        return "시도할 회수는 몇회인가요?";
    }

    public static String MSG_PROCESS_RESULT() {
        return "실행 결과";
    }
}
