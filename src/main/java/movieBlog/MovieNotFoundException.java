package movieBlog;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String name){
        super("Could not find a movie" + name);
    }
}
