package controllers;

import com.github.codingricky.marvel.RestClient;
import com.github.codingricky.marvel.model.MarvelCharacter;
import org.apache.commons.lang3.RandomUtils;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static Result index() {
        RestClient restClient = new RestClient(Keys.PRIVATE_KEY, Keys.PUBLIC_KEY);
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final Card card = new Card(getCharacter(restClient));
            if (card.isImageAvailable()) {
                cards.add(card);
            }

            if (cards.size() == 10) {
                return ok(index.render(cards));
            }
        }
        return ok(index.render(cards));
    }

    private static MarvelCharacter getCharacter(RestClient restClient) {
        try {
            final com.github.codingricky.marvel.model.Result<MarvelCharacter> character = restClient.getCharacter(RandomUtils.nextInt(1009100, 1010000));
            return character.getData().getResults().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
