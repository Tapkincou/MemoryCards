package Alexis.MicroServices.MemoryCards.model;

import Alexis.MicroServices.MemoryCards.dataObjects.Card;

import Alexis.MicroServices.MemoryCards.utils.LearningLevel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends MongoRepository<Card, ObjectId> {

    @Query(value = "{ 'deck_id': ?0 }")
    public List<Optional<Card>> findCardsByDeckId(ObjectId deckId);

    @Query(value = "{ 'deck_id': ?0, $or: [ {  'learningLevel' :'NEW_WORD' },  {  'learningLevel' :'SEEN_ONCE' }, {  'learningLevel' :'SEEN_TWICE' } ], }")
    public List<Optional<Card>> findNotKnownCardsByDeckId(ObjectId deckId);

    @Query(value = "{ 'deck_id': ?0, $or: [ {  'learningLevel' :'CAN_YOU_REMEMBER_IT' },  {  'learningLevel' :'KEEP_GOING' }, {  'learningLevel' :'HALF_THE_JOB' } ], }")
    public List<Optional<Card>> findBarelyKnownByDeckId(ObjectId deckId);

    @Query(value = "{ 'deck_id': ?0, $or: [ {  'ALMOST_KNOWN' },  {  'learningLevel' :'ONE_LAST' }], }")
    public List<Optional<Card>> findAlmostKnownCardsByDeckId(ObjectId deckId);


    //TODO : cron de mise à jour pour descendre les learninglevel au palier en dessous
}