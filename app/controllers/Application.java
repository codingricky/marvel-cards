package controllers;

import com.github.codingricky.marvel.RestClient;
import com.github.codingricky.marvel.model.*;
import play.*;
import play.mvc.*;

import play.mvc.Result;
import views.html.*;

import java.io.IOException;

public class Application extends Controller {

    public static Result index() {
        RestClient restClient = new RestClient(Keys.PRIVATE_KEY, Keys.PUBLIC_KEY);
        String path = null;
        try {
            final com.github.codingricky.marvel.model.Result<MarvelCharacter> character = restClient.getCharacter(1009189);
            final MarvelCharacter marvelCharacter = character.getData().getResults().get(0);
            path = marvelCharacter.getThumbnail().getPath() + "." + marvelCharacter.getThumbnail().getExtension();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok(index.render(path));
    }

}
