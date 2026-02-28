public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        // add the main stops
        Position<String> paris = itinerary.addLast("Eiffel Tower");
        Position<String> rome = itinerary.addLast("Colosseum");
        itinerary.addLast("Big Ben");

        // insert a stop in between
        itinerary.addAfter(paris, "Louvre Museum");

        // change one stop just to show set works
        itinerary.set(rome, "Roman Forum");

        System.out.println("Final itinerary:");

        // this for each loop proves the iterator works
        for (String stop : itinerary) {
            System.out.println(stop);
        }
    }
}
