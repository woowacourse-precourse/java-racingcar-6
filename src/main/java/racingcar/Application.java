package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    static List<Pair<String, Integer>> carInfoList;
    static String carNameBeforeSplit, stringNumberOfMoves;
    static ArrayList<String> carList, answerList;
    static int[] moveForwardlist;
    static int numberOfMoves, randomNumber;
    static boolean checkMoreThanFour;

    public static void main(String[] args) {

        // 게임 시작 후 안내 문구와 함께 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameBeforeSplit = readLine();

        // 자동차 이름의 길이를 판단하기 위해 스플릿 작업이 필요하여 스플릿 함수 실행
        make_name_split();

        // 입력 받은 자동차 이름 에러를 확인하며 스플릿 작업 같이 진행하기
        check_error_carname(carNameBeforeSplit);

        // 시도할 횟수 입력받기
        System.out.println("시도할 회수는 몇회인가요?");
        stringNumberOfMoves = readLine();

        // 입력 받은 횟수 에러 확인하기
        numberOfMoves = check_error_numberofmoves(stringNumberOfMoves);

        // 모든 입력이 정상이면 자동차 전진을 시작하기 위해 전진 횟수를 담을 배열 생성
        make_move_forwardlist();

        // 자동차 전진 수행 및 1회 마다 현황 출력
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfMoves; i++) {
            move_cars();
            print_each_car_move();
        }

        // 승자를 가리기 위해 PairList에 자동차 이름과 전진 횟수를 저장
        combine_car_names_with_car_move_times();

        // 전진 횟수가 높은 순서부터 정렬하기
        sort_carInfo_by_move_times();

        // 정답 출력하기
        print_answer();
    }

    public static void print_answer() {
        System.out.print("최종 우승자 : ");
        int cur_max = 0;
        for (Pair<String, Integer> pair : carInfoList) {
            if (pair.getValue() >= cur_max) {
                System.out.print(pair.getKey());
            } else {
                return;
            }
            cur_max = pair.getValue();
        }
    }

    public static void print_each_car_move() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i) + " : ");
            for (int j = 0; j < moveForwardlist[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void sort_carInfo_by_move_times() {
        Collections.sort(carInfoList, (a, b) -> b.getValue().compareTo(a.getValue()));
    }


    public static void combine_car_names_with_car_move_times() {
        carInfoList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            carInfoList.add(new Pair<>(carList.get(i), moveForwardlist[i]));
        }
    }


    public static void move_cars() {

        for (int i = 0; i < carList.size(); i++) {
            // 모든 입력이 정상이라면 0~9의 랜덤 숫자를 추출하여 4 이상인지 판단하기
            randomNumber = make_random_number();
            checkMoreThanFour = judge_number_more_than_four(randomNumber);
            if (checkMoreThanFour) {
                moveForwardlist[i]++;
            }
        }
    }


    public static boolean judge_number_more_than_four(int randomNumber) {
        return randomNumber >= 4;
    }

    public static int make_random_number() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void make_move_forwardlist() {
        moveForwardlist = new int[carList.size()];
    }

    public static void make_name_split() {
        // 입력 받은 문자열을 쉼표를 기준으로 구분하여 자동차 이름 저장하기
        String[] carNameAfterSplit = carNameBeforeSplit.split(",");
        carList = new ArrayList<>(Arrays.asList(carNameAfterSplit));

    }

    public static void check_error_carname(String input) {

        // 에러 상황 나누기
        // 1. 빈 문자를 입력한 경우
        // 2. 자동차 이름이 1글자~5글자 아닌 경우
        // 3. 같은 이름의 자동차를 입력한 경우

        int inputLength = input.length();

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