package Alexis.MicroServices.MemoryCards.model;

import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import Alexis.MicroServices.MemoryCards.dataObjects.Deck;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DeckServicesImpl implements DeckServices {
    @Autowired
    private DeckRepository dao;

    @Override
    public List<Deck> findAllDecks() {
        return this.dao.findAll();
    }

    @Override
    public Optional<Deck> findDeckByName(String name) {
        return this.dao.findDeckByName(name);
    }

    @Override
    public ObjectId findDeckIdByName(String deckName) throws Exception {
       try {
        return this.dao.findDeckIdByName(deckName);
       } catch (Exception e){

           System.out.println(e.getMessage());
            throw e;
       }
    }

    @Override
    public Deck createNewDeck(Deck deck) {
        return this.dao.insert(deck);
    }


    @Override
    public List<Optional<Card>> findAllCardsFromDeck(String deckName){
        return null; //this.dao.findAllCardFromDeck(deckName);
    }

    @Override
    public List<Optional<Card>> findNewCardsFromDeck(String deckName){
        return null; //this.dao.findNewCardsFromDeck(deckName);
    }


    @Override
    public Deck updateDeck(Deck deck) {

        try {
            return this.dao.save(deck);
        } catch (Exception e){

            System.out.println(e.getMessage());
            throw e;
        }
    }


}
