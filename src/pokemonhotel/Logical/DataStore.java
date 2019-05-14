/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

// All the imports required so this
// class can function as intended.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Stephen Gregan
 */
public class DataStore
{ 

    // Declare an ArrayList of type String called
    // [names] that will hold all the name contents.
    private final ArrayList<String> names;
    // Declare an ArrayList of type String called
    // [landTypes] that will hold all the Pokemon
    // that are of type [Land].
    private final ArrayList<String> landTypes;
    // Declare an ArrayList of type String called
    // [waterTypes] that will hold all the Pokemon
    // that are of type [Water].
    private final ArrayList<String> waterTypes;
    // Declare an ArrayList of type String called
    // [airTypes] that will hold all the Pokemon
    // that are of type [Air].
    private final ArrayList<String> airTypes;

    /**
     * This Constructor sets up the method (ReadFromFile) that takes in the
     * NamesFilePath.
     *
     * Initializes various ArrayList's including: landTypes waterTypes airTypes
     *
     *
     * @param NamesFilePath The specified path of any given file passed in to
     * this Constructor.
     */
    public DataStore(String NamesFilePath)
    {
        // Read all the names from the text file
        // supplied with the required specifications
        // [pokemon.txt] and store them in the 
        // ArrayList<String> names;
        this.names = ReadFromFile(NamesFilePath);
        // Initialize the ArrayList 
        // [landTypes].
        landTypes = new ArrayList<>();
        // Initialize the ArrayList 
        // [waterTypes].
        waterTypes = new ArrayList<>();
        // Initialize the ArrayList 
        // [airTypes].
        airTypes = new ArrayList<>();
        // Populate the landTypes
        // [ArrayList] with all
        // the required types
        // for [Land Type] Pokemon.
        landTypes.add("Normal");
        landTypes.add("Grass");
        landTypes.add("Fighting");
        landTypes.add("Poison");
        landTypes.add("Ground");
        landTypes.add("Rock");
        landTypes.add("Steel");
        // Populate the waterTypes
        // [ArrayList] with all
        // the required types
        // for [Water Type] Pokemon.
        waterTypes.add("Water");
        waterTypes.add("Ice");
        waterTypes.add("Dark");
        // Populate the airTypes
        // [ArrayList] with all
        // the required types
        // for [Air Type] Pokemon.
        airTypes.add("Fire");
        airTypes.add("Electric");
        airTypes.add("Flying");
        airTypes.add("Psychic");
        airTypes.add("Bug");
        airTypes.add("Ghost");
        airTypes.add("Dragon");
        airTypes.add("Fairy");
    }
    
    private ArrayList<String> ReadFromFile(String filePath)
    {
        // Declare and initialize an ArrayList of type
        // String called [filled].
        ArrayList<String> filled = new ArrayList<>();
        // Declare and initialize a new File called [file]
        // that takes in a file path as an argument.
        File file = new File(filePath);
        // Set up a try/catch block.  Within
        // the try parenthesese declare and 
        // initialize a new Scanner called
        // scan that takes in a [file] as an
        // argument.
        try (Scanner scan = new Scanner(file))
        {
            while (scan.hasNextLine())
            {
                filled.add(scan.nextLine());
            }
        } // Enable to catch if developer
        // enters a file that either
        // does not exist or specifies an
        // incorrect file name.
        catch (FileNotFoundException e)
        {
            // Print out the String "No such file" to
            // make the developer aware of their
            // mistake.
            System.out.println("No such File   " + e);
        }
        // Return the
        // Arraylist
        // [filled] of
        // type String.
        return filled;
    } 

    /**
     * This method returns all Pokemon names that are read in from text file
     * (pokemon.txt).
     *
     * @return All the Pokemon Names.
     */
    public ArrayList<String> getNames()
    { 
        return names;
    } 

    /**
     * This method returns all Pokemon that have a specified type of Land.
     *
     * @return All the types of Pokemon of type Land.
     */
    public ArrayList<String> getLandTypes()
    { 
        return landTypes;
    } 

    /**
     * This method returns all Pokemon that have a specified type of Water.
     *
     * @return waterTypes
     */
    public ArrayList<String> getWaterTypes()
    { 
        return waterTypes;
    } 

    /**
     * This method returns all Pokemon that have a specified type of Air.
     *
     * @return airTypes
     */
    public ArrayList<String> getAirTypes()
    { 
        return airTypes;
    } 

    
} 

