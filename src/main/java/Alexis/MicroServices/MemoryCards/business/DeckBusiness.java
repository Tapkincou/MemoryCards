package Alexis.MicroServices.MemoryCards.business;

import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import Alexis.MicroServices.MemoryCards.dataObjects.Deck;
import Alexis.MicroServices.MemoryCards.model.CardServices;
import Alexis.MicroServices.MemoryCards.model.DeckServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DeckBusiness implements DeckBusinessInterface {

    @Autowired
    private DeckServices deckServicesImpl;

     @Autowired
    private CardServices cardServicesImpl;

    @Override
    public List<Deck> findAllDecks() throws Exception {
        try {
            System.out.println(this.deckServicesImpl.findAllDecks());
            return this.deckServicesImpl.findAllDecks();
        } catch (Exception e){
            // TODO in error handler find a way to make difference between tech and fonc exception and through it
            throw e;
        }

    }

    @Override
    public Optional<Deck> getDeckByName(String deckName) throws Exception {
        try {
            System.out.println(this.deckServicesImpl.findDeckByName(deckName));
            return this.deckServicesImpl.findDeckByName(deckName);
        } catch (Exception e){
            throw e;
        }
    }



    @Override
    public List<Optional<Card>> getBarelyKnownCardsInDeck(String deckName) throws Exception {
        try {
            return this.cardServicesImpl.findBarelyKnownCardsFromDeck(this.getDeckByName(deckName).get().getid());
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Optional<Card>> getAlmostKnownCardsInDeck(String deckName) throws Exception {

        try {
            return this.cardServicesImpl.findAlmostKnownCardsFromDeck(this.getDeckByName(deckName).get().getid());
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Optional<Card>> getNotKnownCardsInDeck(String deckName) throws Exception {
        try {
            return this.cardServicesImpl.findNotKnownCardsFromDeck(this.getDeckByName(deckName).get().getid());
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Optional<Card>> getCardsFromDeck(String deckName) throws Exception {

        try {
            // todo : clean pour récupérer juste l'ID depuis la requête (attention à pas récup un DOCUMENT{} qui contient que l'ID
            //return this.cardServicesImpl.findCardsByDeckId(this.getDeckIdByName(deckName)); // VRAI RQT
            return this.cardServicesImpl.findCardsByDeckId(this.getDeckByName(deckName).get().getid()); //this.getDeckIdByName(deckName)

        } catch (Exception e){
            throw e;
        }
    }

    private ObjectId getDeckIdByName(String deckName) throws Exception  {

        try {
            return this.deckServicesImpl.findDeckIdByName(deckName);
        } catch (Exception e){
            throw e;
        }

    }


    private Deck createDeck(Deck deck)  throws Exception{

        try {
            return this.deckServicesImpl.createNewDeck(deck);

        } catch (Exception e){
            throw e;
        }

    }

    @Override
    public Deck insertNewDeck(String deckName) throws Exception {
           return this.createDeck(new Deck(deckName));
    }

    // USELESS
    @Override
    public Deck insertNewDeck(Deck deck) throws Exception {
            return this.createDeck(deck);
    }

    @Override
    public Card insertNewCard(Card card) throws Exception {

        try {
            return this.cardServicesImpl.createNewCard(card.markAsNew());
        } catch (Exception e){
            throw e;
        }

    }

    @Override
    public Deck updateDeck(Deck deck) throws Exception {


        try {
            deck.setName("DECK_DE_TEST");
            return this.deckServicesImpl.updateDeck(this.bouchonCustomDeckUpdate(deck)); //deck this.bouchonCustomDeckUpdate(deck)

        } catch (Exception e){
            throw e;
        }

        
    }

    @Override
    public Card updateCard(Card card) throws Exception {
        try {

            return this.cardServicesImpl.updateCard(card); //deck this.bouchonCustomDeckUpdate(deck)

        } catch (Exception e){
            throw e;
        }

    }

    private Deck bouchonCustomDeckUpdate(Deck deck){

    /*    List<Card> listCards = new ArrayList<>();
        listCards.add(new Card("restotest1","versotest1"));
        listCards.add(new Card("restotest2","versotest2"));
        listCards.add(new Card("restotest2","versotest3"));
        deck.setCards(listCards);*/

        return deck;
    }


    // TODO /*
    //  For each cards check the last modification date and if
    //
    //  > decrease by 1 :
    //      If learning 1 &&  2 jours
    //      If learning 2 &&  3 jours
    //      If learning 3 &&  4 jours
    //      If learning 4 &&  6 jours
    //      If learning 5 &&  8 jours
    //      If learning 6 &&  10 jours
    //      If learning 7 &&  13 jours
    //      If learning 8 &&  16 jours
    //      If learning 9 &&  20 jours
    //      If learning 10 &&  25 jours
     //  */

}
