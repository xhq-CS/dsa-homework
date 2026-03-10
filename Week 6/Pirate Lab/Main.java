import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    static class Pirate {
        String name;
        String role;
        int bounty;

        public Pirate(String name, String role, int bounty) {
            this.name = name;
            this.role = role;
            this.bounty = bounty;
        }
    }


    public static void main(String[] args) {

        // 1. Create a list of pirates with their names, roles, and bounties
        List<Pirate> crew = new ArrayList<>(
                List.of(
                        new Pirate("Luffy", "Captain", 150),
                        new Pirate("Zoro", "Swordsman", 120),
                        new Pirate("Nami", "Navigator", 80),
                        new Pirate("Usopp", "Sniper", 50),
                        new Pirate("Sanji", "Cook", 90),
                        new Pirate("Chopper", "Doctor", 70),
                        new Pirate("Robin", "Archaeologist", 110),
                        new Pirate("Franky", "Shipwright", 100),
                        new Pirate("Brook", "Musician", 60),
                        new Pirate("Steven", "Apprentice", 10)
                )
        );

        // 2. Use a stream to filter out pirates with a bounty of 100 or more
        // whats a stream? its a way to process collections of data in a functional style
        // what is Predicate? its a functional interface that represents a boolean-valued function of one argument, used for filtering data in streams
        Predicate<Pirate> highBounty = pirate -> pirate.bounty >= 100;
        Predicate<Pirate> lowBounty = pirate -> pirate.bounty < 100;
        // a few things happening here:
        // 1. We declare a variable highBounty of type Predicate<Pirate>,
        // 2. We assign it a lambda expression pirate -> pirate.bounty >= 100, which takes a Pirate object as input and returns true if the pirate's bounty is 100 or more, and false otherwise.
        // 3. We can use this Predicate to filter our list of pirates in a stream operation.

        List<Pirate> bigShots = crew.stream().filter(highBounty).toList();
        List<Pirate> smallFry = crew.stream().filter(lowBounty).toList();
        // 3. Print the names and bounties of the filtered pirates

        //smallFry.forEach(pirate -> System.out.println(pirate.name + ": " + pirate.bounty));

        // 4. Use an iterator to remove pirates with the role of "Apprentice"

        Iterator<Pirate> iterator = crew.iterator();
        Pirate pirate = null;
        while (iterator.hasNext()) {
            pirate = iterator.next();
            if (pirate.role.equals("Apprentice")) {
                iterator.remove();
            }
        }

        // 5. Print the remaining pirates in the crew
        crew.forEach(p -> System.out.println(p.name + ": " + p.bounty));

        // Part C: Option 1 - Sort bigShots by bounty (highest first).
        /*
        Flips from low to high into high to low, allowing us to see the top bounty members
        Comparator.comparingInt(...) to compare pirates using an int field
        (p -> p.bounty) lets us use each pirate's bounty as field to compare
        .reversed() flips the order into high to low bounty
         */
        List<Pirate> sortedByBounty = bigShots.stream().sorted(Comparator.comparingInt((Pirate p) -> p.bounty)
                .reversed()).toList();
        System.out.println("\nBig shots sorted by bounty:");
        sortedByBounty.forEach(p -> System.out.println(p.name + " - " + p.bounty));

        // Part C: Option 2 - Group pirates by role and print each group.
        /*
        Lets us see the members in each role in a more accurate way instead of just having a list of crew members
         */
        Map<String, List<Pirate>> sortedByRoles = crew.stream().collect(Collectors.groupingBy(p -> p.role));
        sortedByRoles.forEach((role, pirates) -> {
            System.out.println("\n" + role + ": ");
            pirates.forEach(p -> System.out.println(p.name));
        });

        //Part C: Option 3 - Add a method reference for printing names only.
        /*
        replacing lambda function with shorter syntax allowing more concise and cleaner code
        .map(p -> p.name) turns pirate objects into string to print
         */
        System.out.println();
        crew.stream().map(p -> p.name).forEach(System.out::println);

        //Part C: Option 4 - Create a new list of just the pirate names using map and toList().
        /*
        List<String> to make new list and store string via map(p -> p.name)
         */
        List<String> pirateNames = crew.stream().map(p -> p.name).toList();
        System.out.println("\n" + pirateNames);

        //Part C: Option 5 - Use reduce to find the total bounty of all pirates.
        /*
        easier than running a loop, combines all the bounty into one
         */
        int totalBounty = crew.stream().map(p -> p.bounty).reduce(0, Integer::sum);
        System.out.println("\nCrew Bounty: " + totalBounty);

        //Part C: Option 6 - Use anyMatch to check if any pirate has a bounty over 200.
        /*
        returns boolean if pass or fail condition after checking every element without the need of manual loop
         */
        boolean over200 = crew.stream().anyMatch(p -> p.bounty > 200);
        System.out.println("\nOver 200? " + over200);
    }
}