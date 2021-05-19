package com.dft.aspect;

//import org.apache.log4j.Logger;
//import org.apache.logging.log4j.core.layout.LoggerFields;

//@Aspect
//@Component//配置bean
public class WebLogAspect {
//    private Logger log = LoggerFactory.getLogger(WebLogAspect.class);

//    @Pointcut("execution(public * com.dft.controller..*.*(..))")
//    public void webLog() {
//
//    }
//
//    @Before("webLog()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 记录下请求内容
//        log.info("---------------request----------------");
//        log.info("URL : " + request.getRequestURL().toString());
//        log.info("HTTP_METHOD : " + request.getMethod());
//        log.info("IP : " + request.getRemoteAddr());
//        Enumeration<String> enu = request.getParameterNames();
//        while (enu.hasMoreElements()) {
//            String name = (String) enu.nextElement();
//            log.info("name:" + name + " - value:" + request.getParameter(name));
//        }
//    }
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        log.info("---------------response----------------");
//        // 处理完请求，返回内容
//        log.info("RESPONSE : " + ret);
//    }
}
