package krenc.mirek.teaipracadomowa72.config;

import krenc.mirek.teaipracadomowa72.model.News;
import krenc.mirek.teaipracadomowa72.rest.RestApi;
import krenc.mirek.teaipracadomowa72.service.DBServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class InitialDbConfig {

    private JdbcTemplate jdbcTemplate;
    private RestApi restApi;
    private DBServiceImpl dbService;

    public InitialDbConfig(JdbcTemplate jdbcTemplate, RestApi restApi, DBServiceImpl dbService) {
        this.jdbcTemplate = jdbcTemplate;
        this.restApi = restApi;
        this.dbService = dbService;
    }

    @PostConstruct
    public void initDb()
    {
        String sql = "create table news (author varchar(50), title varchar(500), description varchar(1000), url varchar(200), url_to_image varchar(500))";
        jdbcTemplate.update(sql);

        List<News> news = restApi.getNews(restApi.getNewsJSON());

        if (news != null)
        {
            news.stream()
                    .forEach(news_item -> dbService.save(news_item));
        }
    }
}

//    private String author;
//    private String title;
//    private String description;
//    private String url;
//    private String urlToImage;
