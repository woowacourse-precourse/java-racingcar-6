package racingcar;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        GameRule rule = new GameRule(5, 0, 9);
        Race race = new Race(rule);
        InputPrompt prompt = new InputPrompt(rule);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        race.registerRacers(prompt.readCarNames());
        System.out.println("시도할 회수는 몇회인가요?");
        rule.setNumberOfRepetitions(prompt.readNumberOfRepetitions());
        System.out.println("\n실행 결과");
        race.start();
        System.out.println("최종 우승자 : " + race.winners());
    }
}
