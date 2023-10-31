# 코드

## main()

어플리케이션의 메인 프로그램입니다.

## HashMap nameCar()

딕셔너리에 자동차 이름을 받아서 저장합니다. 쉼표 기준으로 저장.

자동차 이름이 5글자가 넘어가면 예외처리 합니다.

## HashMap racing(HashMap<String, Integer> carName)

현재 딕셔너리 값에 racing을 한번 실행하여 그 결과 값을 리턴합니다.

## int randomCreate

0~9 사이의 랜덤 값을 생성합니다.

## boolean forward(int number)

랜덤 값이 4이상이면 true를 리턴해 전진할 수 있게 합니다.

## String hyphen(int number)

딕셔너리에 저장된 value 값에 따라 하이픈을 리턴합니다.

## int attempt()

시도를 할 횟수를 구해 리턴합니다.

## HashMap race(HashMap<String, Integer> carName, int number)

자동차의 딕셔너리와 시도 횟수를 통해 레이스를 진행합니다.

## String winner(HashMap<String, Integer> carName)

현재 자동차의 딕셔너리를 통해 value값 중 최고 값을 가진 key 값을 리턴합니다.

