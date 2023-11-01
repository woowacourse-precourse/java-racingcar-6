package ouput;

public interface Output {
    static final String carListMsg = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String tryNumMsg = "시도할 회수는 몇회인가요?";
    static final String resultMsg = "실행 결과";
    static final String runMsg = "-";
    static final String winnerMsg = "최종 우승자 : ";

    public void getCarListMsg();

    public void getTryNumMsg();

    public void getResultMsg();

    public void getRunMsg();

    public void getWinnerMsg();

}
