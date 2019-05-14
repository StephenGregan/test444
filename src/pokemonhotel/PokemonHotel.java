/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonhotel;

// All the imports required so this
// class can function as intended.
import pokemonhotel.Logical.Menu;
import pokemonhotel.Logical.InformationDisplayer;
import java.util.Scanner;
import pokemonhotel.Logical.Collections;
import pokemonhotel.Logical.SetUp;

/**
 *
 * @author Daniel Murphy
 */
public class PokemonHotel
{ 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    { 

        // Declare an initialize a new instance of the Scanner Class
        // Used to take user input [System.in].
        Scanner scan = new Scanner(System.in);
        // Declare and initialize a new instance of the class
        // [Collections].
        Collections collections = new Collections();
        // Declare and initialize a new instance of the
        // class [SetUp].
        SetUp setUp = new SetUp();
        // Declare and initialize a new instance of the class [InformationDisplayer].
        InformationDisplayer infoDisplayer = new InformationDisplayer(collections);
        // Declare and initialize a new instance of the class [Menu].
        Menu menu = new Menu(infoDisplayer);
        // Using the instance of the SetUp class
        // created above, call the Method [GenerateRooms]
        // that takes in the getRooms() [Getter/Accessor]
        // from the collections class.
        setUp.GenerateRooms(collections.getRooms());
        // Using the instance of the SetUp class created above, call the
        // Method [GeneratePersonalAssistants] that takes in the 
        // getPersonalAssistants [Getter/Accessor] from the collections class
        setUp.GeneratePersonalAssitants(collections.getPersonalAssistants());
        // Using the instance of the SetUp class created
        // above, call the Method [GeneratePokemon]
        // that takes in the getPokemon [Getter/Accessor] 
        // from the collections class
        setUp.GeneratePokemon(collections.getPokemon());
        setUp.AssignPokemon(collections);
        // Do execute the code contained in the {} [Curly Braces] while the
        // condition is true.
        do
        {
            // Use the instance of
            // the menu class to
            // call the Method
            // [DisplayOptions].
            menu.DisplayOptions();
            // Print out the String "Enter value: " with a font
            // colour of red and a background colour of grey.
            System.out.print("\u001B[31m" + " Enter value: ");
            // If the user input
            // has an int value...
            if (scan.hasNextInt())
            {
                // Execute this line of code.
                // Call the Method [HandleInput]
                // using the instance of the Menu
                // class.
                menu.HandleInput(scan.nextInt());
            } 
            else
            {
                scan.next();
                // Print out the String "Invalid input please try again" with a red
                // font and a grey background.
                System.out.println("\u001B[31m" + " Invalid input please try again ");
            }
            // Print out a new
            // line.
            System.out.println();
        } // While condition
        // Keep executing the code
        // in the do loop
        // while this condition is
        // true.
        while (true);
    }
}
