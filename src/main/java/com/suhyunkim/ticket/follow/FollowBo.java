/**
 * @(#) FollowBo.class $version 2017. 04. 03
 *
 * Copyright 2017 Suhyun Kim. All rights Reserved.
 */
package com.suhyunkim.ticket.follow;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FollowBo
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Service
public class FollowBo {
	@Autowired
	private FollowDao followDao;

	public void follow(String userId) {
		Follower follower = new Follower(userId, new Date());
		followDao.save(follower);
	}

	public void unfollow(String userId) {
		Follower follower = followDao.findByUserId(userId);
		if (follower != null) {
			followDao.delete(follower);
		}
	}
}