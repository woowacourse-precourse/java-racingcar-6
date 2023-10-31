package model;

public enum Message {

    GAMESTART("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    GAMEEND("최종 우승자 : "),
    SETROUND("시도할 회수는 몇회인가요?\n");

    private String str;

    private Message(String str){
        this.str = str;
    }

    public String getStr(){
        return str;
    }



}
