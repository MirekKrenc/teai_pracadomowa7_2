package krenc.mirek.teaipracadomowa72.service;

import krenc.mirek.teaipracadomowa72.model.News;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBServiceImpl implements DbService{

    private JdbcTemplate jdbcTemplate;

    public DBServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<News> findAll() {
        String sql = "select * from news";
        List<News> newsList = jdbcTemplate.query(sql, (resultSet, i) ->
                new News(resultSet.getString("author"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("url"),
                        resultSet.getString("url_to_image")));

        return newsList;
    }

    @Override
    public void save(News news) {
        String sql = "insert into news values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, news.getAuthor(), news.getDescription(), news.getTitle(), news.getUrl(), news.getUrlToImage());
    }
}
