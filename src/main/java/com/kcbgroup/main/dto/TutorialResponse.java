package com.kcbgroup.main.dto;

public class TutorialResponse {
	private Long commentid;
	private Long tutorialid;
	private String content;
	private String description;
	private String title;
	private boolean published;

	public TutorialResponse() {
		
	}

	public TutorialResponse(Long commentid, Long tutorialid, String content, String description, String title,
			boolean published) {
		this.commentid = commentid;
		this.tutorialid = tutorialid;
		this.content = content;
		this.description = description;
		this.title = title;
		this.published = published;
	}

	public Long getCommentid() {
		return commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}

	public Long getTutorialid() {
		return tutorialid;
	}

	public void setTutorialid(Long tutorialid) {
		this.tutorialid = tutorialid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
}
