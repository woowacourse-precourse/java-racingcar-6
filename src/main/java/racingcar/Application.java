package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Application {

    static ArrayList<String> user = new ArrayList<>();
    static int TESTCASE = 0;
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        try {
            st = new StringTokenizer(br.readLine(),",");
            user.add(st.nextToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("시도할 회수는 몇회인가요?");

        try {
            TESTCASE = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n" + "실행결과" + "\n");
    }
}
