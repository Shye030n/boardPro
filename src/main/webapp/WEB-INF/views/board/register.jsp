
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/header.jsp"%>
<div class="row-content">
    <div class="card">
        <div class="card-header">
            Board Register Page
        </div>
        <div class="card-body">
            <h5 class="card-title">Board Register</h5>
            <form action="/board/register" method="post">
                <div class="input-group mb-3">
                    <label class="input-grout-text">Title</label>
                    <input class="form-control" type="text" name="title" placeholder="Title">
                </div>
                <div class="input-group mb-3">
                    <label class="input-grout-text">Comment</label>
                    <input class="form-control" type="text" name="content" placeholder="Content">
                </div>
                <div class="input-group mb-3">
                    <label class="input-grout-text">Writer</label>
                    <input class="form-control" type="text" name="Writer" placeholder="Writer">
                </div>
                <div class="my-4">
                    <div class="float-end">
                        <button type="submit" class="btn btn-primary">등록</button>
                        <button type="reset" class="btn btn-secondary" formaction="/board/list" method="post">목록 보기</button>
                    </div>
                </div>
            </form>
            <script>
                console.log(`${errors}`)
            </script>

        </div>
    </div>
</div>
<%@include file="../includes/footer.jsp"%>