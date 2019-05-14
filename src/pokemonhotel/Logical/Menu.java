/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel.Logical;

// The import required
// so this class can
// function as intended.
import java.util.Scanner;

/**
 *
 * @author Daniel Murphy
 */
public class Menu
{

    // Declare an instance of the class
    // [InformationDisplayer], set the name
    // to infoDisplayer.
    InformationDisplayer infoDisplayer;
    Scanner scan;
    int numberOfOptions;

    /**
     * Menu Constructor sets various fields including: Instance of
     * InformationDisplayer Scanner variable numberOfOptions.
     *
     * @param infoDisplayer
     */
    public Menu(InformationDisplayer infoDisplayer)
    {
        this.infoDisplayer = infoDisplayer;
        scan = new Scanner(System.in);
        numberOfOptions = 9;
    }

    /**
     * Prints to the screen all available user options
     */
    public void DisplayOptions()
    {
        System.out.println("\n****************************");
        System.out.println("\n**********************************");
        System.out.println("\n****************************************");
        System.out.println("----------------------------------------");
        System.out.printf((char) 27 + "[31;47m %-39s", "WELCOME TO POKEMON HOTEL ");
        System.out.println("\n----------------------------------------");
        System.out.printf((char) 27 + "[31;47m %-39s", "WE HOPE YOU ENJOY YOUR STAY ");
        System.out.println("\n----------------------------------------");
        System.out.printf((char) 27 + "[31;47m %-12s", "CREATED BY Daniel, Stephen and Abraham ");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 1: Output All Pokemon");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 2: Output Personal Assistants and Pokemon they have");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 3: Output Room Contents");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 4: Output Pokemon Information");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 5: Output Unassigned Pokemon");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 6: Output Assigned Pokemon");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 7: Output total number of Pokemon the hotel can accommodate");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 8: Output Unoccupied Rooms");
        System.out.println("\n--------------------------------------------------------------------");
        System.out.printf((char) 27 + "[34;47m %-67s", "Option 9: Output UnAssigned Personal Assistants");
        System.out.println("\n--------------------------------------------------------------------");
    }

    /**
     * Handles all user interaction within the program using Switch statement
     * and case statements.
     *
     * @param input
     */
    public void HandleInput(int input)
    {
        switch (input)
        {
            case 1:
            {
                infoDisplayer.OutputAllPokemon();
                break;
            }
            case 2:
            {
                infoDisplayer.OutputPersonalAssistantsAndAssignedPokemon();
                break;
            }
            case 3:
            {
                System.out.println("----------------------------------------------------------");
                System.out.print("\u001B[31m" + " Enter the room number of the room you would like to see: ");
                if (!scan.hasNextInt())
                {
                    scan.next();
                    System.out.println("\u001B[31m" + " Invalid input please try again ");
                } 
                else
                {
                    infoDisplayer.OutputRoomContent(scan.nextInt());
                }
                break;
            }
            case 4:
            {
                System.out.println("---------------------------------------------------------------");
                System.out.print("\u001B[31m" + " Enter the Genetic Stamp of the pokemon you would like to see: ");
                if (!scan.hasNextInt())
                {
                    scan.next();
                    System.out.println("\u001B[31m" + " Invalid input please try again ");
                } 
                else
                {
                    infoDisplayer.OutputPokemonInformation(scan.nextInt());
                }
                break;
            }
            case 5:
            {
                infoDisplayer.OutputUnAssignedPokemon();
                break;
            }
            case 6:
            {
                infoDisplayer.OuputAssignedPokemon();
                break;
            }
            case 7:
            {
                infoDisplayer.OutputTotalNumberOfPokemonHotelCanAccommodate();
                break;
            }
            case 8:
            {
                infoDisplayer.OutputUnoccupiedRooms();
                break;
            }
            case 9:
            {
                infoDisplayer.OutputUnassignedPersonalAssistants();
                break;
            }
            default:
            {
                System.out.println("\u001B[31m" + " Invalid input please try again ");
                break;
            }
        }
    }
}
