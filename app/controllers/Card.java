package controllers;

import com.github.codingricky.marvel.model.Image;
import com.github.codingricky.marvel.model.MarvelCharacter;

public class Card {
    private final MarvelCharacter marvelCharacter;

    public Card(MarvelCharacter marvelCharacter) {
        this.marvelCharacter = marvelCharacter;
    }

    public String getImagePath() {
        final Image thumbnail = marvelCharacter.getThumbnail();
        return thumbnail.getPath() + "." + thumbnail.getExtension();
    }
}
