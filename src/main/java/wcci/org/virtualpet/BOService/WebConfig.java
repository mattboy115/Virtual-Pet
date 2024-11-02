package wcci.org.virtualpet.BOService;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * Configuration class for setting up web-related settings in the application.
 * This class implements {@link WebMvcConfigurer} to customize the default behavior of Spring MVC.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures path matching options for the application.
     * 
     * @param configurer the {@link PathMatchConfigurer} to be configured.
     * <p>
     * This method creates a {@link PathPatternParser} that is set to be case-insensitive,
     * allowing for more flexible URL matching within the application.
     * </p>
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // Create a new PathPatternParser instance
        var parser = new PathPatternParser();
        
        // Set the parser to be case-insensitive
        parser.setCaseSensitive(false);
        
        // Apply the parser to the configurer
        configurer.setPatternParser(parser);
    }
}
