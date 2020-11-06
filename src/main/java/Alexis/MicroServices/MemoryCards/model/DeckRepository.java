package Alexis.MicroServices.MemoryCards.model;

import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import Alexis.MicroServices.MemoryCards.dataObjects.Deck;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeckRepository extends MongoRepository<Deck, ObjectId> {

   // public Deck findByName(String Name);
   @Query(value = "{ 'name': ?0 }")
    public Optional<Deck> findDeckByName(String name);


   //@Async
   @Query(value = "{ 'name': ?0 }", fields = "{_id: 1}")
    public ObjectId findDeckIdByName(String name);

/*
    @Query(value = "{ 'name': ?0 }", fields = "{cards : 1, _id: 0 }")
    public List<Optional<Card>> findAllCardFromDeck(String deckName);

    @Query(value = "{ 'name': ?0, 'cards': [ {'learningLevel' : 'NEW_WORD'} ] }", fields = "'cards'")
    public List<Optional<Card>> findNewCardsFromDeck(String deckName);
*/
}
