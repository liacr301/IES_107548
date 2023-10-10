package ua.deti.ies.Lab2_4;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class QuotesRestController {

    private static final String template = "Quote: %s!";
    private final AtomicLong counter_quote = new AtomicLong();

    //this one is working
    @GetMapping("/quote")
    public Quote quote() {
        return new Quote(counter_quote.incrementAndGet(), String.format(template, "Say hello to my little friend!"));
    }

    //this one is working too
    @GetMapping("/shows")
    public List<Show> shows() {
        Show show_1 = new Show(1, "Die Hard");
        Show show_2 = new Show(2, "Goodfellas");
        Show show_3 = new Show(3, "Seven");
        Show show_4 = new Show(4, "Scooby-Doo on Zombie Island");

        List<Show> shows_all = new ArrayList<Show>();
        shows_all.add(show_1);
        shows_all.add(show_2);
        shows_all.add(show_3);
        shows_all.add(show_4);

        return shows_all;
    }

    @GetMapping("/quotes?show=<show_id>")
    public Greeting shows(@RequestParam(value = "show", defaultValue = "None") String show) {
        HashMap<Show,String> show_quotes = new HashMap<>();
        show_quotes.put((1,"Die Hard"),"Nice Suit. John Philips, London. I Have Two Myself.");
        show_quotes.put((1,"Die Hard"),"Now I Know What A TV Dinner Feels Like.");
        show_quotes.put((1,"Die Hard"),"Does It Sound Like I'm Ordering A Pizza?");
        show_quotes.put((2,"Goodfellas"),"We always called each other Goodfellas.");
        show_quotes.put((3,"Seven"),"She begged for her life...");
        show_quotes.put((3,"Seven"),"What's in the box?");
        show_quotes.put((3,"Seven"),"David. If you kill him, he will win.");
        show_quotes.put((3,"Seven"),"This isn't going to have a happy ending.");
        show_quotes.put((4,"Scooby-Doo on Zombie Island"),"What I need is a real, live ghost.");
        show_quotes.put((4,"Scooby-Doo on Zombie Island"),"Solving mysteries was a lot more fun than selling them.");
        return
    }
}