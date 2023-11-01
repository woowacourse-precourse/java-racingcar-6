# 자동차 경주 구현 기능 목록 📜

## ✅ 1. 경주할 자동차 입력받기

- ✅ 자동차 이름은 쉼표(,)를 기준으로 구분합니다.
    - ✅ 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시킨 후 애플리케이션을 종료시킵니다.
        - ✅ 아래 3가지 경우, "Input value cannot be blank." 예외 메시지 설정
            - ✅ null일 경우
            - ✅ 빈 문자열일 경우
            - ✅ 값이 공백만으로 구성된 경우
        - ✅ 아래 2가지 경우, "There must be two or more cars, and each cars must be separated by a comma." 예외 메시지 설정
            - ✅ 쉼표가 없는 경우
            - ✅ 자동차의 개수가 1개일 경우 (경기할 수 있는 대상이 없으므로)
- ✅ 각 이름은 5자 이하만 가능합니다.
    - ✅ 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시킨 후 애플리케이션을 종료시킵니다.
        - ✅ 아래 3가지의 경우, "None of the names can be blank." 예외 메시지 설정
            - ✅ null일 경우
            - ✅ 빈 문자열일 경우
            - ✅ 값이 공백만으로 구성된 경우
        - ✅ 길이가 5초과일 경우, "The length of the name must be 5 or less." 예외 메시지 설정
        - ✅ 영어, 숫자, '-' 이외의 다른 값이 포함된 경우, "Only English letters, numbers, and '-' symbol are allowed in the name." 예외
          메시지 설정
- ✅ 자동차 이름은 중복될 수 없습니다.
    - ✅ 중복된 이름이 하나라도 있을 경우, IllegalArgumentException을 발생시킨 후 애플리케이션을 종료합니다.
        - ✅ "Car names cannot be duplicated." 예외 메시지 설정

## ✅ 2. 시도할 횟수 입력받기

- ✅ 숫자만 입력할 수 있습니다.
    - ✅ 잘못된 값을 입력할 경우, IllegalArgumentException을 발생시킨 후 애플리케이션을 종료시킵니다.
        - ✅ 아래 3가지의 경우, "Input value cannot be blank" 예외 메시지 설정
            - ✅ null일 경우
            - ✅ 빈 문자열일 경우
            - ✅ 값이 공백만으로 구성된 경우
        - ✅ 숫자가 아닌 값이 포함된 경우, "Non-numeric values cannot be included, and therefore, negative numbers and decimals are
          also not allowed." 예외 메시지 설정
        - ✅ 입력된 값이 '0'일 경우, "It cannot be 0." 예외 메시지 설정
        - ✅ 값의 길이가 2이상인데 가장 큰 자리의 수가 0일 경우, "The number in the highest digit cannot be 0." 예외 메시지 설정

## ✅ 3. 자동차 경주 시작

- ✅ 입력받은 시도 횟수만큼 해당 과정을 반복합니다.
- ✅ 자동차별로 전진/정지를 판단합니다.
    - ✅ 0에서 9 사이에서 무작위 값을 구합니다.
        - ✅ 4 이상일 경우 '전진'합니다.
        - ✅ 4 미만일 경우 '정지'합니다.
- ✅ 자동차가 전진했을 경우 작업할 사항은 아래와 같습니다.
    - ✅ 움직인 정도를 표시하는 결과 문자열에 '-'기호를 추가합니다.
    - ✅ 해당 자동차의 전진 총횟수에 +1을 합니다.
- ✅ "실행 결과" 문구를 출력합니다.
- ✅ 새로운 라인에 '${자동차 이름} : ${자동차 움직인 거리 표시}' 형식으로 차수 결과를 출력합니다.
    - ✅ 모든 차수에 대해 진행합니다.
    - ✅ 차수별로 한 줄 공백을 둡니다.
    - ✅ 차수별로, 모든 자동차에 대해 순서대로 출력합니다.

## ✅ 4. 우승자 찾기

- ✅ 모든 자동차를 대상으로 자동차마다 총 전진 횟수를 비교해, 가장 많이 움직인 자동차를 우승자로 판단합니다.
- ✅ "최종 우승자 : " 를 출력하며, 이어서 바로 우승자를 출력합니다.
    - ✅ 우승자가 여러 명일 경우 아래와 같이 처리합니다.
        - ✅ 쉼표(,)를 이용하여 구분합니다.
        - ✅ 쉼표 다음에 공백을 한 칸 두고, 다음 우승자를 출력합니다.