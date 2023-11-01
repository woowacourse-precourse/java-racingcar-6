package racingcar;

import java.util.ArrayList;

public class Constant {
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int MORE_THAN_FOUR = 4;
    public static final int MAX_NAME_SIZE = 5;
    public static final String SEPARATOR = ",";
    public static final String SEPARATOR_STATUS = " : ";
    public static final String SEPARATOR_WINNER = ", ";
    public static final String CAR_DISTANCE = "-";


    public static ArrayList<String> carsNames = new ArrayList<String>();

    public static final String GET_CARS_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    public static final String GET_PLAY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String PLAY_RESULT_MESSAGE = "\n실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
}
