package library.controllers;

import library.models.Article;
import library.services.ArticleService;
import library.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticlesController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/articles/view/{id}")
    public String view(@PathVariable("id") final Long id, final Model model) {
        final Article article = articleService.findById(id);
        if(article == null) {
            notifyService.addErrorMessage("Cannot find article: " + id);
            return "redirect:/";
        }
        model.addAttribute("article", article);
        return "articles/view";
    }
}
