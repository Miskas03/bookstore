package bookstoremiska.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }
    

}
