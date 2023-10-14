package ua.deti.ies.Lab2_4;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class QuotesRestController {

    private static final String template = "Quote: %s!";
    private final AtomicLong counter_quote = new AtomicLong();
    HashMap<Integer, String> quotes = new HashMap<Integer, String>();
    HashMap<Integer, String> shows = new HashMap<Integer, String>();

    public QuotesRestController() {
        quotes.put(1, "Now I Know What A TV Dinner Feels Like.");
        quotes.put(1, "Does It Sound Like I'm Ordering A Pizza?");
        quotes.put(2, "She begged for her life...");
        quotes.put(2, "What's in the box?");
        quotes.put(3, "We always called each other Goodfellas.");
        quotes.put(4, "What I need is a real, live ghost.");
        quotes.put(4, "Solving mysteries was a lot more fun than selling them.");

        shows.put(1, "Die Hard");
        shows.put(2, "Seven");
        shows.put(3, "Goodfellas");
        shows.put(4, "Scooby-Doo on Zombie Island");
    }
    @GetMapping("/quote")
    public Quote quote() {
        int r = (int) (Math.random() * (7 - 1)) + 1;
        String rand_quote = quotes.get(r);
        return new Quote(r, String.format(template, rand_quote));
    }


    //this one is working too ----> going to change
    @GetMapping("/shows")
    public List<Show> shows() {
        List<Show> shows_all = new ArrayList<>();
        for (int i = 1; i < shows.size()+1; i++){
            Show new_show = new Show(i, shows.get(i));
            shows_all.add(new_show);
        }
        return shows_all;
    }

    @GetMapping("/quotes?show=<show_id>")
    public List<Quote> specificShow(@RequestParam("show_id") int showId) {
        List<Quote> quotesShow = new ArrayList<>();
        // Logic to retrieve quotes for the specified show_id
        return quotesShow;
    }

}