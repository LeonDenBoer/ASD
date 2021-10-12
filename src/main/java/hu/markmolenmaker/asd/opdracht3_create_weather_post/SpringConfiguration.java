package hu.markmolenmaker.asd.opdracht3_create_weather_post;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SpringConfiguration {

    @Bean
    public static ApplicationContextProvider contextProvider() {
        return new ApplicationContextProvider();
    }

    @Component
    public static class ApplicationContextProvider implements ApplicationContextAware {

        private static ApplicationContext context;

        public ApplicationContext getApplicationContext() {
            return context;
        }

        @Override
        public void setApplicationContext(ApplicationContext ctx) {
            context = ctx;
        }
    }
}
