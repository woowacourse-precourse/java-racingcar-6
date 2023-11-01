# 자동차 경주

## 기능 목록

- [x] Model - 비즈니스 로직 및 데이터를 다룬다.

    - [x] 입력 받는 플레이어의 이름을 처리하는 클래스.
            - SplitPlayerName()
    - [x] 랜덤 수를 생성하는 클래스.
            - GenerateRandomNumber()
    - [x] 랜덤 수를 검증하는 클래스.
            - VerifyRandomNumber()
    - [x] 입력 받은 String을 int로 변환하는 클래스.
            - StringToInt()
    - [x] 최종 결과를 비교하여 우승자를 체크하는 클래스.
            - CheckWinner()

- [x] View - UI 모듈로 화면 처리에 대한 부분을 담당한다.

    - [x] 텍스트를 불러오는 클래스.
            - PrintMessage()
    - [x] 게임 진행에 필요한 메세지들을 상수로 관리하는 클래스.
            - Messages()

- [x] Control - 요청을 분석해 로직을 처리하고 결과에 따른 View를 연결한다.

    - [x] 게임을 진행을 총괄하는 클래스. - ControlGame()
            - [x] 게임 시작에 필요한 메서드를 호출하는 메서드. - StartGame()
            - [x] 게임 플레이에 필요한 메서드를 호출하는 메서드. - PlayGame()
            - [x] 게임 결과 출력에 필요한 메서드를 호출하는 메서드. - EndGame()

## 기능 요구 사항

n대의 자동차 = n명의 플레이어 가 존재한다.
플레이어들에게는 이름을 부여할 수 있다.
이름은 쉼표(,)를 통해 구분한다.

라운드 수를 입력 받는다.
각 라운드마다 0~9의 무작위 숫자를 생성, 4 이상일 경우 전진한다.

라운드가 끝나고 결과를 출력한다. 복수의 결과 출력 시 쉼표(,)로 구분한다.

IllegalArumentException 체크

## 프로그래밍 요구 사항

1. JDK 17
2. Application의 main()에서 시작
3. build.gradle : read only, 외부 라이브러리 금지
4. Java Code Convention 준수
5. System.exit() 금지
6. ApplicationTest 실행 및 통과
7. Indent(들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용.
8. 3항 연산자 사용 금지
9. 함수 혹은 메서드는 한 가지 일만 하도록 작성
10. JUnit 5, AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작하는지 테스트 코드로 확인.