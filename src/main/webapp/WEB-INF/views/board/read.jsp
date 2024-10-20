<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-header">
            board 상세보기
        </div>
        <div class="card-body">
            <h5 class="card-title">board 상세보기 페이지</h5>
            <div class="input-group mb-3">
                <label class="input-grout-text">Bno</label>
                <input class="form-control" type="text" name="bno" value="${dto.bno}" readonly>
            </div>
            <div class="input-group mb-3">
                <label class="input-grout-text">Title</label>
                <input class="form-control" type="text" name="title" value="${dto.title}" readonly>
            </div>
            <div class="input-group mb-3">
                <label class="input-grout-text">Comment</label>
                <input class="form-control" type="text" name="content" value="${dto.content}" readonly>
            </div>
            <div class="input-group mb-3">
                <label class="input-grout-text">Writer</label>
                <input class="form-control" type="text" name="title" value="${dto.writer}" readonly>
            </div>


            <div class="my-4">
                <div class="float-end">
                    <button type="button" class="btn btn-primary">Modify</button>
                    <button type="button" class="btn btn-secondary">List</button>
                </div>
            </div>
        </div>
        <script>
            document.querySelector(".btn-primary").addEventListener("click",function (e){
                self.location='/board/modify?bno=${dto.bno}&${pageRequestDTO.link}'
            })
            document.querySelector(".btn-secondary").addEventListener("click",function (e) {
                self.location="/board/list?${pageRequestDTO.link}";
            }, false);

            <%--document.querySelector(".btn-primary").addEventListener("click",function (e) {--%>
            <%--  self.location="/board/modify?bno="+${dto.bno};--%>
            <%--}, false);--%>
            // document.querySelector(".btn-secondary").addEventListener("click",function (e) {
            //   self.location="/board/list";
            // }, false);
        </script>

    </div>
</div>

<%@include file="../includes/footer.jsp"%>