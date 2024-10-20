<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-header">
            board Modify
        </div>
        <div class="card-body">
            <h5 class="card-title">board Modify 페이지</h5>
            <form>
                <div class="input-group mb-3">
                    <label class="input-grout-text">Bno</label>
                    <input class="form-control" type="text" name="bno" value="${dto.bno}" readonly>
                </div>
                <div class="input-group mb-3">
                    <label class="input-grout-text">Title</label>
                    <input class="form-control" type="text" name="title" value="${dto.title}">
                </div>
                <div class="input-group mb-3">
                    <label class="input-grout-text">Comment</label>
                    <input class="form-control" type="text" name="content" value="${dto.content}">
                </div>
                <div class="input-group mb-3">
                    <label class="input-grout-text">Writer</label>
                    <input class="form-control" type="text" name="writer" value="${dto.writer}" readonly>
                </div>

                <div class="my-4">
                    <div class="float-end">
                        <button type="button" class="btn btn-primary">Modify</button>
                        <button type="button" class="btn btn-danger">Delete</button>
                        <button type="button" class="btn btn-secondary">List</button>
                    </div>
                </div>
            </form>
        </div>
        <script>
            const formObj=document.querySelector("form")

            document.querySelector(".btn-primary").addEventListener("click",function (e) {
                e.preventDefault();
                e.stopPropagation();
                formObj.action=`/board/modify?${pageRequestDTO.link}`;
                formObj.method="POST"
                formObj.submit();
            }, false);

            document.querySelector(".btn-danger").addEventListener("click",function (e) {
                e.preventDefault();
                e.stopPropagation();
                formObj.action="/board/remove";
                formObj.method="POST"
                formObj.submit();
            }, false);

            document.querySelector(".btn-secondary").addEventListener("click",function (e) {
                e.preventDefault();
                e.stopPropagation();
                self.location='/board/list?${pageRequestDTO.link}';
            }, false);
        </script>

    </div>
</div>
<%@include file="../includes/footer.jsp"%>.
