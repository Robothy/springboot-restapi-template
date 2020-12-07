package site.luofuxiang.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfiguration {

    @Bean("templateMessageSource")
    public MessageSource exceptionMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("i18n/messages");
        resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

}
