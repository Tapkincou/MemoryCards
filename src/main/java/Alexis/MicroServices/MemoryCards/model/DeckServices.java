package Alexis.MicroServices.MemoryCards.model;

import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import Alexis.MicroServices.MemoryCards.dataObjects.Deck;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface DeckServices {

    public List<Deck> findAllDecks();

    public Optional<Deck> findDeckByName(String name);

    public ObjectId findDeckIdByName(String deckName) throws Exception;

    public Deck createNewDeck(Deck deck);

    public List<Optional<Card>> findAllCardsFromDeck(String deckName);// todo remove

    public List<Optional<Card>> findNewCardsFromDeck(String deckName);// todo remove

    /***
     * Update the given Deck object in database
     * @param deck
     * @return the updated Deck
     */
    public Deck updateDeck(Deck deck);
}
