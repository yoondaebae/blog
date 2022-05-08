package com.toto.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "BOARD")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE",nullable = false, length = 100)
	private String title;
	
	@Column(name = "CONTENT")
	@Lob
	private String content;
	
	@Column(name = "COUNT",nullable = false)
	@ColumnDefault("0")
	private int count;

	@ManyToOne(fetch = FetchType.EAGER) //Many = board, One = user
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER)
	private List<Reply> replyList;
	
	@CreationTimestamp
	@Column(name = "CREATE_DATE", nullable = false)
	private Timestamp createDate;
}
