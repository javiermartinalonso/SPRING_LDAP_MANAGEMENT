<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/components/taglibs.jsp"%>

<c:url value="/j_spring_security_check " var="login_path" />

<div class="container">
	<div class="row">
		<div class="span4 offset4 well">			
			<form:form method="POST" action="${login_path }" >				
	            <fieldset>
					<legend><s:message code="forms.security.login.labels.title"/></legend>
					<c:if test="${not empty success_message}">
						<div class="alert alert-success"><s:message code="${success_message}"/></div>
					</c:if>
					<c:if test="${not empty error_message}">
						<div class="alert alert-error"><s:message code="${error_message}"/></div>
					</c:if>         	
					<input type="text" id="username" class="span12" name="j_username" placeholder="Usuario">
					<input type="password" id="password" class="span12" name="j_password" placeholder="Password">	            
					<button type="submit" name="submit" class="btn btn-info btn-block"><s:message code="forms.security.login.buttons.signin"/></button>
				</fieldset>
			</form:form>    
		</div>
	</div>
</div>