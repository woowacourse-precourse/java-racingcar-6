## 기능 목록

- [x] 입력 받은 자동차 이름들을 검증 한다. - Validator#names
    - [x] 개별 이름 5자 이하(앞뒤 공백 제외) - Validator#size
    - [x] 중복된 이름 금지 - Validator#duplicate
    - [x] 공백 이름 금지 - Validator#blank
        - "," 금지
- [x] 입력 받은 시도 횟수를 검증 한다. - Validator#trial
    - [x] 양의 정수 형태 이외 금지(앞뒤 공백 제외) -Validator#positive
        - 맨 앞 0도 금지 ex) 012
    - [x] 공백 이름 금지 - Validator#blank

- - -

- [x] 이름 클래스 - Names
    - [x] 자동차모음 으로 변환 - Names#toCars
- [x] 시도 횟수 클래스 - Trial
    - [x] 시도 횟수 정수로 변환 - Trial#toNum
- [x] 입력 데이터를 받아 놓는 클래스 - Setting
    - [x] 자동차모음 으로 변환 - Setting#toCars

- [x] 자동차 클래스 - Car
    - [x] 이동 횟수 증가 - Car#race
    - [x] 경주 결과 만들기 - Car#toString
- [x] 자동차모음 클래스 - Cars
    - [x] 자동차 추가 - Cars#add
    - [x] 가장 좋은 성적 찾기 - Cars#maxMovement
    - [x] 우승자 찾기 - Cars#findWinner
    - [x] 자동차 경주 로직 - Cars#racing
    - [x] 경주 이후 결과 복사본 반환(원본 영향 없이) - Cars#Result
- [x] 무작위 수를 뽑아 자동차 경주를 진행 - Game#racing
- [x] 우승자 찾기 - Game#findWinner
- [x] 결과 복사본 반환(원본 영향 없이) - Game#giveResult

- - -

- [x] 경주 결과 출력 - Printer#gameResult
- [x] 우승자 출력 - Printer#winner
- [x] 기타 게임 안내 문구 출력


  
