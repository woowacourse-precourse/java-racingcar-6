# 우아한 테크 코스 백엔드 6기 2주차 미션 - 자동차 경주

미션 수행자 - 김현중

## 잊지 말고 확인할 것

- JDK 17 버전인지 확인
- 최대한 **자주 커밋**하기
    - 올바른 커밋 메시지 작성 동반 필요
- 파일, 패키지 이름 수정, 이동하지 않기
- 프로그램 종료 시 'System.exit()' 호출하지 않기
- 구현 완료 시 'ApplicationTest'의 모든 테스트 성공 여부 확인
- **Java 코드 컨벤션**을 지켰는지 확인
- indent가 3 이상이 되지 않도록 구현 - 함수 분리를 통해 해결
- 3항 연산자 쓰지 않기
- 함수가 한 가지 일만 하도록 구현
- JUnit5, AssertJ를 이용하여 기능별로 테스트 코드 구현

## 테스트 실행 방법

- 터미널(alt+F12)에 **'./gradlew.bat clean test'**를 입력해 모든 테스트를 통과하는지 확인한다.

## 게임 진행

- 쉼표로 구분된 5자 이하의 자동차 이름 입력
- 진행할 회수 입력
  - 'Console.readLine()'을 통해 입력
  - 잘못된 입력은 'IllegalArgumentException' 발생 이후 종료
- 실행 결과 출력
  - 각 회수마다 입력받은 이름 순으로 이동한 거리를 '-'로 출력
  - 0~9 사이의 숫자 중 4 이상이 나왔을 때에 전진, 그 외의 경우는 정지
    - 'Randoms.pickNumberInRange()'를 통하여 값 생성
  - 회수 사이는 빈 줄로 구분
- 가장 많은 거리를 간 자동차 이름을 우승자로 출력
  - 복수 우승자의 경우 쉼표로 구분

## 필요한 기능

- View.InputView
  - 입력과 관련된 기능 수행
  - Validator를 통한 검증 실패 시 IllegalArgumentException 발생
- View.OutputView
  - 출력과 관련된 기능 수행
  - 출력 메시지 관리, RacingCar 객체를 받아 차수별 실행 출력, 우승자 명단을 받아 결과 출력
- Validator.Validator
  - 입력받은 값을 검증하는 기능 수행
- Controller.RacingGame
  - 전체적인 게임 진행을 수행
  - 시작 메시지 출력, 필요한 값 입력, 횟수만큼 게임 라운드 진행, 결과 출력
- Model.RacingCar
  - 각 자동차에 대한 정보
  - 이름, 이동 거리, 전진 메서드
- Config.GameConfig
  - 게임 진행에 필요한 변수들 설정
  - 무작위 값의 상하한, 전진조건, 자동차이름 글자수제한, 구분자, 중복된 이름 허용 여부

## 고려해야 할 사항

- 이름 입력 시
  - 아무것도 입력하지 않았을 때, 이름이 없을 때
    - 이름이 아무것도 없는 경우 IllegalArgumentException 발생
  - 중복된 이름 허용 여부
    - 허용하지 않음
  - 이름 앞 뒤의 공백 제거 여부
    - 이름 앞 뒤의 공백을 제거하여 진행
- 횟수 입력 시
  - 숫자가 아닌 경우
    - Integer.parseInt 에서 발생하는 NumberFormatException 발생 시 IllegalArgumentException 발생
  - 0 미만의 입력
    - IllegalArgumentException 발생
  - 0의 경우
    - 0회 진행(아무도 움직이지 않음)으로 승부를 결정(공동 우승)