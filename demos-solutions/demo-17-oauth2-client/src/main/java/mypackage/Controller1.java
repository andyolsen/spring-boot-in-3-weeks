package mypackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @GetMapping(path="/controller1")
    public String get() {
        return "Hello from Controller1";
    }
}
