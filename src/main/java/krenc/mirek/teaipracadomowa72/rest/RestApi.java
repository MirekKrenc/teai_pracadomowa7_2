package krenc.mirek.teaipracadomowa72.rest;

import krenc.mirek.teaipracadomowa72.json.Article;
import krenc.mirek.teaipracadomowa72.json.NewsJSON;
import krenc.mirek.teaipracadomowa72.model.News;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestApi {

    private RestTemplate restTemplate;
    private final String URL = "https://newsapi.org/v2/top-headlines?country=pl&apiKey=9cef0b761e024c778debd099e16e256a";

    public RestApi() {
        this.restTemplate = new RestTemplate();
    }

    public Article[] getNewsJSON() {
        NewsJSON newsJSON = restTemplate.getForObject(URL, NewsJSON.class);
        return newsJSON != null ? newsJSON.getArticles() : null;
    }

    public List<News> getNews(Article[] articles) {
        if (articles == null)
        return null;
        List<News> newsList = new ArrayList<>();

        for(int i=0; i<articles.length; i++)
        {
            newsList.add(new News(articles[i].getAuthor(), articles[i].getTitle(), articles[i].getDescription()
            ,articles[i].getUrl(), articles[i].getUrlToImage()));
        }
        return newsList;
    }
}
