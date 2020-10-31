import ch.vino.cinema.code.Movie;
import org.junit.jupiter.api.Test;

class MovieTest {

    Movie movie = new Movie("name", 12, 19.95, "Action", 100, 6);

    @Test
    void getFilmDescription() {
        assert ("Action | 12 | 100".equals(movie.getGenre() + " | " + movie.getFsk() + " | " + movie.getLength()));
    }

    @Test
    void getName() {
        assert ("name".equals(movie.getName()));
    }

    @Test
    void getFsk() {
        assert (12 == movie.getFsk());
    }

    @Test
    void getPrice() {
        assert (19.95 == movie.getPrice());
    }

    @Test
    void getGenre() {
        assert ("Action".equals(movie.getGenre()));
    }

    @Test
    void getIdx() {
        assert (6 == movie.getIdx());
    }

    @Test
    void getLength() {
        assert (100 == movie.getLength());
    }
}