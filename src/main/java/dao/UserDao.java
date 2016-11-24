package dao;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static db_util.DataSource.createConnection;


public class UserDao {
    public static void main(String[] args) {
        List list = findAll();
        System.out.println(list.get(0));
    }


        private static UserDao userDao;
        private static final String SELECT_ALL_USERS = "select * from user";




//
//        public static UserDao getInstance() {
//            if (userDao == null) {
//                synchronized (UserDaoImpl.class) {
//                    if (userDao == null) {
//                        userDao = new UserDaoImpl();
//                    }
//                }
//            }
//            return userDao;
//        }


        public static List<User> findAll() {
            Connection connection = createConnection();
            List<User> users = new LinkedList<>();
            try {
                PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setFirstName(resultSet.getString("firstName"));


                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return users;
        }


        public User findById(long id) {
            return null;
        }


        public void delete(long id) {

        }


        public boolean create(User user) {
            return false;
        }
    }


