package co.cgiar.view.manager.ggceview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class HelloWorldController {
    @GetMapping("/hello")
    public String greet() {
        return "Nunca pares de aprender";
    }
}
