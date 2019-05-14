/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

// The import required so 
// this calss can function
// as intended.
import java.util.ArrayList;

/**
 *
 * @author Daniel Murphy
 */
public class PersonalAssistant
{ 

    // Declare an ArrayList of type Pokemon to hold the 
    // guests.
    private final ArrayList<Pokemon>                guests;
    // Declare an ArrayList of type String to hold the 
    // accepted Pokemon types.
    private final ArrayList<String>   pokemonTypesAccepted;
    // Declare a String variable to hold personal 
    // assistants names.
    private String name;
    // Declare an int variable to hold the personal 
    // assistants expert level.
    private int                                expertLevel;
    // Declare a final int variable to store the max number
    // of guests.
    private final int                    maxNumberOfGuests;

    /**
     *
     */
    public PersonalAssistant()
    { 
        this.pokemonTypesAccepted           = new ArrayList<>();
        this.guests                         = new ArrayList<>();
        this.maxNumberOfGuests              = 5;
    } 

    /**
     *
     * @param name
     * @param expertLevel
     */
    public PersonalAssistant(String name, int expertLevel)
    { 
        this.pokemonTypesAccepted           = new ArrayList<>();
        this.guests                         = new ArrayList<>();
        this.name                           = name;
        this.expertLevel                    = expertLevel;
        this.maxNumberOfGuests              = 5;
    } 

    // Accessor/Getter method to get
    // the max number of guests.
    /**
     *
     * @return
     */
    public int getMaxNumberOfGuests()
    { 
        // return the max number
        // of guests allowed.
        return maxNumberOfGuests;
    } 

    /**
     *
     * @return
     */
    public String getName()
    { 
        return name;
    } 

    /**
     *
     * @param name
     */
    public void setName(String name)
    { 
        this.name = name;
    } 

    /**
     *
     * @return
     */
    public int getExpertLevel()
    { 
        return expertLevel;
    } 

    /**
     *
     * @param expertLevel
     */
    public void setExpertLevel(int expertLevel)
    { 
        this.expertLevel = expertLevel;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getPokemonTypesAccepted()
    { 
        return pokemonTypesAccepted;
    } 

    /**
     *
     * @param pokemonType
     */
    public void setPokemonTypeAccepted(String pokemonType)
    { 
        this.pokemonTypesAccepted.add(pokemonType);
    } 

    /**
     *
     * @return
     */
    public ArrayList<Pokemon> getGuests()
    { 
        return guests;
    } 

    /**
     *
     * @param Guest
     */
    public void setGuest(Pokemon Guest)
    { 
        this.guests.add(Guest);
    } 

    @Override
    public String toString()
    { 
        return String.format((char) 27 + "[31;47m PERSONAL ASSISTANT: "
                + "Name: %-12s Expert Level: %-12s Pokemon"
                + " Type: %-12s Pokemon Type: %-49s", name,
                expertLevel, pokemonTypesAccepted.get(0),
                pokemonTypesAccepted.get(1));
    } 
} 
