package krenc.mirek.teaipracadomowa72.service;

import krenc.mirek.teaipracadomowa72.model.News;

import java.util.List;

public interface DbService {

    public List<News> findAll();

    public void save(News news);

}
