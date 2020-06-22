package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.posts.*;
import com.jojoldu.book.springboot.web.dto.*;
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
    private final UserService userService;
    private final AuctionService auctionService;
    private final HttpSession httpSession;




    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("rank", rankService.findRank());
        model.addAttribute("shop", shopService.findShop());
        model.addAttribute("auction",auctionService.findAllAuction());

        return "index";
    }

    @GetMapping("/user")
    public String userMy( Model model, @LoginUser SessionUser user) {
        model.addAttribute("all_user",userService.findMy(user.getEmail()));
        return "user";
    }

    @GetMapping("/auction/select")
    public String auction_select( Model model, @LoginUser SessionUser user) {
        model.addAttribute("item_list",shopService.findShop());
        model.addAttribute("my",userService.findMy(user.getEmail()));
        return "auction-select";
    }

    @GetMapping("/user/my/{user_id}")
    public String userMy(@PathVariable Long user_id, Model model) {
        UserResponseDto dto = userService.findById(user_id);
        model.addAttribute("user_my",userService.findById(user_id));

        return "user-my";
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

    @GetMapping("/shop/buy/{item_id}")
    public String shopBuy(@PathVariable Long item_id, Model model, @LoginUser SessionUser user) {

        ShopBuyResponseDto dto = shopService.findById(item_id);
        model.addAttribute("my_email", user.getEmail());
        model.addAttribute("buy", dto);
        model.addAttribute("all_user",userService.findMy(user.getEmail()));

        return "shop-buy";
    }

//    @GetMapping("/auction/buy/{auction_id}")
//    public String auctionBuy(@PathVariable Long auction_id, Model model, @LoginUser SessionUser user) {
//
//        AuctionListResponseDto dto = auctionService.findById(auction_id);
//        model.addAttribute("my_email", user.getEmail());
//        model.addAttribute("buy", dto);
//        model.addAttribute("all_user",userService.findMy(user.getEmail()));
//
//        return "auction-buy";
//    }


}
//user : id, user_email, berry, smoke_bomb;
//buy : id, item_name, item_image, item_type, item_price;
//rank :
//shop :