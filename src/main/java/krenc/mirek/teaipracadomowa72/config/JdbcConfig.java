package krenc.mirek.teaipracadomowa72.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    private DataSource dataSource;

    public JdbcConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(dataSource);
    }

}
