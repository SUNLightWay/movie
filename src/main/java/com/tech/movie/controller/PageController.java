package com.tech.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String jumpToHome(){
        return "client/index";
    }

    @RequestMapping("/home2")
    public String jumpToHome2() {
        return "client/index2";
    }

    @RequestMapping("/home3")
    public String jumpToHome3() {
        return "client/index3";
    }

    @RequestMapping("/catalog")
    public String jumpToCatalog() {
        return "client/catalog";
    }

    @RequestMapping("/category")
    public String jumpToCategory() {
        return "client/category";
    }

    @RequestMapping("/details")
    public String jumpToDetails(Model model, @RequestParam Integer movieId) {
        model.addAttribute("movieId", movieId);
        return "client/details";
    }

    @RequestMapping("/live")
    public String jumpToLive() {
        return "client/live";
    }

    @RequestMapping("admin/addItemPage")
    public String jumpTpAddItemPage(){
        return "admin/add-item";
    }

    @RequestMapping("admin/editUserPage")
    public String jumpToEditUserPage(){
        return "admin/edit-user";
    }

    @RequestMapping("admin/catalog")
    public String jumpToAdminCatalog(){
        return "admin/catalog";
    }

    @RequestMapping("admin/comments")
    public String jumpToComment(){
        return "admin/comments";
    }

    @RequestMapping("admin/home")
    public String jumpToAdminIndex(){
        return "admin/index";
    }

    @RequestMapping("admin/reviews")
    public String jumpToReviews(){
        return "admin/reviews";
    }

    @RequestMapping("admin/users")
    public String jumpToUsers(){
        return "admin/users";
    }
}
