import com.twitter.util.Context;
import com.twitter.util.Operation;

public class Application {
    public static void main(String[] args) {

        Context.begin();
        System.out.println("Done!");
        Context.commit();

        //Operation.menu.start();

    }
}
