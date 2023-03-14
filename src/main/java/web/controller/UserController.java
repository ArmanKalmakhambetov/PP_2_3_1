package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/{id}")
    public String getUserById (@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("users", user);
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users";
    }


}
