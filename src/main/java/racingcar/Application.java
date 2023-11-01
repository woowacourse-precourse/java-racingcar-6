package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static final int RANDOM_MIN = 0;
    public static final int RANDOM_MAX = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //변수/메소드명 수정하기, 메소드 분리하기, MVC 패턴 나누기, 예외 히든 케이스 넣기, 예외 처리할때 메시지 넣는 사람도 있더라 상수화 등등..
        //테스트 작성하기

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        List<String> strtoken = Arrays.asList(str.split(","));

        Map<String, Integer> carList = new LinkedHashMap<String, Integer>(); //뒤에 이거 꼭 넣어야해? String, Integer
        for (String s : strtoken) {
            if (s.length() >= 6) { //매직넘버 지양하기
                throw new IllegalArgumentException();
            }
            carList.put(s, 0);
        }
        System.out.println();
        System.out.println("시도할 횟수는 몇회인가요?");
        String str2 = Console.readLine();
        int number = Integer.parseInt(str2);

        System.out.println("실행결과");
        String bar = "-"; //상수 선언하면 repeat 못쓰겠지?
        for (int i = 0; i < number; i++) {
            Iterator<String> itrKeys = carList.keySet().iterator();
            while (itrKeys.hasNext()) {
                String key = itrKeys.next();
                int random = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
                if (random >= 4) { //매직넘버 지양하기
                    carList.put(key, carList.get(key) + 1); //매직넘버 지양
                }
                System.out.println(key + " : "+bar.repeat(carList.get(key)));
            }
            System.out.println();
        }
        Integer max = carList.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();

        List listOfMax = carList.entrySet().stream().filter(entry -> entry.getValue() == max).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", listOfMax));

    }
}