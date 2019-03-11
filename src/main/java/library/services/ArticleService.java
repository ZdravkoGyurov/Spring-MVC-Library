package library.services;

import library.models.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    List<Article> findLatest(int numArticles);
    Article findById(Long id);
    Article create(Article article);
    Article edit(Article article);
    void deleteById(Long id);
}
