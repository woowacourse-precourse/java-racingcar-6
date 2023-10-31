## MVC기반의 기능 목록
    1. Model
        - RacingCar
        - RacingCars (RacingCar을 List로 받아들이기)
        - CarContainer 
    2. View
        - Name Input: 전진하는 자동차에 이름 입력
            - 예외처리: 5자 이상이면 에러클래스 처리 
        - Name Output: 전진하는 자동차 출력
            - 자동차 이름도 같이 출력
        - 사용자가 몇번의 이동을 할 것인지 입력
        - 우승자 Output: 우승했는지 알려주는 출력 
    3. Controller
        - 사용자의 전진 또는 멈춤
            - 전진 조건: 0-9사이에서 무작위 값 AND 무작위 값이 4 이상
        - 우승 조건
            - 우승자는 한명 이상일 수 있다(여러 명일 경우 쉼표 이용하여 구분)
    4. Error
        - 사용자가 잘못된 값을 입력하면 에러 처리  - HandleError클래스
            - IllegalArgumentException이용