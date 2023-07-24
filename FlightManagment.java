import java.util.Scanner;

public class FlightManagment{
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[][] availableFlights = {
            {"Germany", "Italy", "Greece"},
            {"Jamaica", "Dominican Republic", "Haiti"},
            {"Brazil", "Argentina", "Guyana"}
        };

        int[][] flightPrices = {
            {1000, 920, 721},
            {830, 589, 312},
            {603, 1256,578}
        };

        int eWallet = 1500000;
        String bookedFlights = "";

        System.out.println("Welcome to NFlights: A flight booking and managment system"  + "            __|__" +
                                                     "\n" + "\t\t\t\t\t\t\t       --o--o--(_)--o--o--");
        System.out.println("\nHere are the available flights: ");
        printFlights(availableFlights);

        System.out.println("\nIf you would like to book a flight type 'book'. ");
        System.out.println("If you would like to manage your current funds or view your tickets using our E-Wallet, type 'manage'.");
        System.out.println("If you would like to exit our booking system, type 'exit' ");
        
        Boolean loop = true;
        while (loop) {

            String usersChoice = scan.nextLine();

            switch (usersChoice) {
                case "book": System.out.println("Great, where would you like to go?");
                             String bookResponse = scan.nextLine();
                             

                             for (int i = 0; i < availableFlights.length; i++) {

                                for (int j = 0; j < availableFlights[i].length; j++) {
                                    
                                    if (bookResponse.equals(availableFlights[i][j]))
                                    {
                                        System.out.println("The cost of a flight to " + availableFlights[i][j] + " is $" + flightPrices[i][j]);
                                        System.out.println("There is currently $"+ eWallet + " in your E-Wallet");
                                        System.out.println("\nWould you like to 'buy' or 'cancel'?");
                                        String response = scan.next();

                                        if (response.equals("buy") && bookedFlights.contains(bookResponse))
                                        {
                                            System.out.println("You own this flight already!");
                                            break;
                                        }

                                        if (response.equals("buy") && flightPrices[i][j] <= eWallet && !(bookResponse.equals(bookedFlights)))
                                        {
                                            System.out.println("\nCongrats, you bought a ticket to " + availableFlights[i][j]);

                                            bookedFlights += bookResponse + " ";
                                            eWallet -= flightPrices[i][j];
                                            break;

                                        } else if (response.equals("buy") && flightPrices[i][j] > eWallet)
                                        {
                                            System.out.println("You do not have enough money to buy this ticket.");
                                            System.out.println("Goodbye :(");
                                            System.exit(0);
                                            
                                        }else if (response.equals("cancel"))
                                        {
                                            break;

                                        }else
                                        {
                                            System.out.println("INVALID... Goodbye :(");
                                            System.exit(0);
                                        }
                                    }
                                }
                             }

                             System.out.println("\nIf you would like to book a flight type 'book'. ");
                             System.out.println("If you would like to manage your current funds or view your tickets using our E-Wallet, type 'manage'.");
                             System.out.println("If you would like to exit our booking system, type 'exit' ");
                             usersChoice = scan.nextLine();

                break;

                case "manage": 
                                System.out.println("\n--------------------------");
                                System.out.println("E-WALLET; $" + eWallet);
                                System.out.println("\n--------------------------");
                                System.out.println("\n");

                                System.out.println("\n--------------------------");
                                System.out.println("Flights Booked: " + "\n" + bookedFlights);
                                System.out.println("\n--------------------------");
                                   
                                
                                System.out.println("\nIf you would like to book a flight type 'book'. ");
                                System.out.println("If you would like to manage your current funds or view your tickets using our E-Wallet, type 'manage'.");
                                System.out.println("If you would like to exit our booking system, type 'exit' ");
                                // usersChoice = scan.nextLine();

                break;

                case "exit": System.out.println("Goodbye :(");
                System.exit(0);
                break;

                default: System.out.println("INVALID... Goodbye :(");
                System.exit(0);
                    
            }
        }

        scan.close();
    }

    //Method that prints flights 
    public static void printFlights (String[][] availableFlights)
    {
        for (int i = 0; i < availableFlights.length; i++)
        {
            System.out.println("\n-------------------------------");
        
            for (int j = 0; j < availableFlights[i].length; j++)
            {
                
                System.out.print(availableFlights[i][j] + " ");
                
            }
    
            System.out.println("\n-------------------------------");
            System.out.println("\n");
        }
    }
}