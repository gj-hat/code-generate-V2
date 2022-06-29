package com.jiaguo.codegenerategraduation.advice;

import com.jiaguo.codegenerategraduation.common.exception.*;
import com.jiaguo.codegenerategraduation.common.http.Result;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.LinkedHashMap;

@ControllerAdvice
@RestControllerAdvice
public class GlobalControllerExceptionAdvice implements ResponseBodyAdvice<Object> {
    private static final Logger log = LoggerFactory.getLogger(GlobalControllerExceptionAdvice.class);

    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, @NotNull Class selectedConverterType, @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {

        if (body instanceof LinkedHashMap) {
            LinkedHashMap<String, Object> bodyData = (LinkedHashMap<String, Object>) body;
            return Result.fail(Result.DEFAULT_FAIL_CODE, bodyData.get("message").toString());
        }
        return body;
    }


    @ResponseBody
    @ExceptionHandler({BadCredentialsException.class, UsernameNotFoundException.class})
    public Result handleAuthException(HttpServletRequest request, Exception ex) {
        log.error("handlerRRException :", ex);
        return Result.fail("用户名或密码不匹配,请重新输入!");
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(HttpServletRequest request, Exception e) {
        log.error("handleException : ", e);
        return Result.fail("系统内部发生异常!");
    }

    /**
     * 数据授权签名异常
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({InvalidKeyException.class})
    public Result<String> handleInvalidKeyException(HttpServletRequest request, InvalidKeyException e) {
        log.error("RAS sign exception : ", e);
        return Result.fail("授权机制异常!请联系管理员.");
    }


    /**
     * 数据交互异常
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({IOException.class})
    public Result<String> handleIOException(HttpServletRequest request, IOException e) {
        log.error("handleIOException : ", e);
        return Result.fail("数据交互异常!");
    }

    /**
     * 权限校验错误，统一异常处理类
     *
     * @param request
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler({TokenException.class, AccessDeniedException.class})
    public Result<String> handleAccessException(HttpServletRequest request, Exception e) {
        log.error("handleIOException : ", e);
        return Result.fail("权限校验错误，非法操作。有其他任何问题，请联系管理员!");
    }


    /**
     *
     * @param request
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler({IllegalArgumentException.class})
    public Result<String> handleRuntimeException(HttpServletRequest request, IllegalArgumentException ex) {
        log.error("Request Params Exception ", ex);
        return Result.fail(ex.getMessage());
    }

    /**
     * 系统内部未捕获异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public Result<String> handleRuntimeException(Throwable ex) {
        log.error("Handler RuntimeException ", ex);
        return Result.fail("An exception occurred inside the system， Please contact the administrator.");
    }


    @ResponseBody
    @ExceptionHandler({RRException.class})
    public Result handleAuthException(HttpServletRequest request, RRException ex) {
        log.error("handlerRRException :", ex);
        return Result.fail(ex.getMsg());
    }


    /**
     * @param request
     * @param ex
     * @returnf
     */
    @ExceptionHandler(CannotCreateTransactionException.class)
    @ResponseBody
    public Result handleCannotCreateTransactionException(HttpServletRequest request, Exception ex) {
        log.error("Access databases Exception ", ex);
        return Result.fail("数据库连接失败");
    }


    /**
     * 方法请求参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        log.error("System request Argument Exception : {} ", defaultMessage, ex);
        return Result.fail(defaultMessage);
    }

    /**
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, UnsupportedOperationException.class})
    @ResponseBody
    public Result handleHttpRequestMethodNotSupportedException(HttpServletRequest request, Exception ex) {
        log.error("Http request not supported exception", ex);
        return Result.fail("不支持的URL请求");
    }

    @ExceptionHandler(AccountException.class)
    @ResponseBody
    public Result handleAccountException(HttpServletRequest request, AccountException ex) {
        log.error("账户异常", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }


    /**
     * 自定义参数异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(ParameterException.class)
    @ResponseBody
    public Result handleParameterException(HttpServletRequest request, ParameterException ex) {
        log.error("参数异常", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }


    /**
     * 自定义业务处理异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handleServiceException(HttpServletRequest request, ServiceException ex) {
        log.error("业务异常", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }



    /**
     * 自定义数据库处理异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(DatabaseException.class)
    @ResponseBody
    public Result handleDatabaseException(HttpServletRequest request, DatabaseException ex) {
        log.error("网关服务器异常", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }

    /**
     * 自定义文件处理异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(FileException.class)
    @ResponseBody
    public Result handleFileException(HttpServletRequest request, FileException ex) {
        log.error("文件处理异常", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }


    /**
     * 自定义其他异常
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(UnknownException.class)
    @ResponseBody
    public Result handleUnknownException(HttpServletRequest request, UnknownException ex) {
        log.error("其他异常", ex);
        return Result.fail(ex.getCode(), ex.getMessage());
    }





}