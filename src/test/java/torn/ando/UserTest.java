package torn.ando;


import org.junit.jupiter.api.Test;
import torn.ando.budgetmaster.User;

public class UserTest {

    @Test
    public void createExpense(){
        User user = new User("john",500_000);
    }
}
