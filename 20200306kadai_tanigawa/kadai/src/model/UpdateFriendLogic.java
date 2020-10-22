package model;

import dao.FriendDAO;

public class UpdateFriendLogic {

	public void execute(Friend friend){
		FriendDAO dao = new FriendDAO();
		dao.update(friend);
	}

}
