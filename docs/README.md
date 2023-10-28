
1. 자동차 클래스 및 자동차 목록 생성
   - 자동차 클래스 설계: 자동차의 이름, 전진 여부를 관리하는 메서드와 속성
   - 여러 대의 자동차를 관리하는 자동차 목록 생성
   - 자동차 이름은 5자 이하만 가능하며, 쉼표(,)로 구분하여 입력 받기

2. 무작위 값으로 전진 여부 판단
   - Randoms 라이브러리를 활용해 0에서 9까지의 무작위 값을 생성
   - 생성된 값이 4 이상일 경우 자동차가 전진하는 조건 설정

3. 이동 횟수 입력 및 실행
   - 사용자로부터 이동을 시도할 횟수 입력 받기
   - 이동 횟수에 따라 각 자동차의 전진 여부 결정
   - 전진한 자동차의 상태 출력

4. 우승자 결정
   - 모든 이동이 끝난 후, 우승한 자동차(들)을 결정
   - 우승자가 한 명인 경우 해당 우승자 출력
   - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력

5. 예외 처리
   - 사용자 입력에 대한 예외 처리: 잘못된 값 또는 형식 입력 시 `IllegalArgumentException` 발생 및 처리
   - 잘못된 값이 입력되었을 때 프로그램 종료

## Domain
  - NumberGenerator inteface, RandomNumberGenerator
  - RaceAttempts 시도 횟수, 일급 컬렉션, 자연수 아닌 값 예외 처리
  - RaceParticipants - 일급 컬렉션, 이름 구분자 처리,이름 중복 예외 처리
  - RaceWinners - 경기 우승자(들), 일급 컬렉션
  - RacingCar 레이싱 카, 이름 길이 예외 처리
## View
  - InputView - 입력
  - OutputView - 출력
  - racingcar.view.console.util.InputUtil 일반적인 입력 예외 처리

## Controller
  - RacingController - 레이싱 게임 진행

## Exception
  - BaseException - 기본 예외 처리
  - InvalidInputException - 입력 예외 처리
  - ErrorMessage - 에러 메시지 상수화