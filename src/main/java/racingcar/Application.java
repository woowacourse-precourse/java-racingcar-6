package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Application {
    private static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> cars = carNameInput();
        System.out.println("시도할 회수는 몇회인가요?");
        int moveNum = moveNumInput();
        initHashMap(cars);
        playRacingCar();

        System.out.println("\n실행 결과");
        for(int i = 0; i < moveNum; i++) {
            playRacingCar();
            printResult();
        }
    }

    private static ArrayList<String> carNameInput() {
        String cars = readLine();
        StringTokenizer st = new StringTokenizer(cars, ",");
        ArrayList<String> carList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            String car = st.nextToken().trim();

            if(car.length() > 5 || car.isEmpty()){
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
            carList.add(car);
        }

        validateCarNameInput(carList);

        return carList;
    }
    private static void validateCarNameInput(ArrayList<String> carList) {
        HashSet<String> carHash = new HashSet<>();

        for (String car : carList) {
            carHash.add(car);
        }

        if (carList.size() != carHash.size()) {
            throw new IllegalArgumentException("중복된 입력값입니다.");
        }

    }

    private static int moveNumInput() {
        String input = readLine();
        validateMoveNumInput(input);
        int moveNum = Integer.parseInt(input);

        if(input.equals("0")){
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }

        return moveNum;
    }

    private static void validateMoveNumInput(String input) {
        boolean isNumeric = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                isNumeric = false;
                break;
            }
        }

        if (!isNumeric) {
            throw new IllegalArgumentException("올바른 범위의 숫자를 입력하세요.");
        }
    }

    private static void initHashMap(ArrayList<String> cars){
        for(int i = 0; i < cars.size(); i++) {
            map.put(cars.get(i), 0);
        }
    }

    private static void playRacingCar() {
        for(Entry<String, Integer> e : map.entrySet()) {
            if(Randoms.pickNumberInRange(0, 9) >= 4){
                e.setValue(e.getValue() + 1);
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for(Entry<String, Integer> e : map.entrySet()) {
            sb.append(e.getKey() + " : ");
            for (int i = 0; i < e.getValue(); i++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


}
