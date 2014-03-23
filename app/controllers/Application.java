package controllers;

import com.github.codingricky.marvel.RestClient;
import com.github.codingricky.marvel.model.*;
import org.apache.commons.lang3.RandomUtils;
import play.mvc.*;

import play.mvc.Result;
import views.html.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        RestClient restClient = new RestClient(Keys.PRIVATE_KEY, Keys.PUBLIC_KEY);
        List<Card> cards = new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                final com.github.codingricky.marvel.model.Result<MarvelCharacter> character = restClient.getCharacter(RandomUtils.nextInt(1009100, 1010000));
                final MarvelCharacter marvelCharacter = character.getData().getResults().get(0);
                cards.add(new Card(marvelCharacter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok(index.render(cards));
    }

}
