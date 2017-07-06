import java.util.Scanner;
import java.util.ArrayList;
public class Menu
{
    //Create a simple menu system for this program
    static Scanner Keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        int postOrder =1;
        String user = null;
        ArrayList<User> Users = new ArrayList<User>();
        ArrayList<Post>listPosts= new ArrayList<Post>();
        int option = 0;

        while(true)
        {
            System.out.println("Welcome to Micro Blog");
            System.out.println("Menu");
            System.out.println("1. Create a new user ");
            System.out.println("2. Become an existing user ");
            System.out.println("3. Create a post as the current user ");
            System.out.println("4. Print all posts ");
            System.out.println("5. Print all users ");
            System.out.println("6. Exit ");

            if (user != null&&!user.isEmpty())
            {
                System.out.println("You are currently user " + user + ".  What would you like to do? ");
            }
            System.out.print (" > ");
            
            while(!Keyboard.hasNextInt()||((option = Keyboard.nextInt())<1))
            {
                System.out.print("Please enter a number between 1 and 6.");
                Keyboard.nextLine();
            }
            Keyboard.nextLine();
            if(option <1 || option > 6)
            {
                System.out.println("Please enter a number between 1 and 6.");
            }
            System.out.println(" ");

            if (option == 1)
            {
                System.out.println("Name : ");
                String newName = Keyboard.nextLine();
                System.out.println("email address: ");
                String newEmail = Keyboard.nextLine();
                System.out.println("Username: ");
                String newUserName = Keyboard.nextLine();
                Boolean ckus= false;
                for( User ckusid : Users)
                {
                    if (ckusid.getUserName().equalsIgnoreCase(newName))
                    {
                        ckus = true;
                    }
                    if (ckus)
                    {
                        System.out.println("User name already exist. Please try again ");
                        newName = Keyboard.nextLine();                        
                    }
                }
                System.out.println(" Avatar : ");
                String newAvatar = Keyboard.nextLine();
                Users.add(new User(newAvatar, newUserName, newName,newEmail));
            }
            System.out.println("");
            if(option == 2)
            {
                for(User list : Users)
                {
                    System.out.println(list.getUserName());
                }
                System.out.print("Select the user: ");
                String destUserName = Keyboard.nextLine();
                Boolean userFound = false;
                for(User list : Users)
                {
                    if(list.getUserName().equalsIgnoreCase(destUserName))
                    {
                        user = list.getUserName();
                        userFound =true;
                    }
                }
                for(User list : Users)
                {
                    if(!userFound)
                    {
                        System.out.println("User not valid ");
                        break;
                    }
                }
            }
            
            first:
            if (option ==3) 
            {
                String currentAvatar = "";
                String currentName = "";
                String currentEmail = "";

                if (user == null)
                {

                    System.out.println(" Select an user ");
                    break first;
                }else {
                    for(User list : Users)
                    {
                        if (list.getUserName().equalsIgnoreCase(user))
                        {
                            currentName = list.getName();
                            currentEmail = list.getEmail();
                        }
                    }
                }

                String userLastPost = null;
                int lastPostOrder= 0 ;
                String lastPost = "";
                String lastWebSite = "";

                for (Post currentPost : listPosts)
                    if (currentPost.getUserName().equalsIgnoreCase(user))
                    {
                        userLastPost = currentPost.getPostInfo();
                        lastPostOrder = currentPost.getPostOrder();
                        lastPost = currentPost.getPost();
                        lastWebSite = currentPost.getWebSite();
                    }
                if (userLastPost != null)
                {
                    System.out.println("Post Order:  " + lastPostOrder);
                    System.out.println("Post Info:  " + lastPost);
                    System.out.println("Website Info:  " + lastWebSite);
                }
                System.out.println("You are currently user " + user + ". Whats is on your mind?");
                String createPost = Keyboard.nextLine();
                System.out.println(" Web address : ");
                String createLink = Keyboard.nextLine();
                Post singlePost = new Post(postOrder, currentName, currentEmail, createPost, user, createLink);
                listPosts.add(singlePost);                   

                System.out.println("");
                postOrder++;
            }
            if (option ==4)
            {
                if (listPosts !=null)
                {
                    for (Post list : listPosts)
                    {
                        System.out.println(list.getPostInfo());
                        System.out.println("Post Order:  " + list.getPostOrder());
                        System.out.println("Post Info:  " + list.getPost());
                        System.out.println("Website Info:  " + list.getWebSite());
                    }
                }
            }
            if (option == 5)
            {
                for (User list : Users)
                {
                    System.out.println(list.getUserInfo());
                    System.out.println("Post Order:  " + list.getUserName());
                    System.out.println("Post Info:  " + list.getName());
                    System.out.println("Website Info:  " + list.getEmail());
                    System.out.println("Avatar:  " + list.getAvatar());
                }
            }
            System.out.println("");
            if (option ==6)
            {
                break;
            }
        }
    }
}

                    
            
