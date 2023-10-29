package racingcar.string;

public class MyConstans {
    public static String MSG_SITUATION_PROCESS_ONE_CAR(String nameOfRaceCar, String moveStateStrOfRaceCar) {
        return nameOfRaceCar + " : " + moveStateStrOfRaceCar;
    }

    public static String MSG_NAME_WINNER_CAR_RACE(String carOfWinnerFinal) {
        return "최종 우승자 : " + carOfWinnerFinal;
    }
}
