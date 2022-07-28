# homeworkweek03
springboot


1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
-주소에 변수가 포함된 param이라는 방식을 사용했습니다. 주소 바깥에 변수를 포함하는 쿼리나 주소에서 확인할 수 없는 바디는 사용하지 않았습니다.

2. 어떤 상황에 어떤 방식의 request를 써야하나요?
-여러개의 데이터를 넘겨줄 때는 쿼리를 사용하고 민감한 정보라 암호화하여 전송해야 할 때 바디를 사용합니다.

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
-리소스 식별이 쉽게끔 url을 설계했고 효율적으로 요청과 응답 정보를 파악하기 쉽도록 설계했습니다. 

4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
-Controller에서 Service의 정보를 요청받고 Service에서는 Repo의 정보를 요청받도록 분리했습니다. 

5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요!
-PostingRepository, PostingService, PostingRestController


https://oxorr0424.tistory.com/9 
-유스 케이스 및 API설계
