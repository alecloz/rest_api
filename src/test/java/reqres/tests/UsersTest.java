package reqres.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqres.methods.UserMethods;


public class UsersTest extends BaseTest {
    UserMethods userMethods = new UserMethods();

    @Test
    @DisplayName("Тест на получение данных о пользователе")
    public void getSingleUserTest(){
        userMethods.getSingleUser();
    }

    @Test
    @DisplayName("Тест на отсутствие данных по несуществующему пользователю")
    public void userNotFoundTest(){
        userMethods.userNotFound();
    }

    @Test
    @DisplayName("Тест на создание пользователя")
    public void createUserTest(){
        userMethods.createUser();
    }

    @Test
    @DisplayName("Тест на обновление данных о пользователе")
    public void updateUserTest(){
        userMethods.updateUser();
    }

    @Test
    @DisplayName("Тест на удаление пользователя")
    public void deleteUserTest(){
        userMethods.deleteUser();
    }
}