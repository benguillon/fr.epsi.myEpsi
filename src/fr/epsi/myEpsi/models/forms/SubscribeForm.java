package fr.epsi.myEpsi.models.forms;

import fr.epsi.myEpsi.controlers.database.interfaces.IUserDao;
import fr.epsi.myEpsi.misc.HashUtil;
import fr.epsi.myEpsi.misc.ServletUtil;
import fr.epsi.myEpsi.models.beans.User;
import fr.epsi.myEpsi.models.beans.UserDefault;

import javax.servlet.http.HttpServletRequest;

/**
 * Subscribe form to register user in database
 */
public class SubscribeForm {

	/**
	 * Register a user in database
	 *
	 * @param request The request from subscribe servlet
	 * @return The user that has been registered, <code>UserDefault</code> otherwise
	 * @see UserDefault
	 */
	public static User registerUser(HttpServletRequest request) {
		// retrieve data from subscribe form
		String mail = ServletUtil.retrieveValue(request, "mail");
		String pseudo = ServletUtil.retrieveValue(request, "pseudo");
		String password = ServletUtil.retrieveValue(request, "password");
		String confirm = ServletUtil.retrieveValue(request, "confirm");

		if (mail.isEmpty() || mail.contains("@root") || password.isEmpty() || confirm.isEmpty())
			return new UserDefault();

		if (!password.equals(confirm))
			return new UserDefault();

		User user = new User();
		user.setMail(mail);
		user.setPseudo(pseudo);
		user.setPassword(HashUtil.hashPassword(password));

		if (((IUserDao) request.getSession().getAttribute("userDao")).create(user))
			return user;
		else
			return new UserDefault();
	}
}
