<%--
    Login form
--%>
<form class="text-center px-5 py-2" method="post">

    <!-- Identifier -->
    <input name="email" type="email" id="email" class="form-control mb-4" placeholder="E-mail"
           value="<c:out value="${requestScope.user.email}"/>" aria-describedby="loginEmailHelpBox"
           aria-errormessage="loginEmailErrorBox">
    <small id="loginEmailErrorBox" class="form-text text-danger mb-4">
        ${requestScope.login_form.errors['email']}
    </small>

    <!-- Password -->
    <input name="password" type="password" id="password" class="form-control mb-4" placeholder="Password"
           aria-errormessage="loginPasswordErrorBox">
    <small id="loginPasswordErrorBox" class="form-text text-danger mb-4">
        ${requestScope.login_form.errors['password']}
    </small>
    <!-- Sign in button -->
    <button class="btn btn-efrei btn-block my-4 rounded justify-content-center" type="submit">
        <img class="mini-logo" src="<c:url value="/assets/logo/mini-logo-efrei.png"/>" alt="Logo Efrei Paris">
        <span class="ml-2">Sign in</span>
    </button>
    <span class="text-danger">${requestScope.login_form.message}</span>
</form>
