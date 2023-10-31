Game

-[x] 게임을 실행시킨다.
    - [x] 게임 시작 부분을 담당한다.
        -[x] UI#게임시작문구를 출력한다
        - [x] InputReader#입력을 받게한다
        - [x] GameEngine#플레이어를 생성한다
    - [x] 게임플레이를 담당한다.
        -[x] UI#시도횟수를 물어보는 문구를 출력한다.
        - [x] InputReader#입력을 받게한다
        -[x] GameEngine#n번 전진시킨다.
        -[x] Ui#전진현황을 출력한다.
    -[x] 게임 종료를 담당한다.
        -[x] GameEngine#최종우승자를 온다.
        -[x] Ui#우승자를 출력한다.
        - [x] inputReader# 입력을 종료시킨다.

Ui

-[x] 게임을 시작하는 문구를 출력한다.
    -[x] 자동차 이름을 입력하는 문구를 출력한다.
-[x] 시도 횟수를 물어보는 문구를 출력한다.
-[x] 시도 가이드 문구를 출력한다.
- [x] 시도 현황들을 출력한다.
-[x] 우승자를 출력한다.

InputReader

-[x] 입력된 값을 읽는다.
- [x] 입력을 종료시킨다.

GameEngine

-[x] 점수를 생성한다
    -[x] GameEngineValidator# 플레이어 이름을 검증한다.
    - [x] 점수를 생성한다.
    - [x] 플레이어이름은 한번만 생성할 수 있다.
- [x] 플레이어가 전진하는지를 판단한다
    - [x] GameEngineValidator# 음수이거나 숫자가아닌지 검증한다.
    - [x] ScoreUpdater#점수를 업데이트한다
-[x] 스코어들을 반환한다.
- [x] 우승자를 반환한다
    -[x] 동점일경우, 플레이어 입력 순서대로 정렬한다.

GameEngineValidator

- [x] 입력값이 널이면 예외를 반환한다.
- [x] 리스트에 있는 값이 6글자 이상이면, IllegalArgumentException반환
- [x] 입력받는값이 마이너스이면, IllegalArgumentException 반환

NumberGenerator

-[x] 숫자를 만들어준다
    -[x] 지정범위에서 랜덤으로 만들어준다

Score

-[x] 이름은 불변값,점수은 상태값을 가진다.
-[x] 입력받은 점수만큼 올라가게 만든다.

ScoreUpdater

-[x] 점수를 업데이트 시킨다.
    -[x] NumberGenerator# 숫자 만드는 것을 부른다.
        -[x] 그 숫자를 판단한다
            - [x] 0부터3까지 멈춤
            - [x] 4부터 9까지는 전진

AppConfig

-[x] 구동에 필요한 객체를 생성하는 역할을 담당한다.