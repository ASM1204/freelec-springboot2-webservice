package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.service.posts.RankService;
import com.jojoldu.book.springboot.service.posts.ShopService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.dto.ShopResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final RankService rankService;
    private final ShopService shopService;
    private final HttpSession httpSession;




    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("rank", rankService.findRank());
        model.addAttribute("shop", shopService.findShop());

        return "index";
    }



    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/shop/buy/{id}")
    public String shopBuy(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        ShopResponseDto dto = shopService.findById(id);
        model.addAttribute("buy", dto);
        model.addAttribute("berry",user.getBerry());
        return "shop-buy";
    }
}
