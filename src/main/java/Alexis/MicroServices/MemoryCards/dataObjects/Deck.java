package Alexis.MicroServices.MemoryCards.dataObjects;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Deck {
    @MongoId
    private ObjectId id;
    @Field
    private String name;
   /* @Field
    private List<Card> cards;
*/
    public Deck() {
    }

    public Deck(ObjectId id, String name) { //, List<Card> cards
        this.id = id;
        this.name = name;
       // this.cards = cards;
    }

    // New empty deck
    public Deck(String name) {
        this.name = name;
    }

    public ObjectId getid() {
        return id;
    }

    public void setid(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
*/
    @Override
    public String toString() {
        return this.name;
    }

}
