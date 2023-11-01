
-프로그래밍전-
1.우테코에서 제공하는 코딩컨벤션 xml파일 설정해주기.
    고민인 부분: 함수 {}를 나는 enter로 명확히 구분해 주는걸 선호하는데 코딩 컨벤션에서는 func{ 방식으로 되어있다.
    코딩 컨벤션에 대해 찾아보다가 인텔리제이에 Alt+ctrl+L을 하면 자동으로 등록된 컨벤션을 적용해 준다는 것을 알았다.
2.라이브러리 확인하기. amp.nextstep.edu.missionutils.Randoms, Console (1주차와 다른 점이 있는지.)
3.프로그램 구조 설계
    1.경주 자동차 입력,시도 횟수 입력 구현. Console의 ReadLine으로 입력받기
        String[] Car_names에 ',' 기준으로 split해서 자동차 이름을 넣어주려 한다.
    2.Car class를 만든다. 이 클래스로 메인에 ArrayList<Car>을 만든다.
        Class에서는 자동차이름, 전진횟수를 객체변수로 만들고
        객체함수로 Random생성, 전진 판단 함수를 구현하려 한다.
    3.프로그램 진행 while 루프를 Main에 설정한다.
        indent depth가 2인 for-for 방식으로 구현한다.
        첫번째 for 에서는 입력 받은 반복 횟수 만큼 진행 하고,
        두번째 for문에서는 현재 설정된 자동차 obj 수만큼 반복하고, 각 for문 마다 전진 여부를 확인한다.
    4.IllegalArgumentException을 Application.java 파일의 main 함수 아래에 만들어 줄지, 따로 예외처리 java파일을 만들지 고민이다.
        보통 예외처리 함수를 모아서 Exception.java를 만드는데(평소 코딩에서) 과제에서는 너무 간단하다 보니 그냥 main 아래에 만들어 줘도 될것 같다.
    5.for-for 루프를 모두 마치고 나면 최종 결과를 출력하는 코드를 짜준다.


-프로그래밍 구현 과정에서-
1.자동차 이름 입력받는 부분: String[]로 이름을 저장한 다음, ArrayList<Car>에 객체를 생성한다.
    Case1: 정상적인 입력
    Case2: 입력 자체가 null인 경우
    Case3: 이름 중간에 공백이 있는 경우
    Case4: 길이가 1미만 5이상인 경우.
    Case5: 입력에서 aaa,,ccc인 경우
2.Base_FUNC.java 클래스를 만들어 기본적인 기능을 수행하는 함수들을 구현했다.
    f1: Check_Input_Name(String[] Car_name) 
    f2: Input_Move_number()
    f3: Print_Winner(ArrayList<Car> Car_List)
    f4: Check_If_Carname_OverLapped(String[] Car_name, int idx) -> Check_Input_Name함수 내부에서 사용한다.
3.시도횟수 입력에 입력값 0은 오류로 처리한다.
4.시도횟수와 자동차 종류의 Max숫자 제한에 대해 고려해 보았다. 우테코의 테스트 케이스 상황을 모르다 보니 제한을 두기가 고민스럽다.


리마인드 해볼 부분
1.int move_number = Integer.parseInt(Console.readLine()); ParseInt 사용법.
2.향상된 for 루프.
3.String의 isEmpty() 사용