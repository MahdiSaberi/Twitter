import com.twitter.util.Context;
import com.twitter.util.DatabaseUtil;
import com.twitter.util.Operation;

public class Application {
    public static void main(String[] args) {
        DatabaseUtil.getEntityManager();
        Operation.menu.start();

    }
}
