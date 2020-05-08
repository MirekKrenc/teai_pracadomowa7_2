package krenc.mirek.teaipracadomowa72.controller;

import krenc.mirek.teaipracadomowa72.model.News;
import krenc.mirek.teaipracadomowa72.service.DBServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsApi {

    private DBServiceImpl dbService;

    public NewsApi(DBServiceImpl dbService) {
        this.dbService = dbService;
    }

    @GetMapping
    public String getNews(Model model)
    {
        List<News> newsList = dbService.findAll();
        model.addAttribute("newsy", newsList);

        return "news";
    }

}
