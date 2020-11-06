package Alexis.MicroServices.MemoryCards.model;

import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface CardServices {

   public List<Optional<Card>> findCardsByDeckId(ObjectId deckId);


   public List<Card> allCards();


    public List<Optional<Card>> findNotKnownCardsFromDeck(ObjectId deckId);

    public List<Optional<Card>> findBarelyKnownCardsFromDeck(ObjectId deckId);

    public List<Optional<Card>> findAlmostKnownCardsFromDeck(ObjectId deckId);

    public Card createNewCard(Card card);

    public Card updateCard(Card card);
}
