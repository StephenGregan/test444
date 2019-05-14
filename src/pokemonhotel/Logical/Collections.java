/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

// All the imports required so this
// class can function as intended.
import java.util.ArrayList;
import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;

/**
 *
 * @author Daniel Murphy
 */
public class Collections
{

    // Declare an ArrayList of type [Pokemon] that will 
    // hold all the Pokemon that CAN stay in the hotel.
    private final ArrayList<Pokemon> assignedPokemon;

    // Declare an ArrayList of type [Pokemon] that will 
    // hold all the Pokemon that CANNOT stay in the hotel.
    private final ArrayList<Pokemon> unAssignedPokemon;

    // Declare an Array of type Pokemon that will hold
    // all the randomly generated Pokemon.
    private final Pokemon[] pokemon;

    // Declare an Array of type Pokemon that will hold 
    // all the randomly generated Rooms.
    private final Room[] rooms;

    // Declare an Array of type PersonalAssistant that 
    // will hold all the randomly generated Personal 
    // Assistants.
    private final PersonalAssistant[] personalAssistants;

    // Declare and initialize an int variable called 
    // [maxNumberOfRooms], set the value to [100].
    private final int maxNumberOfRooms = 100;

    // Declare and initialize an int variable called
    // [maxNumberOfPersonalAssistants], set the value
    // to [20].
    private final int maxNumberOfPersonalAssistants = 20;

    // Declare and initialize an int variable called
    // [maxNumberOfPokemon], set the value to [80].
    private final int maxNumberOfPokemon = 80;

    /**
     *
     */
    public Collections()
    {
        rooms                       = new Room[maxNumberOfRooms];
        personalAssistants          = new PersonalAssistant[maxNumberOfPersonalAssistants];
        pokemon                     = new Pokemon[maxNumberOfPokemon];
        this.assignedPokemon        = new ArrayList<>();
        this.unAssignedPokemon      = new ArrayList<>();
    }

    /**
     *
     * @return All the rooms created.
     */
    public Room[] getRooms()
    {
        return rooms;
    }

    /**
     *
     * @return All the Personal Assistants created.
     */
    public PersonalAssistant[] getPersonalAssistants()
    {
        return personalAssistants;
    }

    /**
     *
     * @return All the Pokemon created.
     */
    public Pokemon[] getPokemon()
    {
        return pokemon;
    }

    /**
     *
     * @return All the assigned Pokemon.
     */
    public ArrayList<Pokemon> getAssignedPokemon()
    {
        return assignedPokemon;
    }

    /**
     *
     * @return All the Unassigned Pokemon.
     */
    public ArrayList<Pokemon> getUnassignedPokemon()
    {
        return unAssignedPokemon;
    }
}
