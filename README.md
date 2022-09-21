# 출퇴근 기록 및 조회, 월급 계산기
  
  2022년 9월에 진행한 팀프로젝트  
    
  - 인원 : 정정일, 김성호, 김희정, 정지영 총 4명
  
  - 프로젝트 기간: 2022년 9월 18일 ~ 2022년 9월 21일  
    
--------------------------------------------------------------------------------------------------------------------------------------------------- 
  
* ### 프로젝트 소개  
  
  ```
  - 회원가입을 통해 User와 Doctor를 생성 및 로그인 할 수 있게 하여,  
    User가 게시판에 질문을 올리면 이를 Doctor가 조회할 수 있게 하고 feedback과 소통을 할수있다   
    User는 마이페이지에서 자신의 반려동물을 등록할수있다
    
  ```
  
* ### 사용기술 
   
  ```
  - java
  - jquery
  - jpa
  - html,css,js(java script)
  - spring boot framework
  - MySQL
  - github
  - gradle
  ```
  
* ### 주요 기능  
  
  - User의 회원 가입 및 로그인  
      
  - 출퇴근 버튼을 눌렀을 때, 각 타입에 맞는 시간을 DB에 데이터로 남김     
    
  - User가 원하는 날짜에 월차로 휴일을 지정 및 사유를 남길 수 있는 기능
    
  - 페이지에서 User가 조회하고자 하는 년도와 월 값을 입력 받고, 그 달의 출퇴근 기록들을 DB에서 조회하고 값을 반환, 화면에 출력 
    
  - 페이지에서 User가 조회하고자 하는 년도와 월 값 입력 받고, 
    DB에 기록된 그 달의 출퇴근 기록을 바탕으로 기준 근로시간과 초과 근무 시간을 계산, 총 근무시간으로 근무 연차에 따라   
    기본급과 초과수당 및 합계 금액을 계산 및 화면에 출력  
    
* ### 구동 실험 환경
  
  ```
  - Window  
  - 다른 OS에선 구동해보지 않았습니다.
  ```
    
* ### 데이터 구조  

  **workers**
  | Field           | Type        | Key | Extra          |
  |-----------------|-------------|-----|----------------|
  | worker_number   | int         | PRI | auto_increment |
  | worker_id       | varchar(30) |     | not null       |
  | worker_password | varchar(30) |     | not null       |
  | name            | varchar(30) |     | not null       |
  | career          | int         |     | default 0      |
  | gender          | char(1)     |     |                |
    
  **office_hour**
  | Field          | Type        | Key | Extra                                       |
  |----------------|-------------|-----|---------------------------------------------|
  | office_hour_id | int         | PRI | auto_increment                              |
  | worker_number  | int         | FK  | not null, references workers(worker_number) |
  | work_start     | timestamp   |     | default current_timestamp                   |
  | work_end       | timestamp   |     |                                             |
  | offday         | varchar(10) |     | default '근무'                              |
  
* ### 트러블 이슈  
  
  ![image url](https://github.com/12OneTwo12/webApplication-project-220831/blob/main/plan/trouple.png?raw=true)   
      
  DB와의 연결에서 편의성을 위해 Mybatis를 사용하는 과정에서 쿼리문을 작성한 곳에서   
  몇가지 메소드에서 파라미터 값이 들어가지 않는다는 예외를 받았다.    
  예외가 일어나는 곳을 찾기위해 콘솔 출력문을 대입해 보다 쿼리문에 파라미터 값을 전할때 2가지 이상의 파라미터가 들어가는 메소드들이   
  예외가 일어난 다는 것을 알게 됐고, 이를 어노테이션 ```@Param```을 이용해 해결했다.   
    
  ![image url](https://github.com/12OneTwo12/webApplication-project-220831/blob/main/plan/trouple2.png?raw=true)  
    
      
* ### 느낀 점

  - 정정일  
    
    ```
    이번이 나에게는 두번째 팀 프로젝트였다. 전보다는 협업이라는 개념을 좀 더 몸으로 느낄 수 있었다.  
    Spring framework를 처음 사용해보면서 MVC 패턴을 통해 서로 역할을 나누고 함께 진행할 수 있다는 것을 느낄 수 있는 프로젝트였다.  
    다소 아쉬운점은 Git에 대한 이해도가 떨어져 코드를 합치는 과정에서 문제가 있었다는 점이였다. Git에 대한 공부가 더 필요함을 느끼는 프로젝트였다.  
    ```
    
  - 박광덕  
    
    ```
    스프링 MVC프레임워크 동작으로 웹사이트를 만들면서 MVC프레임워크 동작은 어떻게되는지 어노테이션이 어떤기능을 하는지,   
    내가 어떤부분이 부족하며 내가 만든기능으로 웹사이트에서 직접 구현되는걸 보면서 많은 뿌듯함을 느꼇다.  
    무엇보다 사람들간의 협업이 잘되어 좋은 결과물을 만든거같다.  
    ```
  
  - 조재현  
    
    ```
    프로젝트를 하는데 있어서 팀원 개개인의 역량에 따른 역할 분배가 중요하다는 생각을 가지고 있었는데 완벽하지는 않았겠지만   
    팀원들간의 의사소통이 잘 이루어져서 좋은 프로젝트 경험이었다 생각한다.  
    ```
   
  - 정지영  
    
    ```
    프로젝트를 하면서 막힘없이 했냐 그러면 그렇다고 말할 정도로 수월하게 진행된 프로젝트였다.   
    프로젝트를 수월하게 만든 요소 중 가장 큰 요소라고 생각하는 것은 적극적인 피드백이 아닌가 싶었다.   
    조장의 주도하에 처음 회의부터 의견을 나눴으며 정말 틈틈이 서로의 의견을 공유하고 오류도 소통하면서 해결했다.    
    프로젝트를 순항하게 만드는 가장 큰 요인은 소통인 걸 생각하게 됐다.  
    ```
      
* ### 동작 과정  

  ![image url](https://github.com/12OneTwo12/webApplication-project-220831/blob/main/plan/ezgif.com-gif-maker%20(1).gif?raw=true)   
  ![image url](https://github.com/12OneTwo12/webApplication-project-220831/blob/main/plan/ezgif.com-gif-maker%20(3).gif?raw=true)   
  ![image url](https://github.com/12OneTwo12/webApplication-project-220831/blob/main/plan/ezgif.com-gif-maker%20(4).gif?raw=true)   
