package Alexis.MicroServices.MemoryCards.model;


import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CardServiceImpl implements CardServices {

    @Autowired
    private CardRepository dao;

    @Override
    public List<Optional<Card>> findCardsByDeckId(ObjectId deckId) {
        return this.dao.findCardsByDeckId(deckId);
    }

    @Override
    public List<Card> allCards() {
        return this.dao.findAll();
    }

    @Override
    public List<Optional<Card>> findNotKnownCardsFromDeck(ObjectId deckId) {
        return this.dao.findNotKnownCardsByDeckId(deckId);
    }

    @Override
    public List<Optional<Card>> findBarelyKnownCardsFromDeck(ObjectId deckId) {
        return this.dao.findBarelyKnownByDeckId(deckId);
    }

    @Override
    public List<Optional<Card>> findAlmostKnownCardsFromDeck(ObjectId deckId) {
        return this.dao.findAlmostKnownCardsByDeckId(deckId);
    }

    @Override
    public Card createNewCard(Card card) {
        try {
            return this.dao.insert(card);
        } catch (Exception e){

            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public Card updateCard(Card card) {
        try {
            return this.dao.save(card);
        } catch (Exception e){

            System.out.println(e.getMessage());
            throw e;
        }
    }


}
