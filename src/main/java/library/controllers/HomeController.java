package library.controllers;


import library.models.Article;
import library.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(final Model model) {
        final List<Article> recentArticles = articleService.findLatest(5);
        model.addAttribute("recentArticles", recentArticles);

        return "index";
    }
}
