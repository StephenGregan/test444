/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Models;

/**
 *
 * @author Daniel Murphy
 */
public class Room
{

    // Declare a variable 
    // of type [Pokemon], 
    // prefix this variable 
    // with the name
    // [guest]
    private Pokemon guest;
    
    // Declare a variable 
    // of type [int] prefix 
    // this variable with 
    // the name [roomNumber]
    private int roomNumber;
    
    // Declare a variable of type
    // [int], prefix this variable
    // with the name 
    // [resistanceRating]
    private int resistanceRating;

    /**
     *
     */
    public Room()
    {
    }

    /**
     *
     * @param roomNumber
     * @param resistanceRating
     */
    public Room(int roomNumber, int resistanceRating)
    {
        this.roomNumber = roomNumber;
        this.resistanceRating = resistanceRating;
    }

    /**
     *
     * @param roomNumber
     * @param resistanceRating
     * @param guest
     */
    public Room(int roomNumber, int resistanceRating, Pokemon guest)
    {
        this.roomNumber = roomNumber;
        this.resistanceRating = resistanceRating;
        this.guest = guest;
    }

    /**
     *
     * @return roomNumber
     */
    public int getRoomNumber()
    {
        return roomNumber;
    }

    /**
     *
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    /**
     *
     * @return resistanceRating
     */
    public int getResistanceRating()
    {
        return resistanceRating;
    }

    /**
     *
     * @param ResistanceRating
     */
    public void setResistanceRating(int ResistanceRating)
    {
        this.resistanceRating = ResistanceRating;
    }

    /**
     *
     * @return guest
     */
    public Pokemon getGuest()
    {
        return guest;
    }

    /**
     *
     * @param Guest
     */
    public void setGuest(Pokemon Guest)
    {
        this.guest = Guest;
    }

    @Override
    public String toString()
    {
        return String.format((char) 27 + "[35;47m ROOM: "
                + "Room Number: %-12s Resistance Rating: %-12s "
                + "Guest: %-7s", roomNumber, resistanceRating, guest);
    }
}
