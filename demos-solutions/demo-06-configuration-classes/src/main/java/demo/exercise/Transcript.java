package demo.exercise;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private List<String> messages;
    private int transcriptSize;
    private boolean cyclic;

    public Transcript(int transcriptSize, boolean cyclic) {
        messages = new ArrayList<>();
        this.transcriptSize = transcriptSize;
        this.cyclic = cyclic;
    }

    public void log(String message) {
        if (messages.size() != transcriptSize) {
            messages.add(message);
        }
        else if (cyclic) {
            messages.clear();
            messages.add(message);
        }
        else {
            System.out.printf("**** Transcript full, message not stored: %s\n", message);
        }
    }

    public void display() {
        System.out.printf("%d messages in transcript:\n", messages.size());
        for (String message: messages) {
            System.out.printf("\t%s\n", message);
        }
    }
}

