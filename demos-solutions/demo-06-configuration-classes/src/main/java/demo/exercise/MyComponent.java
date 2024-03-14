package demo.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Autowired
    private Transcript transcript;

    public void doSomething() {
        transcript.log("Bonjour");
        transcript.log("Hei hei");
        transcript.log("நல்ல நாள்");
        transcript.log("Hola");
        transcript.log("Guten Tag");
        transcript.log("Hello");
        transcript.log("Prynhawn da");

        transcript.display();
    }

}
