package controllers;

import com.github.codingricky.marvel.RestClient;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.parameter.CharacterParameterBuilder;
import org.apache.commons.lang3.RandomUtils;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    private static final int ATTEMPTS = 100;
    private static final int MAX_CARDS = 10;

    public static Result index() {
        RestClient restClient = new RestClient(Keys.PRIVATE_KEY, Keys.PUBLIC_KEY);
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < ATTEMPTS; i++) {
            final Card card = new Card(getCharacter(restClient));
            if (card.isImageAvailable()) {
                cards.add(card);
            }

            if (cards.size() == MAX_CARDS) {
                return ok(index.render(cards));
            }
        }
        return ok(index.render(cards));
    }

    private static MarvelCharacter getCharacter(RestClient restClient) {
        try {
            final int offSet = RandomUtils.nextInt(0, 1400);
            final com.github.codingricky.marvel.model.Result<MarvelCharacter> character =
                    restClient.getCharacters(new CharacterParameterBuilder().withOffset(offSet).withLimit(1).create());
            return character.getData().getResults().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
