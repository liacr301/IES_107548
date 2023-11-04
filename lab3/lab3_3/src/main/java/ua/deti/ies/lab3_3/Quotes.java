package ua.deti.ies.lab3_3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quotes")

public class Quotes {
    private long id;
    private Movies movie;
    private String quote;
    
    public Quotes(Movies movie, String quote){
        this.movie = movie;
        this.quote = quote;
    }


   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // @Column(name = "movie", nullable = false)
    @ManyToOne
    public Movies getMovie() {
        return this.movie;
    }
    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    @Column(name = "quote", nullable = false)
    public String getQuote() {
        return this.quote;
    }
    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Quote: " + quote + " - " + movie.getTitle();
    }

}