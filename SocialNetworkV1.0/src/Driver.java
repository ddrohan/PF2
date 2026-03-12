public class Driver {

    private NewsFeed newsFeed = new NewsFeed();

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        runMenu();
    }

    private int mainMenu(){
        return ScannerInput.readNextInt("""
               Social Network Menu
                  ---------------------
                  1) Add a Message Post
                  2) List all Posts
                  ---------------------
                  0) Exit
               ==>>  """);
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addMessagePost();
                case 2 -> showPosts();
                default -> System.out.println("Invalid option entered: " + option);
            }

            //pause the program so that the user can read what we just printed to the terminal window
            ScannerInput.readNextLine("\nPress enter key to continue...");

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting...bye");
        System.exit(0);
    }

    //gather the message post data from the user and add the new message post object to the arraylist
    private void addMessagePost(){

        String authorName = ScannerInput.readNextLine("Enter the Author Name:  ");
        String message = ScannerInput.readNextLine("Enter the Message:  ");

        boolean isAdded = newsFeed.addPost(new MessagePost(authorName, message));
        if (isAdded){
            System.out.println("Post Added Successfully");
        }
        else{
            System.out.println("No Post Added");
        }
    }

    //print the posts in newsfeed i.e. array list.
    private void showPosts(){
        System.out.println("List of Messages are:");
        System.out.println(newsFeed.show());
    }

}
