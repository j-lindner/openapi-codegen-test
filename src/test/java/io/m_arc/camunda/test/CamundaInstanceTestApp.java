package io.m_arc.camunda.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CamundaInstanceTestApp {
    public static void main(String... args) {
        SpringApplication.run(CamundaInstanceTestApp.class, args);
    }

    // Format expected from API: 2023-03-21T20:57:30.558Z
    // exception w/ default: java.lang.Exception: {"type":"InvalidRequestException","message":
    // "Cannot set query parameter 'after' to value '2023-03-21T20:57:30.558Z':
    // Cannot convert value \"2023-03-21T20:57:30.558Z\" to java type java.util.Date","code":null}

//    @Bean
//    public ServletContextInitializer initializer() {
//        return new ServletContextInitializer() {
//            @Override
//            public void onStartup(ServletContext servletContext) throws ServletException {
//                servletContext.addListener(new CustomJacksonDateFormatListener());
//                servletContext.setInitParameter("org.camunda.bpm.engine.rest.jackson.dateFormat",
//                        "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//            }
//        };
//    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
