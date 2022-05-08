package com.toto.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "REPLY")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "CONTENT",nullable = false, length = 200)
	private String content;

	@ManyToOne
	@JoinColumn(name = "BOARD_ID")
	private Board board;
	
	@ManyToOne //Many = board, One = user
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@CreationTimestamp
	@Column(name = "CREATE_DATE", nullable = false)
	private Timestamp createDate;
}
