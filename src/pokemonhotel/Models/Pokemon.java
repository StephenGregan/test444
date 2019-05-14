/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

/**
 *
 * @author Stephen Gregan
 */
public class Pokemon
{

    // Declare a varaible 
    // of type [String], 
    // prefix this variable 
    // with the name [name]
    private String name;
    
    // Declare a variable 
    // of type[String], 
    // prefix this variable 
    // with the name [type]
    private String type;
    
    // Declare a variable of 
    // type [int], prefix this 
    // variable with the name 
    // [geneticStamp]
    private int geneticStamp;
    
    // Declare a variable of type
    // [int], prefix this variable 
    // with the name 
    // [specialAttackRating]
    private int specialAttackRating;
    
    // Declare a variable of 
    // type [int], prefix this 
    // variable with the name 
    // [speedRating]
    private int speedRating;
    
    // Declare a variable of 
    // type [int], prefix this 
    // variable with the name 
    // [expertLevel]
    private int expertLevel;

    /**
     *
     */
    public Pokemon()
    { // Start of the First [Pokemon] Constructor
    } // End of the First [Pokemon] Constructor

    /**
     *
     * @param name
     * @param type
     * @param geneticStamp
     * @param specialAttackRating
     * @param speedRating
     * @param expertLevel
     * @param roomNumber
     * @param resistanceRating
     */
    public Pokemon(String name, String type,
            int geneticStamp, int specialAttackRating,
            int speedRating, int expertLevel, int roomNumber,
            int resistanceRating)
    {
        // name [Pokemon] Class = name [Constructor]
        this.name = name;
        // type [Pokemon] Class = type [Constructor]
        this.type = type;
        // geneticStamp [Pokemon] Class = geneticStamp [Constructor]
        this.geneticStamp = geneticStamp;
        // specialAttackRating [Pokemon] Class = specialAttackRating [Constructor]
        this.specialAttackRating = specialAttackRating;
        // speedRating [Pokemon] Class = speedRating [Constructor]
        this.speedRating = speedRating;
        // expertLevel [Pokemon] Class = expertLevel [Constructor]
        this.expertLevel = expertLevel;
    }

    /**
     *
     * @return name
     */
    public String getName()
    {
        // return the variable [name]
        return name;
    }

    /**
     *
     * Set name [Pokemon] class = name [setName]
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *
     * @return type
     */
    public String getType()
    {
        // Return the variable [type]
        return type;
    }

    /**
     *
     * Set type [Pokemon] class = type [setType]
     *
     * @param type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     *
     * @return geneticStamp
     */
    public int getGeneticStamp()
    {
        // Return the variable [geneticStamp]
        return geneticStamp;
    }

    /**
     *
     * Set geneticStamp [Pokemon] class = geneticStamp [setGeneticStamp]
     *
     * @param genericStamp
     */
    public void setGeneticStamp(int genericStamp)
    {
        this.geneticStamp = genericStamp;
    }

    /**
     *
     * @return specialAttackRating
     */
    public int getSpecialAttackRating()
    {
        // Return the variable [specialAttackRating]
        return specialAttackRating;
    }

    /**
     *
     * Set specialAttackRating [Pokemon] class = specialAttackRating
     * [setSpecialAttackRating]
     *
     * @param specialAttackRating
     */
    public void setSpecialAttackRating(int specialAttackRating)
    {
        this.specialAttackRating = specialAttackRating;
    }

    /**
     *
     * @return speedRating
     */
    public int getSpeedRating()
    {
        // Return the variable [speedRating]
        return speedRating;
    }

    /**
     * Set speedRating [Pokemon] class = speedRating [setSpeedRating]
     *
     * @param speedRating
     */
    public void setSpeedRating(int speedRating)
    {
        this.speedRating = speedRating;
    }

    /**
     *
     * @return expertLevel
     */
    public int getExpertLevel()
    {
        // Return the variable [expertLevel]
        return expertLevel;
    }

    /**
     *
     * Set expertLevel [Pokemon] class = expertLevel [setExpertLevel]
     *
     * @param expertLevel
     */
    public void setExpertLevel(int expertLevel)
    {
        this.expertLevel = expertLevel;
    }

    @Override
    public String toString()
    {
        // Display the Pokemon will all attributes combined in a 
        // formatted String with a blue font colour on a grey background
        return String.format((char) 27 + "[4;34m POKEMON: Name: %-12s "
                + "Type: %-12s Genetic Stamp: %-12s Special Attack "
                + "Rating: %-12s Speed Rating: %-12s "
                + "Expert Level: %-4s", name, type,
                geneticStamp, specialAttackRating,
                speedRating, expertLevel);
    }
}
