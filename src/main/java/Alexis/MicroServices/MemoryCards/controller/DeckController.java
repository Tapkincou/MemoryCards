package Alexis.MicroServices.MemoryCards.controller;

import Alexis.MicroServices.MemoryCards.business.DeckBusinessInterface;
import Alexis.MicroServices.MemoryCards.dataObjects.Card;
import Alexis.MicroServices.MemoryCards.dataObjects.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8100", maxAge = 3600)
@RestController
@RequestMapping("/decks")
public class DeckController {

    private DeckBusinessInterface deckBusiness;

    @Autowired
    public DeckController(DeckBusinessInterface deckBusiness) {
        this.deckBusiness = deckBusiness;
    }

        // GET all deck names
        @GetMapping("")
        public ResponseEntity getDecks() {

            try {
                //return ResponseEntity.ok(this.deckBusiness.insertNewDeck("testenlive"));
                return ResponseEntity.ok(this.deckBusiness.findAllDecks());
                // return new ResponseEntity<>(this.deckBusiness.getDeckByName(name), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // GET selected deck
        @GetMapping("/{deckName}")
        public ResponseEntity getDeckByName(@PathVariable String deckName) {

            try {
                return ResponseEntity.ok(this.deckBusiness.getDeckByName(deckName));
               // return new ResponseEntity<Deck>(t
                // his.deckBusiness.getDeckByName(name), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        // GET all cards from the selected deck
        @GetMapping("/{deckName}/cards")
        public ResponseEntity getCardsFromDeck(@PathVariable String deckName) {

            try {
                return new ResponseEntity<>(this.deckBusiness.getCardsFromDeck(deckName), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        // POST a new card into database
        @PostMapping("/{deckName}/cards/new")
        public ResponseEntity postNewCard(@RequestBody Card card) {

            try {
                return new ResponseEntity<>(this.deckBusiness.insertNewCard(card), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        @PutMapping (path = "/{deckName}/cards/update", consumes = "application/json", produces = "application/json")
        public ResponseEntity updateCard(@RequestBody Card card){

            try {
                return new ResponseEntity<>(this.deckBusiness.updateCard(card), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }


    // GET Cards from selected deck with learningValue >= 7
        @GetMapping("/{name}/barely-known")
        public ResponseEntity getBarelyKnownCardsInDeck(@PathVariable String name) {

            try {
                return new ResponseEntity<>(this.deckBusiness.getBarelyKnownCardsInDeck(name), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        // GET Cards from selected deck with learningValue >= 4 && < 7
        @GetMapping("/{name}/almost-known")
        public ResponseEntity getAlmostKnownCardsInDeck(@PathVariable String name) {

            try {
                return new ResponseEntity<>(this.deckBusiness.getAlmostKnownCardsInDeck(name), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        // GET Cards from selected deck with learningValue < 4
        @GetMapping("/{name}/not-known")
        public ResponseEntity getNotKnownCardsInDeck(@PathVariable String name) {

            try {
                return new ResponseEntity<>(this.deckBusiness.getNotKnownCardsInDeck(name), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }


        @PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
        public ResponseEntity createNewDeck(@RequestBody Deck deck){

            try {
                return new ResponseEntity<>(this.deckBusiness.insertNewDeck(deck), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        @PostMapping(path = "/new/empty", consumes = "application/json", produces = "application/json")
        public ResponseEntity createNewDeck(@RequestBody String deckName){

            try {
                return new ResponseEntity<>(this.deckBusiness.insertNewDeck(deckName), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

        @PutMapping (path = "/update", consumes = "application/json", produces = "application/json")
        public ResponseEntity updateDeck(@RequestBody Deck deck){

            try {
                return new ResponseEntity<>(this.deckBusiness.updateDeck(this.deckBusiness.getDeckByName("LENOMACHANGEEEEE").get()), HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }


    // TODO POST MAPPING
}


