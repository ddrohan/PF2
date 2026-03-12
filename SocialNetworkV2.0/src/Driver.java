import javax.swing.*;

public class Driver {

    private NewsFeed newsFeed = new NewsFeed();

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        runMenu();
    }

    private int mainMenu(){
        return JScannerInput.readNextInt("""
               Social Network Menu
                  ---------------------
                  1) Add a Message Post
                  2) List all Posts
                  3) Update a Message Post
                  4) Delete a Message Post
                  ---------------------
                  0) Exit
               ==>>""");
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addMessagePost();
                case 2 -> showPosts();
                case 3 -> updateMessagePost();
                case 4 -> deleteMessagePost();
                default -> JScannerInput.showErrorMessage("Invalid option entered: " + option,"Error");
            }

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        JScannerInput.showMessage("Exiting...bye","Exit App");
        System.exit(0);
    }

    //gather the message post data from the user and add the new message post object to the arraylist
    private void addMessagePost(){

        String authorName = JScannerInput.readNextLine("Enter the Author Name:  ");
        String message = JScannerInput.readNextLine("Enter the Message:  ");

        boolean isAdded = newsFeed.addPost(new MessagePost(authorName, message));
        if (isAdded){
            JScannerInput.showMessage("Post Added Successfully","App Info");
        }
        else{
            JScannerInput.showErrorMessage("No Post Added","Error");
        }
    }

    //print the posts in newsfeed i.e. array list.
    private void showPosts(){
        JScannerInput.showMessage(newsFeed.show(),"Message List");
    }

    //ask the user to enter the index of the object to update, and assuming it's valid,
    //gather the new data from the user and update the selected object.
    private void updateMessagePost(){
        showPosts();
        if (newsFeed.numberOfPosts() > 0){
            //only ask the user to choose the object to update if objects exist
            int indexToUpdate = JScannerInput.readNextInt("Enter the index of the message to update ==> ");
            if (newsFeed.isValidIndex(indexToUpdate)){
                String author = JScannerInput.readNextLine("Enter the Author Name:  ");
                String message = JScannerInput.readNextLine("Enter the Message:  ");

                //pass the index of the product and the new product details to Store for updating and check for success.
                if (newsFeed.updateMessagePost(indexToUpdate, new MessagePost(author, message))){
                    JScannerInput.showMessage("Update Successful","Update");
                }
                else{
                   JScannerInput.showErrorMessage("Update NOT Successful","Error");
                }
            }
            else{
                JScannerInput.showMessage("There are no messages for this index number","Info Message");
            }
        }
    }

    private void deleteMessagePost(){
        showPosts();
        if (newsFeed.numberOfPosts() > 0){
            //only ask the user to choose the message post to delete if posts exist
            int indexToDelete = JScannerInput.readNextInt("Enter the index of the messgae post to delete ==> ");
            //pass the index of the message post to NewsFeed for deleting and check for success.
            MessagePost messagePostToDelete = newsFeed.deleteMessagePost(indexToDelete);
            if (messagePostToDelete != null){
                JScannerInput.showMessage("Delete Successful! Deleted message post: " + messagePostToDelete.display(),"Delete Message");
            }
            else{
                JScannerInput.showErrorMessage("Delete NOT Successful","Delete Error Message");
            }
        }
    }

}
