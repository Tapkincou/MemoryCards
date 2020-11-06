package Alexis.MicroServices.MemoryCards.business;


import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import Alexis.MicroServices.MemoryCards.dataObjects.Deck;

import java.util.List;
import java.util.Optional;

//@Component
public interface DeckBusinessInterface {
   public List<Deck> findAllDecks() throws Exception;

   public Optional<Deck> getDeckByName(String deckName)  throws Exception;

   public List<Optional<Card>> getBarelyKnownCardsInDeck(String deckName) throws Exception;

   public List<Optional<Card>> getAlmostKnownCardsInDeck(String deckName) throws Exception;

   public List<Optional<Card>> getNotKnownCardsInDeck(String deckName) throws Exception;
   //TODO List<Card>
   public List<Optional<Card>> getCardsFromDeck(String deckName) throws Exception;

   public Deck insertNewDeck(String deckName)  throws Exception;

   public Deck insertNewDeck(Deck deck)  throws Exception;

   public Card insertNewCard(Card card) throws Exception;

   public Deck updateDeck(Deck deck) throws Exception;

   public Card  updateCard(Card card) throws Exception;;
}
