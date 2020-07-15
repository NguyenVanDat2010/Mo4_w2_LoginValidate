package demo.controller;

import demo.model.PhoneNumber;
import demo.model.User;
import demo.service.phone.IPhoneNumberService;
import demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    IPhoneNumberService phoneNumberService;

    @ModelAttribute("phoneNumber")
    public Iterable<PhoneNumber> phoneNumbers(){
        return phoneNumberService.findAll();
    }

    @GetMapping
    public String showListUser(Model model){
        model.addAttribute("users",userService.findAll());
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreateUser(Model model){
        model.addAttribute("user",new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "user/create";
        }
        userService.save(user);
        model.addAttribute("user",new User());
        model.addAttribute("success", "New user created successfully!");
        return "user/create";
    }
}
