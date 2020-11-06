package Alexis.MicroServices.MemoryCards.dataObjects;

import Alexis.MicroServices.MemoryCards.utils.LearningLevel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Card {
    @MongoId
    ObjectId id;

    @Field
    ObjectId deck_id;

    @Field
    String recto;
    @Field
    String verso;
    @Field
    LearningLevel learningLevel;

    //TODO : date de crea & de modif

    public Card() {
    }

    public Card(ObjectId deckId, String recto, String verso) {
        this.deck_id = deckId;
        this.recto = recto;
        this.verso = verso;
        this.learningLevel = LearningLevel.NEW_WORD;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRecto() {
        return recto;
    }

    public void setRecto(String recto) {
        this.recto = recto;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }

    public LearningLevel getLearningLevel() {
        return learningLevel;
    }

    public void setLearningLevel(LearningLevel learningLevel) {
        this.learningLevel = learningLevel;
    }

    public ObjectId getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(ObjectId deck_id) {
        this.deck_id = deck_id;
    }

    /**
     * Set learningLevel to NEW_WORD.
     * @return learningLevel of card now set to NEW_WORD.
     */
    public Card markAsNew(){
        this.learningLevel = LearningLevel.NEW_WORD;
        return this;
    }

    @Override
    public String toString() {
        return "Card:" + id + "--deck_id:" + this.deck_id + " recto:" + this.recto;
    }
}
