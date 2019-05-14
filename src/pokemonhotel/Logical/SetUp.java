/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

//  All the imports required so this
//  class can function as intended.
import java.util.Random;
import pokemonhotel.Models.AirPokemon;
import pokemonhotel.Models.LandPokemon;
import pokemonhotel.Models.PersonalAssistant;
import pokemonhotel.Models.Pokemon;
import pokemonhotel.Models.Room;
import pokemonhotel.Models.WaterPokemon;

/**
 *
 * @author Daniel Murphy
 */
public class SetUp
{ 
    
    private final DataStore dataStore;
    private final Random ranGen;

    /**
     *
     */
    public SetUp()
    {
        ranGen      = new Random();
        dataStore   = new DataStore("pokemon.txt");
    }

    /**
     * Generates all room in Pokemon Hotel.
     *
     * @param rooms
     */
    public void GenerateRooms(Room[] rooms)
    { 
        int maxResistenceRating = 7;
        int minResistenceRating = 3;
        for (int i = 0; i < rooms.length; i++)
        { 
            rooms[i] = new Room(i + 1, minResistenceRating + ranGen.nextInt(maxResistenceRating - minResistenceRating + 1));
        } 
    } 

    /**
     * Generates all Personal Assistants in Pokemon Hotel.
     *
     * @param personalAssistants
     */
    public void GeneratePersonalAssitants(PersonalAssistant[] personalAssistants)
    { 
        int maxExpertValue = 6;
        int minExpertValue = 1;
        int numberOfTypesAccepted = 2;
        for (int i = 0; i < personalAssistants.length; i++)
        { 
            PersonalAssistant personalAssistant = new PersonalAssistant();
            personalAssistant.setExpertLevel(ranGen.nextInt(maxExpertValue - minExpertValue + 1) + minExpertValue);
            personalAssistant.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
            String randomType;
            for (int j = 0; j < numberOfTypesAccepted; j++)
            { 
                //Performs do loop until a type is choosen which does not match any other type assigned to the personalAssistant
                do
                { 
                    randomType = GetRandomType();
                } 
                while (personalAssistant.getPokemonTypesAccepted().contains(randomType) == true);
                personalAssistant.setPokemonTypeAccepted(randomType);
            } 
            personalAssistants[i] = personalAssistant;
        } 
    } 

    /**
     * Generates all Pokemon in Pokemon Hotel.
     *
     * @param pokemon
     */
    public void GeneratePokemon(Pokemon[] pokemon)
    { 
        for (int i = 0; i < pokemon.length; i++)
        { 
            switch (ranGen.nextInt(3))
            { 
                case 0:
                { 
                    LandPokemon landPokemon = new LandPokemon();
                    landPokemon.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
                    landPokemon.setExpertLevel(ranGen.nextInt(10 - 1) + 1);
                    landPokemon.setGeneticStamp(i + 1);
                    landPokemon.setSpecialAttackRating(ranGen.nextInt(15 - 5) + 5);
                    landPokemon.setSpeedRating(ranGen.nextInt(15 - 5) + 5);
                    landPokemon.setType(dataStore.getLandTypes().get(ranGen.nextInt(dataStore.getLandTypes().size())));
                    pokemon[i] = landPokemon;
                    break;
                } 
                case 1:
                { 
                    AirPokemon airPokemon = new AirPokemon();
                    airPokemon.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
                    airPokemon.setExpertLevel(ranGen.nextInt(10 - 1) + 1);
                    airPokemon.setGeneticStamp(i + 1);
                    airPokemon.setSpecialAttackRating(ranGen.nextInt(15 - 5) + 5);
                    airPokemon.setSpeedRating(ranGen.nextInt(15 - 5) + 5);
                    airPokemon.setType(dataStore.getAirTypes().get(ranGen.nextInt(dataStore.getAirTypes().size())));
                    pokemon[i] = airPokemon;
                    break;
                } 
                case 2:
                { 
                    WaterPokemon waterPokemon = new WaterPokemon();
                    waterPokemon.setName(dataStore.getNames().get(ranGen.nextInt(dataStore.getNames().size())));
                    waterPokemon.setExpertLevel(ranGen.nextInt(10 - 1) + 1);
                    waterPokemon.setGeneticStamp(i + 1);
                    waterPokemon.setSpecialAttackRating(ranGen.nextInt(15 - 5) + 5);
                    waterPokemon.setSpeedRating(ranGen.nextInt(15 - 5) + 5);
                    waterPokemon.setType(dataStore.getWaterTypes().get(ranGen.nextInt(dataStore.getWaterTypes().size())));
                    pokemon[i] = waterPokemon;
                    break;
                } 
                default:
                { 
                    System.out.println("Something went wrong, default case statement in switch invoked...");
                    break;
                } 
            } 
        }
    } 

    /**
     * Assigns Pokemon to Personal Assistants and Rooms.
     *
     * @param collections
     */
    public void AssignPokemon(Collections collections)
    { 
        Pokemon[] pokemon                       = collections.getPokemon();
        Room[] rooms                            = collections.getRooms();
        PersonalAssistant[] personalAssistants  = collections.getPersonalAssistants();
        //Sort Pokemon
        for (int i = 0; i < pokemon.length; i++)
        { 
            for (int j = 1; j < (pokemon.length - i); j++)
            { 
                if (pokemon[j - 1].getExpertLevel() < pokemon[j].getExpertLevel())
                { 
                    Pokemon temp    = pokemon[j - 1];
                    pokemon[j - 1]  = pokemon[j];
                    pokemon[j]      = temp;
                } 
            } 
        } 
        Boolean isAssigned;
        //take each Pokemon
        for (Pokemon poke : pokemon)
        { 
            isAssigned = false;
            Room currRoom = new Room();
            //Assign to room
            for (Room room : rooms)
            { 
                //sucess
                if (room.getGuest() == null && room.getResistanceRating() >= CalcPokemonRating(poke))
                { 
                    //maintain reference to room found
                    currRoom    = room;
                    isAssigned  = true;
                    break;
                } 
            } 
            
            if (isAssigned == true)
            { 
                isAssigned = false;
                // attempt to assign Pokemon to Personal Assistant
                for (PersonalAssistant personalAssistant : personalAssistants)
                { 
                    if (personalAssistant.getPokemonTypesAccepted().contains(poke.getType())
                            && personalAssistant.getExpertLevel() >= poke.getExpertLevel()
                            && personalAssistant.getGuests().size() < personalAssistant.getMaxNumberOfGuests())
                    { 
                        personalAssistant.setGuest(poke);
                        isAssigned = true;
                        break;
                    } 
                } 
                
                if (isAssigned == true)
                { 
                    //assign the pokemon to room
                    currRoom.setGuest(poke);
                    collections.getAssignedPokemon().add(poke);
                } 
                //Failure to assign personal assistant
                else
                { 
                    collections.getUnassignedPokemon().add(poke);
                } 
            } 
            //Failed to assign pokemon to room
            else
            { 
                collections.getUnassignedPokemon().add(poke);
            } 
        } 
    } 

    private String GetRandomType()
    { 
        switch (ranGen.nextInt(3))
        { 
            case 0:
            { 
                return dataStore.getAirTypes().get(ranGen.nextInt(dataStore.getAirTypes().size()));
            } 

            case 1:
            { 
                return dataStore.getWaterTypes().get(ranGen.nextInt(dataStore.getWaterTypes().size()));
            } 
            case 2:
            { 
                return dataStore.getLandTypes().get(ranGen.nextInt(dataStore.getLandTypes().size()));
            } 
        } 
        return "Error";
    } 

    /**
     * Performs validation calculation on Pokemon.
     *
     * @param poke
     */
    private int CalcPokemonRating(Pokemon poke)
    { 
        return (poke.getSpecialAttackRating() + poke.getSpeedRating()) / 3;
    } 
} 
