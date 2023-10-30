package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    static String carNameBeforeSplit, stringNumberOfMoves;
    static ArrayList<String> carList;
    static int numberOfMoves;

    public static void main(String[] args) {

        // 게임 시작 후 안내 문구와 함께 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameBeforeSplit = readLine();

        // 입력 받은 자동차 이름 에러를 확인하며 스플릿 작업 같이 진행하기
        check_error_carname(carNameBeforeSplit);

        // 시도할 횟수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        stringNumberOfMoves = readLine();

        // 입력 받은 횟수 에러 확인하기
        numberOfMoves = check_error_numberofmoves(stringNumberOfMoves);

        System.out.println(carList);
        System.out.println(numberOfMoves);
    }

    public static void make_name_split() {
        // 입력 받은 문자열을 쉼표를 기준으로 구분하여 자동차 이름 저장하기
        String[] carNameAfterSplit = carNameBeforeSplit.split(",");
        carList = new ArrayList<String>(Arrays.asList(carNameAfterSplit));

    }

    public static void check_error_carname(String input) {

        // 에러 상황 나누기
        // 1. 빈 문자를 입력한 경우
        // 2. 자동차 이름이 1글자~5글자 아닌 경우 -> 스플릿 작업을 1번만 하기 위해 에러 체크 시 진행하기로 결정
        // 3. 같은 이름의 자동차를 입력한 경우

        int inputLength = input.length();

        // 자동차 이름의 길이를 판단하기 위해 스플릿 작업이 필요하여 이곳에서 스플릿 함수 실행
        make_name_split();

        if (inputLength == 0) {
            throw new IllegalArgumentException("문자를 입력해주세요.");
        }

        for (String carName : carList) {
            if (carName.length() >= 6) {
                throw new IllegalArgumentException("자동차 이름의 길이는 1부터 5까지입니다.");
            }
        }

        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 자동차의 이름이 포함되어있습니다.");
        }

    }

    public static int check_error_numberofmoves(String input) {

        // 숫자를 입력하지 않은 경우 예외 처리
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
        return Integer.parseInt(input);
    }

}
