/**
 * @(#) Follower.class $version 2017. 04. 03
 *
 * Copyright 2017 Suhyun Kim. All rights Reserved.
 */
package com.suhyunkim.ticket.follow;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Follower
 *
 * @author Suhyun Kim (rosebud499@gmail.com)
 */
@Entity
@Data
public class Follower {
	@Id
	@GeneratedValue
	private int id;

	private String userId;
	private Date followDate;

	public Follower(String userId, Date followDate) {
		this.userId = userId;
		this.followDate = followDate;
	}
}