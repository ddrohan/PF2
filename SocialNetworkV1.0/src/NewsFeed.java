import java.util.ArrayList;

public class NewsFeed {

    private ArrayList<MessagePost> posts;

    public NewsFeed() {
        posts = new ArrayList<MessagePost>();
    }

    public boolean addPost(MessagePost post) {
        return posts.add(post);
    }

    public String show() {
        String str = "";

        for(MessagePost post : posts) {
            str += post.display() + "\n";
        }

        if (str.isEmpty()){
            return "No Posts";
        }
        else {
            return str;
        }
    }

}
