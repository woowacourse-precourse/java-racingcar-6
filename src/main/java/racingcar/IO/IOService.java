package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class IOService {
    public final static String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String COUNT = "시도할 회수는 몇회인가요?";

    public final static String RESULT = "실행 결과";
    public final static String END = "최종 우승자";

    public static void printNoticeln(String ment) {
        System.out.println(ment);
    }

    public static void printNotice(String subject, String value) {
        System.out.println(subject+" : "+value);
    }

    public static String inputCreate() {
        String inputString=Console.readLine();
        checkLength(inputString);
        return inputString;
    }


    public static String inputCount() {
        String inputString=Console.readLine();
        checkIsNum(inputString);
        return inputString;
    }

    private static void checkLength(String inputString) {
        List<String> nameList = Arrays.stream(inputString.split(",")).toList();
        int limit=5;
        for (String name : nameList) {
            checkBlank(name);
            if(name.length()>limit) throw new IllegalArgumentException(String.format("입력 문자의 길이가 너무 깁니다. 입력한 문자 길이 : [%s]", name.length()));
        }
    }

    private static void checkBlank(String inputString) {
        if(inputString.charAt(0) == ' ' || inputString.charAt(inputString.length() - 1) == ' ')
            throw new IllegalArgumentException(String.format("이름에는 공백이 포함될 수 없습니다. 입력한 문자 : [%s]",inputString));
    }

    private static void checkIsNum(String inputString){
        try {
            Integer.parseInt(inputString);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("입력이 숫자가 아닙니다. 입력한 문자 : [%s]",inputString));
        }
    }
}
