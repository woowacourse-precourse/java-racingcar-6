# 자동차 경주

## 기능 목록

- [ ] Model - 비즈니스 로직 및 데이터를 다룬다

    - [ ] 자동차, 플레이어 이름을 입력받는다. - InputPlayerName()
    - [ ] 라운드 동안 랜덤 수를 생성한다. - NumberGenerator#createRandomNumbers()
    - [ ] 생성된 랜덤 수가 4 이상인지 검증한다. - VerifyNumber()
    - [ ] 입력 받은 라운드 수 만큼 반복한다. - RepeatRound()

- [ ] View - UI 모듈로 화면 처리에 대한 부분을 담당한다.

    - [ ] 입력 요청 텍스트를 출력한다. - PrintRequest()
    - [ ] 라운드마다 결과를 출력한다. - PrintEachRound()
    - [ ] 최종 우승자를 출력한다. - PrintFinalRound()

- [ ] Control - 요청을 분석해 로직을 처리하고 결과에 따른 View를 연결한다.

    - [ ] 게임을 진행한다. - InitGame()
    - [ ] 입력 받은 값을 통해 적절한 메서드를 호출한다.
    - [ ] 프로그램을 종료한다. - ExitGame()

## 기능 요구 사항

<n대의 자동차 = n명의 플레이어>가 존재한다.
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