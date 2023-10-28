package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
    }
}

class RacingGame {
    String CAR_NAME_INSERT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String ASK_NUMBER_OF_GAME_MESSAGE = "시도할 회수는 몇회인가요?";
    String GAME_RESULT_MESSAGE = "실행 결과";
    String GAME_WINNER_REPORT = "최종 우승자 : ";

    RacingGame() {
        Game();
    }

    private void Game() {
        System.out.println(CAR_NAME_INSERT_MESSAGE);
        String[] cars = InputConvert.carInput(readLine());
        Error_Exception.carNameLengthCheck(cars);
        System.out.println(ASK_NUMBER_OF_GAME_MESSAGE);
        int numOfTry = InputConvert.numInput(readLine());
        Cars carData = new Cars(cars);

        System.out.println("\n" + GAME_RESULT_MESSAGE);
        for (int i = 0; i < numOfTry; i++) {
            carData.move_cars();
        }

        System.out.print(GAME_WINNER_REPORT);
        carData.report_winner();
    }
}

class InputConvert {
    public static int numInput(String input) {
        Error_Exception.numofTryCheck(input);
        return charArr2Int(str2CharArr(input));
    }

    public static String[] carInput(String input) {
        return input.split(",", -1);
    }

    static char[] str2CharArr(String input) {
        char[] c = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            c[i] = input.charAt(i);
        }
        return c;
    }

    static int charArr2Int(char[] arr) {
        int num = 0;
        for (char c : arr) {
            int digit = c - '0';
            num *= 10;
            num += digit;
        }
        return num;
    }
}

class Cars {
    public static int[] moved;
    public static String[] cars;

    Cars(String[] car_input) {
        cars = new String[car_input.length];
        insert_cars(car_input);
        moved = new int[car_input.length];
    }

    static void insert_cars(String[] car_input) {
        for (int i = 0; i < car_input.length; i++) {
            cars[i] = car_input[i];
        }
    }

    static void move_cars() {
        for (int i = 0; i < cars.length; i++) {
            move_car(i);
        }
        show_moved();
    }

    static void move_car(int i) {
        int randNum = Randoms.pickNumberInRange(0, 9);
        if (randNum >= 4) {
            moved[i]++;
        }
    }

    static void show_moved() {
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " : ");
            for (int j = 0; j < moved[i]; j++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void report_winner() {
        boolean[] winner = check_winner();
        boolean first_winner = true;
        String winner_str = "";
        for (int i = 0; i < winner.length; i++) {
            if (winner[i] && first_winner) {
                winner_str += cars[i];
                first_winner = false;
            } else if (winner[i]) {
                winner_str += ", " + cars[i];
            }
        }
        System.out.println(winner_str);
    }

    static boolean[] check_winner() {
        boolean[] winner = new boolean[moved.length];
        int winner_moved = check_most_moved();
        for (int i = 0; i < moved.length; i++) {
            winner[i] = (moved[i] == winner_moved);
        }

        return winner;
    }

    static int check_most_moved() {
        int max = 0;
        for (int i : moved) {
            max = i > max ? i : max;
        }
        return max;
    }
}

class Error_Exception {
    static String LONG_CAR_NAME_ERROR = "자동차 이름은 5자 이하만 가능합니다.";
    static String NUM_OF_TRY_NOT_NUM = "횟수는 정수를 입력해야 합니다.";

    static void carNameLengthCheck(String[] str) {
        for (String s : str) {
            if (s.length() > 5) {
                throw new IllegalArgumentException(LONG_CAR_NAME_ERROR);
            }
        }
    }

    static void numofTryCheck(String str) {
        char[] input = InputConvert.str2CharArr(str);
        for (char c : input) {
            if (c - '0' <= 0 || c - '0' >= 9) {
                throw new IllegalArgumentException(NUM_OF_TRY_NOT_NUM);
            }
        }
    }
}