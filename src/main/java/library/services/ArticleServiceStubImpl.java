package library.services;

import library.models.Article;
import library.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ArticleServiceStubImpl implements ArticleService {
    private final List<Article> articles = new ArrayList<Article>() {{
        add(new Article(1L, "Какви са фермите в ЕС и какви са в България?", "Rerolling...", new User(10L, "e.ivanov", "Emil Ivanov")));
        add(new Article(2L, "ІТ и ayтcopcинг ĸoмпaниитe движaт 80% oт нaeмнитe cдeлĸи в Coфия\n" +
                "Aвтop: mоnеу.bg", "Ret pala <3", new User(20L, "k.dobrev", "Kris Dobrev")));
        add(new Article(3L, "Nvidia е близо до най-голямата сделка в историята си", "Rerolling...", new User(10L, "e.ivanov", "Emil Ivanov")));
        add(new Article(4L, "Spotify завладя Индия", "Ret pala <3", new User(20L, "k.dobrev", "Kris Dobrev")));
        add(new Article(5L, "ВМРО са против опрощаването на дълговете на вероизповеданията", "Rerolling...", new User(10L, "e.ivanov", "Emil Ivanov")));
        add(new Article(6L, "40% от жените страдат от миома", "Ret pala <3", new User(20L, "k.dobrev", "Kris Dobrev")));
    }};

    @Override
    public List<Article> findAll() {
        return this.articles;
    }

    @Override
    public List<Article> findLatest(final int numArticles) {
        return this.articles.stream().sorted((a, b) -> b.getDate().compareTo(a.getDate())).limit(numArticles).collect(Collectors.toList());
    }

    @Override
    public Article findById(final Long id) {
        return this.articles.stream().filter(a -> Objects.equals(a.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public Article create(final Article article) {
        article.setId(this.articles.stream().mapToLong(a -> a.getId()).max().getAsLong() + 1);
        this.articles.add(article);
        return article;
    }

    @Override
    public Article edit(final Article article) {
        for(int i = 0; i < this.articles.size(); i++) {
            if(Objects.equals(this.articles.get(i).getId(), article.getId())) {
                this.articles.set(i, article);
                return article;
            }
        }
        throw new RuntimeException("Article not found: " + article.getId());
    }

    @Override
    public void deleteById(final Long id) {
        for (int i = 0; i < this.articles.size(); i++) {
            if (Objects.equals(this.articles.get(i).getId(), id)) {
                this.articles.remove(i);
                return;
            }
        }
        throw new RuntimeException("Article not found: " + id);
    }
}
