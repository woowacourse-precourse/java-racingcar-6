# 2주차 미션 레이싱카

<hr>

## 기능 및 사용 자료구조
 1. 참여자 입력 받기: ,을 기준으로 입력 단 참여자 이름은 5자 이하
  > Console.readLine을 통해 String 값을 입력 받아 Map<String, int> Collection으로 매핑한다.<br>
   여기서 Map의 Key 값은 차의 이름, value는 라운별 차의 진행 정도를 나타낸다.
 2. 몇 번 이동할지에 대한 숫자 입력 받기
 3. 각 참여자에 대한 난수 생성 받기
 > Rondoms.pickNumberInRange(0,9) 사이의 까지의 난수 생성 받기 선태된 난수가 4 이상일 때 해당 차의 <br>
key을 가진 1번 Map의 value을 +1 해준다.
 4. 매판 진행 사항 출력 하기
 > 3번을 통해 매 라운드 업데이트 되는 Map을 이름과 진행 정도를 줄바꿈으로 구분하여 출력해준다. 
 5. 우승자 파악하기
 > 1번 Map의 max-value 값을 찾고 해당 값을 가지는 key 값을 모드 List<Stirng>에 넣어준다. 
 6. 우승자 명단 출력하기
 > 5번에서 구한 List 안의 String의 우승자 차 이름들을 String.join을 통해 출력

<hr>

## 각 기능 별 검증 

1. 참여자 입력 받기
   + 6글자 이상의 사용자 이름 입력 받을 시 → IllegalArgument 예외 던지기
   + 중복 된 이름의 사용자 입력 받을 시 → IllegalArgument 예외 던지기

2. 몇번 이동하지 입력
   + 음수 입력 받을 시 → IllegalArgument 예외 던저기

3. 각 참여자가 대한 매 라운드 난수 생성 받기
   + 생성된 난수가 0~9가 맞는지 더블 체크
 
4. 우승자 파악하기
   + 우승자가 1명 미만일 때  → IllegalArgument 예외 던지기
   
<hr>

## 객체 설계
 + RaceRoundSimulator.class
   > 역할: 매 차수 각 레이싱카들에 대한 전진을 계산하는 역할을 함.
    <br> 기능)
    <br> 1. toString을 통해 매 차수 진행 정도 출력하는 문자열 반환
   <br> 2. 각 차들에 대한 전진 유무 계산 후 결과 수정 
  + RaceGameState.class
   > 역할: 입력 받은 문자열을 바탕을 참여자들을 관리 함.
    <br> 1. 문자열 입력을 통해 참가자들을 Map Collection으 통해 관리
    <br> 2. 각 차수의 결과를 바탕으로 현재 전진 정도를 업데이트하는 기능
  + WinnerDetector.class
   > 역할: 모든 차수가 끝나고 우승자를 가린다.
   <br> 1. RaceGameState.class 에서 선두를 달리는 참여자들을 구하고 list에 담는다.
   <br> 2. toString을 통해 ,을 구분자로 출력하는 기능
  + RacingGame.class
   > 역할: 모든 기능들을 통합하여 게임을 최종적으로 실행하고 흐름을 제어하는 역할
   <br> 1. 진행 될 레이싱 게임 차수를 입력받아 RaceRoundSimulator를 통해 반복 진행
   <br> 2. WinnerDetector를 통해 우승자 출력.
 + Validator.class(interface)
    > 역할: 입력받는 문자열에 대한 앞서 정의한 검증을 하는 기능
    <br> 1. 참가자 초기 입력 문자열에 대한 검증 → RaceGameStateValidator.class로 구현함.
    <br> 2. 입력 차수 에대한 검증 → RaceRoundSimulatorValidator.class 구현함.
    <br> 3. 우승자 목록에 대한 검증 → WinnerDetector.class로 구현.
<hr>

## 리팩토링 고려 사항

 + indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
 + 3항 연산자를 쓰지 않는다.
 + 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
<hr>
