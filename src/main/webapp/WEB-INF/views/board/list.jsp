<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 10. 11.
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--header부분--%>
<%@include file="../includes/header.jsp"%>
<%--검색 부분 test.html에서 복붙해서 수정함--%>
<div class="row-content">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Search</h5>

            <form action="/board/list" method="get">
                <input type="hidden" name="size" value="${pageRequestDTO.size}">

                <div class="mb-3">
                    <input type="checkbox" name="types" value="t" ${pageRequestDTO.checkType("t")?"checked":""}>제목
                    <input type="checkbox" name="types" value="w" ${pageRequestDTO.checkType("w")?"checked":""}>작성자
                    <%-- 제목에 체크하면 제목 검색, 작성자에 체크하면 작성자 검색--%>
                    <input type="text"  name="keyword" class="form-control" value="${pageRequestDTO.keyword}">
                </div>
                <div class="input-group mb-3 postDateDiv">
                    <input type="date" name="from" class="form-control" value="${pageRequestDTO.from}">
                    <input type="date" name="to" class="form-control" value="${pageRequestDTO.to}">
                </div>
                <div class="input-group mb-3">
                    <div class="float-end">
                        <button class="btn btn-primary" type="submit">Search</button>
                        <button class="btn btn-info clearBtn" type="reset">Clear</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="row-content">
    <div class="card">
        <div class="card-header">
            Featured
        </div>
        <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Bno</th>
                    <th scope="col">Content</th>
                    <th scope="col">Writer</th>
                    <th scope="col">PostDate</th>
                    <th scope="col">VisitCount</th>
                </tr>
                </thead>
                <tbody>
<%--                                <c:forEach items="${boardList}" var="dto">--%>
                <%--버튼 클릭 후 웹페이지 접속이 안될 때 ERROR가 "행 [40]에서 [/WEB-INF/views/board/register.jsp]을(를) 처리하는 중 예외 발생" 이런 거 뜨면 여기 주석처리 수정--%>
                <c:forEach items="${boardList}" var="dto">
                    <tr>
                        <th scope="row">${dto.bno}</th>
                        <td><a href="/board/read?bno=${dto.bno}">${dto.title}</a></td>
                        <td>${dto.writer}</td>
                        <td>${dto.postDate}</td>
                        <td>${dto.visitCount}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--     pagination 컴포넌트 활용 (웹페이지 밑 페이지 이동하는 부분)      --%>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:if test="${responseDTO.prev}">
                        <%-- <c:if test=" ">
                            jsp 에서 사용하는 jstl 조건문
                                => responseDTO의 객체인 next 속성이 true인 경우에만, 이 안에 내용 출력 --%>
                        <li class="page-item">
                            <a class="page-link" data-num="${responseDTO.start-1}" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                        <%-- <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                        <li class="page-item">
                            <a class="page-link" data-num="${num}">${num}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${responseDTO.next}">
                        <li class="page-item">
                            <a class="page-link" data-num="${responseDTO.end+1}" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
            <script>

                document.querySelector(".pagination").addEventListener("click", function (e){
                    e.preventDefault()
                    e.stopPropagation()
                    const target=e.target
                    if(target.tagName !== 'A'){
                        return
                    }
                    const num=target.getAttribute("data-num")
                    const formObj=document.querySelector("form");
                    formObj.innerHTML+=`<input type='hidden' name='page' value='\${num}'>`
                    formObj.submit()
                    //    self.location=`/board/list?page=\${num}&\${pageRequestDTO.link}`
                },false)
                document.querySelector(".clearBtn").addEventListener("click", function (e){
                    e.preventDefault()
                    e.stopPropagation()

                    self.location ='/board/list'

                },false)
            </script>
        </div>
    </div>
</div>
<%--footer 부분--%>
<%@include file="../includes/footer.jsp"%>
