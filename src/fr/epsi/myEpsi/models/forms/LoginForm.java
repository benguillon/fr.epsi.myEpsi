package fr.epsi.myEpsi.models.forms;

import fr.epsi.myEpsi.controlers.database.implementations.UserDaoImpl;
import fr.epsi.myEpsi.misc.HashUtil;
import fr.epsi.myEpsi.misc.ServletUtil;
import fr.epsi.myEpsi.models.beans.User;
import fr.epsi.myEpsi.models.beans.UserDefault;

import javax.servlet.http.HttpServletRequest;

/**
 * Login form to connect user
 */
public class LoginForm {

	/**
	 * Log in a user
	 *
	 * @param request Request from connection servlet
	 * @return The user, <code>UserDefault</code> otherwise
	 * @see UserDefault
	 */
	public static User loginUser(HttpServletRequest request) {
		// retrieve data from login form
		String mail = ServletUtil.retrieveValue(request, "mail");
		String password = ServletUtil.retrieveValue(request, "password");

		if (mail == null || password == null)
			return new UserDefault();

		// retrieve user from database
		User user = ((UserDaoImpl) request.getServletContext().getAttribute("userDao")).find(mail);

		if (user.getPassword().equals(HashUtil.hashPassword(password)))
			return user;
		else
			return new UserDefault();
	}
}
