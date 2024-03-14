package mypackage;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

    @GetMapping(path="/controller2")
    public String get() {
        return "Hello from Controller2";
    }

    @GetMapping(path="/controller2-with-info")
    public String getWithName(@AuthenticationPrincipal OAuth2User principal) {
        return "Hello from Controller2, " +
                principal.getAttribute("name") + ", " +
                principal.getAttribute("company");
    }

}
