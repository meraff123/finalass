package repository;

import java.util.ArrayList;
import java.util.List;

import Domain.User;

public class UserRepository {
	private List<User> users = new ArrayList<>();

	  public User save(User user) {
	    user.setUserId((long) (users.size() + 1));
	    users.add(user);
	    return user;
	  }
	}