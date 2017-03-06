package Services;
import Domain.User;
import Dao.DaoUser;
/**
 * Created by atulsharma on 21/02/17.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

interface user_services
{
    void addUser() throws FileNotFoundException, SQLException;
}
public class UserServices  implements user_services{
  public void addUser() throws FileNotFoundException, SQLException {
      String us_file="Resources/UserData.txt";
      BufferedReader reader = new BufferedReader(new FileReader(us_file));

      DaoUser obj=new DaoUser();



      String space="";

      try {
          while((space=reader.readLine())!=null)
          {
              User ud=new User();
           String str[]=space.split(",");
              ud.setUserId(Integer.parseInt(str[0]));
              ud.setUserName(str[1]);

              ud.setUserAdd(str[2]);
              ud.setEmail(str[3]);
              try {
                  obj.insert(ud);
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }


  }

}
