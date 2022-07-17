import com.twitter.domain.Tweet;
import com.twitter.domain.User;
import com.twitter.util.Context;
import com.twitter.util.DatabaseUtil;
import com.twitter.util.Menu;
import com.twitter.util.Operation;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Context.getEntityManager();
        Menu menu = new Menu();
        menu.start();
    }
}
