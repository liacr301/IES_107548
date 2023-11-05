package ua.deti.ies.lab3_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MoviesService {
    @Autowired
    private MovieRepository moviesRepository;

    @Autowired
    private QuoteRepository quotesRepository;

    // quotes

    public List<Quotes> getAllQuotes() {
        List<Quotes> quotes = new ArrayList<>();
        quotesRepository.findAll().forEach(quotes::add);
        return quotes;
    }


    public void deleteQuote(Long quoteId) {
        quotesRepository.deleteById(quoteId);
    }

    public Quotes updateQuote(Quotes quote)  {
        return quotesRepository.save(quote);
    }

    public Quotes getQuotesById(long id) {
        Optional<Quotes> optionalQuotes = quotesRepository.findById(id);
        return optionalQuotes.orElseThrow(() -> new NoSuchElementException("Couldn't find a Quotes with id: " + id));
    }

    public void addQuote(Quotes quote) {
        quotesRepository.save(quote);
    }

    public Quotes getRandomQuoteByMovieId(Long movieId) throws ResourceNotFoundException {
        List<Long> quotes= new ArrayList<>();
        Movies movie = moviesRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("ERROR: Movie not found for this id :: " + movieId));
        for(Quotes q : quotesRepository.findAll()) {
            if(q.getMovie().getTitle().equals(movie.getTitle())) {
                quotes.add(q.getId());
            }
        }
        Random random = new Random();
        return quotesRepository.findById(quotes.get(random.nextInt(quotes.size()))).orElse(null);
    }

    public Quotes getRandomQuoteRandomMovie() throws ResourceNotFoundException {
        ArrayList<Long> ids = new ArrayList<>();
        for(Quotes q : quotesRepository.findAll())  {
            ids.add(q.getId());
        }
        Random random = new Random();
        return quotesRepository.findById(ids.get(random.nextInt(ids.size()))).orElseThrow(() -> new ResourceNotFoundException("ERROR: No Quotes In The API"));
    }

    // movies

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Movies createMovie(Movies movie) {
        return moviesRepository.save(movie);
    }

    public Movies getMovieById(Long movieId) throws ResourceNotFoundException {
        return moviesRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("ERROR: Movie not found for this id :: " + movieId));
    }

    public Movies updateMovie(Movies movie)  {
        return moviesRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        moviesRepository.deleteById(movieId);
    }
}