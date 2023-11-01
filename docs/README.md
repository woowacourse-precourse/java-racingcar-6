이름이 5자 이하; 초과이면 illegalA~ 발생
전진조건이 0~9 사이 컴퓨터가 무작위 값을 구한 후 함수를 통해 4이상인 경우에는 전진시킨다.
경주 할 자동차 이름.입력받기.
메인함수 : 리스트 cars로 경주할 자동차 이름을 받고 저장하기 위해 사용하며, 변수 tryNum를 이용하여 시도할 횟수를 입력받아 저장합니다. 실행결과 함수를 실행시키고, 최종 우승자는
이름입력받는 함수 : split을 이용하여 나누어서 리스트 함수에 저장시킵니다.
실행결과 함수(List<String> cars, int tryNum) : cars의 갯수에 따라 움직인 만큼을 나타내는 리스트 go를 만듭니다. while문을 이용하여 int i가 시도할 횟수보다 작을 때 반복하며 차 얼만큼 움직임 함수를 실행시키고 i++을 하며(여기까지 while문) 반복합니다. 최종 우승자를 가리는 함수를 호출한 후 함수의 리턴값을 이용하여 cars에서 해당하는 index의 요소값을 출력합니다.
차 얼만큼 움직임 함수 howManyGo (List<String> cars,List<Integer> go, int many) : for문을 통해 자동차 개수(cars의 size인 many)만큼 반복하는데, if문을 사용하여 isCarMoved함수를 통해 true일 때 go에서 해당하는 위치에 +1을 해주며, print함수를 호출합니다.
숫자를 '-'로 만들어 print하는 함수toPrint(int num) : for문을 돌려서 num숫자만큼  print('-')를 하고 println해주며 반복하여 print해줍니다.
차들이 움직였는가?isCarMoved 함수 : random을 통해 숫자를 받고 if함수를 통해 무작위 값이 4이상일 경우 true, else로 false를 리턴합니다.  리턴을 "불리언" 값입니다.
최종 우승자 가리는 함수(List<Integer> go, int many) : for문과 if문을 중첩하여 가장 큰 요소의 index를 알아내고, index를 출력하는 함수입니다.