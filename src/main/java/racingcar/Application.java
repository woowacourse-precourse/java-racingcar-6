package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {

        Application app = new Application();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = Arrays.asList(Console.readLine().split(","));

        app.checkInput(carNameList);

        System.out.println("시도할 횟수는 몇회인가요?");
        int racingGameCount = Integer.parseInt(Console.readLine());

        Map<String, String> carsAndMoves = app.addCountWhenMove(racingGameCount, carNameList);

        String winner = app.determineWhichMovesTheFurthest(carsAndMoves, carNameList);
        System.out.println(winner);

    }

    protected void checkInput(List<String> carNameList) { // 각 자동차의 이름은 5글자 이하, 쉼표로만 구

        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i);

            if (carName.length() > 5) { // 5자를 초과할 경우 예외처리
                throw new IllegalArgumentException("레이싱 카 이름이 5글자를 초과하였습니다.");
            }

            if (!Pattern.matches("^[a-zA-Z]+$", carName)) { // 영어 이외의 문자(공백포함)가 포함될 시 예외 처리
                throw new IllegalArgumentException("레이싱 카 이름이 영어로 이루어져 있지 않습니다.");
            }

            if (validateDuplication(carNameList, carName, i)) { // 이름이 중복될 경우 예외 처리
                throw new IllegalArgumentException(carName + " 이름이 중복됩니다.");
            }


        }

    }

    private boolean validateDuplication(
            List<String> carNameList,
            String carName,
            int index
    ) {
        for (int i = index + 1; i < carNameList.size(); i++) {
            if (carNameList.get(i).equals(carName)) {
                return true;
            }
        }
        return false;

    }

    protected Map<String, String> addCountWhenMove(int racingGameCount, List<String> carNameList) {
        Map<String, String> carsAndMoves = new HashMap<>();

        System.out.println("실행 결과");

        for (int i = 0; i < racingGameCount; i++) {
            for (int j = 0; j < carNameList.size(); j++) {

                addCountAndPreventNullValue(carsAndMoves, carNameList, j);

                System.out.println(carNameList.get(j) + " : " + carsAndMoves.get(carNameList.get(j)));
            }
            System.out.println();
        }
        return carsAndMoves;
    }

    private void addCountAndPreventNullValue(
            Map<String, String> carsAndMoves,
            List<String> carNameList,
            int index
    ) {
        String moveCount = carsAndMoves.get(carNameList.get(index));
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {

            if (moveCount != null)
                carsAndMoves.put(carNameList.get(index), moveCount + "-");

            if (moveCount == null)
                carsAndMoves.put(carNameList.get(index), "-");
        }

        if (randomNumber < 4) {

            if (moveCount != null)
                carsAndMoves.put(carNameList.get(index), moveCount);

            if (moveCount == null)
                carsAndMoves.put(carNameList.get(index), "");
        }
    }

    private String determineWhichMovesTheFurthest(Map<String, String> carsAndMoves, List<String> carNameList) {
        List<String> result = new ArrayList<>();
        int temp = 0;

        for (String carName : carNameList) {
            int moveCount = carsAndMoves.get(carName).length();

            if (moveCount == temp) {
                result.add(carName);
            }

            if (moveCount > temp) {
                temp = moveCount;
                result.clear();
                result.add(carName);
            }

        }

        String resultToString = result.toString();

        return "최종 우승자" + " : " + resultToString.replaceAll("\\[|\\]", "");
    }

}