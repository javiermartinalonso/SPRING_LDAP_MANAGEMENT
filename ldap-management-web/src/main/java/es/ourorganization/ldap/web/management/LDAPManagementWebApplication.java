//package es.ourorganization.ldap.web.management;
//
//
//import java.util.Arrays;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.context.web.SpringBootServletInitializer;
//import org.springframework.context.ApplicationContext;
//
//@SpringBootApplication
//public class LDAPManagementWebApplication extends SpringBootServletInitializer {
//
//	@Value("${server.contextPath}")
//	private static final String nameApp = "MyApp";
//	
//	@Value("${server.port}")
//	private static final String port = "8080";
//	
//	private static Class<LDAPManagementWebApplication> applicationClass = LDAPManagementWebApplication.class;
//	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LDAPManagementWebApplication.class);
//
//	public LDAPManagementWebApplication() {
//	}
//
//	public static void main(String[] args) {
//		log.info("################ INICIO MAIN #####################");
//		SpringApplication.run(applicationClass, args);
//		ApplicationContext ctx = SpringApplication.run(applicationClass, args);
//		log.info("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//        	log.info(beanName);
//        }
//        
//		log.info("################# TEST LOGS ######################");
//		testLogs();
//		log.info("################# FIN MAIN #######################");
//	}
//
//	private static void testLogs() {
//
//		log.info("------- STARTED 'provision-api' -------------");
//		log.info("URL 'Swagger': http:/" + nameApp + ":" + port + "/swagger-ui.html");
//		log.info("----------------------------------------------------");
//
//		log.trace("LogTest - TRACE");
//		log.debug("LogTest - DEBUG");
//		log.info("LogTest - INFO");
//		log.warn("LogTest - WARN");
//		log.error("LogTest - ERROR");
//
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		log.info("################ INICIO CONFIGURE #####################");
//		SpringApplicationBuilder sab = application.sources(applicationClass);
//		log.info("################# TEST LOGS ######################");
//		testLogs();
//		log.info("################# FIN CONFIGURE #######################");
//		return sab;
//	}
//
//}
