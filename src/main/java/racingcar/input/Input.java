package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Input {
        public List<String> carNameList() {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String[] input = Console.readLine().split(",");
            List<String> carName = new ArrayList<>();
            for (String s : input) {
                nameLengthException(s);
                carName.add(s);
            }
            return carName;
        }
        public Map<String, Integer> carNameMap(List<String> carNameList) {
            Map<String, Integer> carNameMap = new HashMap<>();
            for (String s : carNameList) {
                carNameMap.put(s, 0);
            }
            return carNameMap;
        }
        public int tryNumber() {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(Console.readLine());
        }

        public void nameLengthException(String input) {
            if (input.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }


}
