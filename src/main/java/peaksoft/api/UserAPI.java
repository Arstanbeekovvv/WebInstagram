package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.service.UserService;

import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/users/search")
    String searchUsers(@RequestParam String keyword, Model model){
      List<User> searchUsers = userService.search(keyword);
      model.addAttribute("searchUsers", searchUsers);
      return "user/result-search";
    }



    @GetMapping("/new")
    String newUser(Model model){
        model.addAttribute("newUser", new User());
        return "user/new";
    }


    @PostMapping("/save")
    String saveUser(User user){
        userService.save(user);
        return "redirect:/";
    }


    @GetMapping("/favorite/{loginId}/{favoriteUserId}")
    String favorite(@PathVariable Long favoriteUserId, @PathVariable Long loginId){
        userService.favorite(loginId, favoriteUserId);
        return "user/result-search";
    }




}
