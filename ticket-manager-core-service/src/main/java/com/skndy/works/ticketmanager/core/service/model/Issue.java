package com.skndy.works.ticketmanager.core.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "issue_list_trn")
@Data
public class Issue {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="issue_id")
	private int issueId;
	
	@Column(name="issue_title")
	private String title;
	
	@Column(name="issue_desc")
	private String desc;
}
