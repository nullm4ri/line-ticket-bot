/**
 * @(#) FollowDao.class $version 2017. 04. 03
 *
 * Copyright 2017 Suhyun Kim. All rights Reserved.
 */
package com.suhyunkim.ticket.follow;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FollowDao
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
public interface FollowDao extends JpaRepository<Follower, Integer> {
	Follower findByUserId(String userId);
}