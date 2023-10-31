package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Referee{
    private List<Racer> group;
    private int maxDistance;
    private int gameCount;
    private int presentCount;

    public Referee() {
        group = new ArrayList<>();
        presentCount = maxDistance = 0;
    }

    public void addGroup(String name) {
        Racer player = new Racer(name);
        group.add(player);
    }

    public void printProgress() { // 현재까지의 모든 player 진행상황을 출력
        for (Racer player : group) {
            player.printDistance();
        }
        System.out.println();
    }

    public void findMaxDistance() {

        for (Racer player : group) {
            compareMax(player);
        }
    }

    public void compareMax(Racer player) {

        if (this.maxDistance < player.getDistance())
            this.maxDistance = player.getDistance();
    }

    public void printWinner() {

        findMaxDistance();

        List<String> members = new ArrayList<>();

        for (Racer player : group)
            addMaxPlayer(members, player);

        String result = String.join(", ", members);

        System.out.print("최종 우승자 : " + result);
    }

    public void addMaxPlayer(List<String> members, Racer player) { // 해당 player가 최대 전진거리 일 경우 우승자에 추가함
        if (player.getDistance() >= this.maxDistance)
            members.add(player.getName());
    }

    public void readPlayer() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] player = Console.readLine().split(",");

        for (String name : player) {
            Judgment.isOverFiveLength(name); // 자동차 이름 길이가 5를 초과하는지 확인
            addGroup(name);
        }
    }

    public void readGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        gameCount = Judgment.checkInteger(Console.readLine());
        System.out.println();
    }

    public void cycle() {
        for (Racer player : group) {
            player.moveForward();
        }

        presentCount += 1;
    }

    public void run() {
        readPlayer();
        readGameCount();

        System.out.println("실행 결과");
        while (presentCount < gameCount) {
            cycle();
            printProgress();
        }

        printWinner();
    }
}
