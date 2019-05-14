/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

// All the imports required so this
// class can function as intended.
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
public class InformationDisplayer
{

    Collections collections;

    /**
     *
     * @param collections
     */
    public InformationDisplayer(Collections collections)
    {
        this.collections = collections;
    }

    /**
     * Outputs to the screen a list of all Pokemon seeking rooms
     */
    public void OutputAllPokemon()
    {
        for (Pokemon pokemon : collections.getPokemon())
        {
            System.out.println("------------------------------------------------------------------------------"
                    + "-------------------------------------------------------------------------------");
            System.out.println(pokemon.toString());
        }

    }

    /**
     * Outputs to the screen all personal assistants , the Pokemon they are
     * taking care of , the category of these Pokemon and the pokemons room
     * number
     */
    public void OutputPersonalAssistantsAndAssignedPokemon()
    {
        //iterates through all personal assistants
        for (PersonalAssistant personalAssistant : collections.getPersonalAssistants())
        {
            System.out.println("-----------------------------------------------------------------------------"
                    + "--------------------------------------------------------------------------------");
            System.out.println(personalAssistant.toString());
            System.out.println(String.format((char) 27 + "[36;47m %-156s", "GUEST(S)"));
            //if personal assistants guests is not empty
            if (personalAssistant.getGuests().size() > 0)
            {
                //iterate through the personal assistants guests
                for (int j = 0; j < personalAssistant.getGuests().size(); j++)
                {
                    System.out.println(personalAssistant.getGuests().get(j));
                    //Find Category of Pokemon
                    if (personalAssistant.getGuests().get(j).getClass() == LandPokemon.class)
                    {
                        System.out.print(String.format((char) 27 + "[33;35m %-156s", "Pokemon is part of the Land category "));
                    } 
                    else if (personalAssistant.getGuests().get(j).getClass() == AirPokemon.class)
                    {
                        System.out.print(String.format((char) 27 + "[33;35m %-156s", "Pokemon is part of the Air category "));
                    } 
                    else if (personalAssistant.getGuests().get(j).getClass() == WaterPokemon.class)
                    {
                        System.out.print(String.format((char) 27 + "[33;35m %-156s", "Pokemon is part of the Water category "));
                    }
                    //Find Pokemon Room by iterateing through rooms
                    for (Room room : collections.getRooms())
                    {
                        if (room.getGuest() == personalAssistant.getGuests().get(j))
                        {
                            System.out.println();
                            System.out.println(String.format((char) 27 + "[32;47m Guest Room Number: %-137s", room.getRoomNumber()));
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    /**
     * Output room content using the associated room number identifier.
     *
     * @param roomNumber
     */
    public void OutputRoomContent(int roomNumber)
    {
        //check validity of roomNumber
        if (roomNumber > 0 && roomNumber <= collections.getRooms().length)
        {
            System.out.println("----------------------------------------------------------");
            //iterate through rooms to find the room with given roomNumber
            for (Room room : collections.getRooms())
            {
                if (roomNumber == room.getRoomNumber())
                {
                    System.out.println(room.toString());
                    if (room.getGuest() != null)
                    {
                        //iterate through personal assistants to search through guests
                        for (PersonalAssistant pa : collections.getPersonalAssistants())
                        {
                            //iterate over guests to find guest within the current room
                            for (Pokemon poke : pa.getGuests())
                            {
                                if (poke == room.getGuest())
                                {
                                    //printing personal assistant of guest
                                    System.out.print(String.format((char) 27 + "[34;47m The Personal Assistant of %-33s", room.getGuest().getName() + " is:" + pa.toString() + (char) 27 + "[0m"));
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        } 
        else
        {
            System.out.println("\u001B[31m" + " Invalid input please try again ");
        }
    }

    /**
     * Output all Pokemon Information using the unique identifier Genetic Stamp.
     *
     * @param geneticStamp
     */
    public void OutputPokemonInformation(int geneticStamp)
    {
        //Check validity of genetic stamp
        if (geneticStamp > 0 && geneticStamp <= collections.getPokemon().length)
        {
            //used to track if room and personal assistant is found
            Boolean isFound;
            //iterate through pokemon 
            for (Pokemon pokemon : collections.getPokemon())
            {
                //check if current pokemon has required genetic stamp
                if (geneticStamp == pokemon.getGeneticStamp())
                {
                    System.out.println(pokemon.toString());
                    isFound = false;
                    //iterate through personal assistant
                    for (PersonalAssistant pa : collections.getPersonalAssistants())
                    {
                        //iterate through personal assistant guesst to try and find pokemon
                        for (Pokemon guest : pa.getGuests())
                        {
                            if (guest == pokemon)
                            {
                                System.out.println(pa.toString());
                                isFound = true;
                                break;
                            }
                        }
                        //Personal Assistant is found end for loop
                        if (isFound == true)
                        {
                            break;
                        }
                    }

                    if (isFound == false)
                    {
                        System.out.printf((char) 27 + "[31;47m %-156s", "This Pokemon has no Personal Assistant");
                        System.out.println();
                    }

                    //Search for room only if personal assistant found
                    if (isFound == true)
                    {

                        isFound = false;
                        for (Room room : collections.getRooms())
                        {
                            if (room.getGuest() == pokemon)
                            {
                                System.out.println(room.toString());
                                isFound = true;
                                break;
                            }
                        }
                    }

                    //print statement if room was not found
                    if (isFound == false)
                    {
                        System.out.printf((char) 27 + "[31;47m %-156s", "This Pokemon has no Room");
                    }
                }
            }
        } 
        else //invalid input
        {
            System.out.println("\u001B[31m" + " Invalid input please try again ");
        }
    } 

    /**
     * Output total number of Pokemon which the hotel can accommodate
     */
    public void OutputTotalNumberOfPokemonHotelCanAccommodate()
    {
        System.out.println("\u001B[31m" + " Total number of Pokemon the hotel can accommodate: " + collections.getAssignedPokemon().size());
    }

    /**
     * Output all Pokemon who have been assigned a Room and PersonalAssistant
     */
    public void OuputAssignedPokemon()
    {
        collections.getAssignedPokemon().forEach((poke) ->
        {
            System.out.println("------------------------------------------------------------------------------"
                    + "-------------------------------------------------------------------------------");
            System.out.println(poke.toString());
        });
    }

    /**
     * Output all Pokemon who have not been assigned a Room and Personal
     * Assistant
     */
    public void OutputUnAssignedPokemon()
    {
        collections.getUnassignedPokemon().forEach((poke) ->
        {
            System.out.println("------------------------------------------------------------------------------"
                    + "-------------------------------------------------------------------------------");
            System.out.println(poke.toString());
        });
    }

    /**
     * Output all Rooms which Unoccupied
     */
    public void OutputUnoccupiedRooms()
    {
        for (Room room : collections.getRooms())
        {
            if (room.getGuest() == null)
            {
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println(room.toString());
            }

        }
    }

    /**
     * Output all Personal Assistants who have no Pokemon assigned
     */
    public void OutputUnassignedPersonalAssistants()
    {
        for (PersonalAssistant pa : collections.getPersonalAssistants())
        {
            if (pa.getGuests().isEmpty())
            {
                System.out.println("------------------------------------------------------------------------------"
                        + "-------------------------------------------------------------------------------");
                System.out.println(pa.toString());
            }
        }
    }
}
